/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@
 */

package com.mak.learn;

import com.alibaba.fastjson.JSON;
import com.mak.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author maliqiang
 * @version 1.0
 * @description:对一个对象进行部分属性的筛选和部分属性分组的操作，最终组成一个hashmap
 * @date 2018/6/3 下午7:54
 */
//@Slf4j
public class GroupByTest {

    @Test
    public void testGroupBy(){
        User user = new User(1, "mark", 11);
        User user1 = new User(1, "mark", 12);
        User user2 = new User(1, "mark", 13);
        User user3 = new User(1, "mark", 14);
        User user4 = new User(1, "mark", 15);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Map<Integer,List<Integer>> result = users.stream()
                .collect(Collectors.groupingBy(User::getAge,
                        Collectors.mapping(User::getCoverUrl,Collectors.toList())));

//        log.info(JSON.toJSONString(result));
    }

    @Test
    public void testRemoveValue(){
        List<Integer> ids = new ArrayList<>();
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>(ids);

        ids.add(11);
        ids.add(22);
        ids.add(33);

        int[] excludeIds = new int[]{11,22};
        //error
//        for (Integer id : cowList) {
//            for (int excludeId : excludeIds) {
//                if (id.equals(excludeId)) {
//                    cowList.remove(excludeId);
//                }
//            }
//        }

        //correct
        Iterator<Integer> iter = ids.iterator();
        while (iter.hasNext()) {
            Integer item = iter.next();
            for (int excludeId : excludeIds) {
                if (item.equals(excludeId)) {
                    iter.remove();
                }
            }
        }

        System.out.println(JSON.toJSONString(ids));
    }
}
