/**
 * @file Base64Test.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.learn;

import org.junit.Test;

import java.io.*;
import java.util.Base64;

/**
 * base64在Java8成为了标准类库的一部分
 * @author maliqiang
 * @create 2017-11-07
 * @version 1.0
 */
public class Base64Test {

    @Test
    public void encode(){
        File file = new File("F:\\Learn\\java8\\src\\main\\resources\\header.jpg");
        try {
           InputStream is = new FileInputStream(file);
           byte data[] = new byte[is.available()];
            is.read(data);
            is.close();
            Base64.Encoder base64  = Base64.getEncoder();
            String base64Str = base64.encodeToString(data);
            StringBuffer stringBuffer = new StringBuffer("data:image/jpeg;base64,");
            stringBuffer.append(base64Str);
            System.out.println(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
