package com.mak.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


/**
 * base64图片转换工具类
 *
 * @author maliqiang
 * @version 1.0
 */
public class Base64Img {
    /**
     * @param imgURL 网络资源位置
     * @return Base64字符串
     * @Title: GetImageStrFromUrl
     * @Description: 将一张网络图片转化成Base64字符串
     */
    public static String GetImageStrFromUrl(String imgURL) {
        byte[] data = null;
        try {
            // 创建URL  
            URL url = new URL(imgURL);
            // 创建链接  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            data = new byte[inStream.available()];
            inStream.read(data);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码  
        Base64.Encoder encoder = Base64.getEncoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encodeToString(data);
    }

    /**
     * @param imgPath
     * @return
     * @Title: GetImageStrFromPath
     * @Description: 将一张本地图片转化成Base64字符串
     */
    public static String GetImageStrFromPath(String imgPath) {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组  
        try {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码  
        Base64.Encoder encoder = Base64.getEncoder();
        // 返回Base64编码过的字节数组字符串  
        return encoder.encodeToString(data);
    }

    /**
     * @param imgStr
     * @return
     * @Title: GenerateImage
     * @Description: TODO(base64字符串转化成图片)
     */
    public static boolean GenerateImage(String imgStr, String filePath) {
        // 图像数据为空
        if (imgStr == null) {
            return false;
        }
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码  
            byte[] b = decoder.decode(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据  
                    b[i] += 256;
                }
            }
            // 生成jpeg图片  
            String imgFilePath = "d://222.jpg";
            if (filePath.trim().length() == 0) {
                filePath = "";
            }
            OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}