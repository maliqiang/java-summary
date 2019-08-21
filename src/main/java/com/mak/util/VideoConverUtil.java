//package com.mak.util;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
///**
// * @author Siyuan.mlq
// * @version 1.0
// * @description
// * @since 2018/8/31
// */
//@Slf4j
//public class VideoConverUtil {
//  private Date dt;
//  private long begintime;
//  /** ffmpeg.exe的目录 */
//  private static String FFMPEG_PATH =
//      "D:\\SoftWare\\ffmpeg-20180829-d71dfc0-win64-static\\bin\\ffmpeg.exe";
//
//  String targetPath = "";
//
//  public static void main(String[] args) {
//    String basePath = "D:\\temp_data\\video\\";
//    String targetPath = basePath;
//
//    // 需要转换的视频目录
//    try {
//      List<String> files =
//          Files.list(Paths.get("D:\\temp_data\\video"))
//              .map(p -> p.getFileName().toString())
//              .filter(f -> f.endsWith(".dav"))
//              .collect(Collectors.toList());
//      if (files.size() > 0) {
//        log.info("files count:{}", files.size());
//        files.forEach(System.out::println);
//      }
//      AtomicInteger covertSuccessCount = new AtomicInteger(0);
//      // 开始转换
//      boolean result = processMP4(basePath + files.get(0), basePath + "test.mp4");
//      files.forEach(
//          f -> {
//            Runtime rt = Runtime.getRuntime();
//            String cmd =
//                FFMPEG_PATH
//                    + " -i "
//                    + basePath
//                    + f
//                    + "-vcodec copy -acodec copy "
//                    + basePath
//                    + ".mp4";
//            try {
//              Process p = rt.exec(cmd);
//            } catch (IOException e) {
//              e.printStackTrace();
//            }
//            //                              boolean result =
//            // processMP4(basePath+f,basePath+"test.mp4");
//            //                              if (result) {
//            //                                  covertSuccessCount.getAndIncrement();
//            //                              }
//            log.info("The success file is :{}", covertSuccessCount.get());
//          });
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static boolean beginConver() {
////     此前配置绝对路径，后经设置环境变量后可省略 路径 例：d:/ffmpeg/bin/ffmpeg.exe
//     String winFfmpegPath = "ffmpeg";
//     String linuxFfmpegPath = "ffmpeg";
//     String systemType = System.getProperty("os.name");
//     FFMPEG_PATH = (systemType.toLowerCase().indexOf("win") == -1) ? linuxFfmpegPath :
//     winFfmpegPath;
//    File fi = new File(PATH);
//    filename = fi.getName();
//    filerealname = filename.substring(0, filename.lastIndexOf(".")).toLowerCase();
//    log.debug("------------接收到文件(" + PATH + ")需要转换------------ ");
//    if (!checkfile(PATH)) {
//      log.debug(PATH + "文件不存在" + " ");
//      return false;
//    }
//    dt = new Date();
//    begintime = dt.getTime();
//    log.debug("----------------开始转文件(" + PATH + ")--------------- ");
//    if (process()) {
//      Date dt2 = new Date();
//      long endtime = dt2.getTime();
//      long timecha = (endtime - begintime);
//      String totaltime = sumTime(timecha);
//      log.debug("coverting is success，cost time:" + totaltime);
//      PATH = null;
//      return true;
//    } else {
//      PATH = null;
//      return false;
//    }
//  }
//
//  // 转码为MP4格式
//  private static boolean processMP4(String oldfilepath, String targetPath) {
//
//    if (!checkfile(oldfilepath)) {
//      log.debug("--------------" + oldfilepath + " is not file");
//      return false;
//    }
//    File tempFile = new File(oldfilepath);
//
//    //    flvfolder = oldfilepath.substring(0, flvfolder.lastIndexOf("/"));
//    String path = tempFile.getParent();
//    File file = new File(path);
//    if (!file.exists()) {
//      file.mkdirs();
//    }
//    List commend = new ArrayList();
//    // ffmpeg -i "北湖站_20180814062533_20180814062718.dav" -vcodec copy -acodec copy "test.mp4"
//    String systemType = System.getProperty("os.name");
//    //    if (systemType.toLowerCase().indexOf("win") != -1){ targetPath;}
//    commend.add(FFMPEG_PATH);
//    commend.add("-i");
//    commend.add(oldfilepath);
//    commend.add("-vcodec");
//    commend.add("copy");
//    commend.add("-acodec");
//    commend.add("copy");
//    commend.add(targetPath);
//    try {
//      ProcessBuilder builder = new ProcessBuilder();
//      builder.command(commend);
//      Process p = builder.start();
//      doWaitFor(p);
//      p.destroy();
//      // deleteFile(oldfilepath);
//      return true;
//    } catch (Exception e) {
//      e.printStackTrace();
//      return false;
//    }
//  }
//
//  public static int doWaitFor(Process p) {
//    InputStream in = null;
//    InputStream err = null;
//    int exitValue = -1; // returned to caller when p is finished
//    try {
//      in = p.getInputStream();
//      err = p.getErrorStream();
//      boolean finished = false; // Set to true when p is finished
//
//      while (!finished) {
//        try {
//          while (in.available() > 0) {
//            Character c = new Character((char) in.read());
//            // log.debug("-----------"+c);
//          }
//          while (err.available() > 0) {
//            Character c = new Character((char) err.read());
//            // log.debug("-----------"+c);
//          }
//
//          exitValue = p.exitValue();
//          finished = true;
//
//        } catch (IllegalThreadStateException e) {
//          Thread.currentThread().sleep(500);
//        }
//      }
//    } catch (Exception e) {
//      log.error("doWaitFor();: unexpected exception - " + e.getMessage());
//    } finally {
//      try {
//        if (in != null) {
//          in.close();
//        }
//
//      } catch (IOException e) {
//        log.debug(e.getMessage());
//      }
//      if (err != null) {
//        try {
//          err.close();
//        } catch (IOException e) {
//          log.debug(e.getMessage());
//        }
//      }
//    }
//    return exitValue;
//  }
//
//  public void deleteFile(String filepath) {
//    File file = new File(filepath);
//    if (PATH.equals(filepath)) {
//      if (file.delete()) {
//        log.debug("文件" + filepath + "已删除");
//      }
//    } else {
//      if (file.delete()) {
//        log.debug("文件" + filepath + "已删除 ");
//      }
//      File filedelete2 = new File(PATH);
//      if (filedelete2.delete()) {
//        log.debug("文件" + PATH + "已删除");
//      }
//    }
//  }
//
//  public String sumTime(long ms) {
//    int ss = 1000;
//    long mi = ss * 60;
//    long hh = mi * 60;
//    long dd = hh * 24;
//
//    long day = ms / dd;
//    long hour = (ms - day * dd) / hh;
//    long minute = (ms - day * dd - hour * hh) / mi;
//    long second = (ms - day * dd - hour * hh - minute * mi) / ss;
//    long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
//
//    String strDay = day < 10 ? "0" + day + "天" : "" + day + "天";
//    String strHour = hour < 10 ? "0" + hour + "小时" : "" + hour + "小时";
//    String strMinute = minute < 10 ? "0" + minute + "分" : "" + minute + "分";
//    String strSecond = second < 10 ? "0" + second + "秒" : "" + second + "秒";
//    String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
//    strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond + "毫秒" : "" + strMilliSecond + " 毫秒";
//    return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
//  }
//
//  private static boolean checkfile(String path) {
//    File file = new File(path);
//    if (!file.isFile()) {
//      return false;
//    }
//    return true;
//  }
//}
