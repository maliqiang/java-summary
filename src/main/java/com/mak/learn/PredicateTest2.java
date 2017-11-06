package com.mak.learn;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PredicateTest2
{
    public static void main(String[] args)
	{
		// 创建books集合、为books集合添加元素的代码与前一个程序相同。
		Collection<String> books = new HashSet<>();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂iOS讲义"));
		books.add(new String("疯狂Ajax讲义"));
		books.add(new String("疯狂Android讲义"));
		// 统计书名包含“疯狂”子串的图书数量
		System.out.println(calAll(books , ele->ele.contains("疯狂")));
		// 统计书名包含“Java”子串的图书数量
		System.out.println(calAll(books , ele->ele.contains("Java")));
		// 统计书名字符串长度大于10的图书数量
		System.out.println(calAll(books , ele->ele.length() > 20));
		
		// 使用Lambda表达式（目标类型是Predicate）过滤集合
		books.removeIf(ele -> ((String)ele).length() < 10);//批量去除满足filter的元素
		System.out.println(books);
	}


	public static int calAll(Collection<String> books , Predicate<String> p)
	{
		return  (int)books.stream().filter(p).count();
	}
}