package com.mak.extensions.video;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class ConverVideo {
  // ffmpeg.exe的目录
  private static String FFMPEG_PATH = "ffmpeg";

  private static String BASE_PATH = "D:\\data\\temp\\";

  public static void main(String[] args) throws Exception {
    String systemType = System.getProperty("os.name");
    log.info("当前运行环境：{}", systemType);

    BASE_PATH = "D:\\data\\temp\\";
    if (args.length == 1) {
      throw new Exception("请检查参数！");
    }
    if (args.length == 2) {
      if (null != args[0]) {
        FFMPEG_PATH = args[0];
      }
      if (null != args[1]) {
        BASE_PATH = args[1];
      }
    }

    // 需要转换的视频目录
    try {
      List<String> files =
          Files.list(Paths.get(BASE_PATH))
              .map(p -> p.getFileName().toString())
              .filter(f -> f.endsWith(".dav"))
              .collect(Collectors.toList());
      if (files.size() > 0) {
        log.info("files count:{}", files.size());
        AtomicInteger covertSuccessCount = new AtomicInteger(0);
        // 开始转换
        files.forEach(
            f -> {
              try {
                int type = checkContentType(f);
                if (type == 0) {
                  log.info("正在处理的视频：{}", f);
                  DAV2MP4(BASE_PATH + f, replaceIgnoreString(f));
                  covertSuccessCount.getAndIncrement();
                }

              } catch (IOException e) {
                e.printStackTrace();
              }
            });
        log.info("总共处理视频{}个", covertSuccessCount.get());
      }
    } catch (Exception e) {

    }
  }

  private static String replaceIgnoreString(String f) {
    String fileName = f.substring(0, f.lastIndexOf("."));
    if (f.contains("北湖站_北湖站")) {
      fileName = fileName.replace("北湖站_北湖站", "NW001");
    } else {
      fileName = fileName.replace("北湖站", "NW001");
    }
    return BASE_PATH + fileName;
  }

  /**
   * 将原视频dav处理成MP4格式
   *
   * @param oldfilepath
   * @param savePath
   * @return
   * @throws IOException
   */
  private static boolean DAV2MP4(String oldfilepath, String savePath) throws IOException {

    File tempFile = new File(oldfilepath);

    String path = tempFile.getParent();
    File file = new File(path);
    if (!file.exists()) {
      file.mkdirs();
    }
    List commend = new ArrayList();
    // ffmpeg -i "北湖站_20180814062533_20180814062718.dav" -vcodec copy -acodec copy "test.mp4"
    buildCommand(oldfilepath, commend);
    commend.add(savePath + ".mp4");
    try {
      ProcessBuilder builder = new ProcessBuilder();
      builder.command(commend);
      Process p = builder.start();
      doWaitFor(p);
      p.destroy();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  private static boolean DAV2Flv(String oldfilepath, String savePath) throws IOException {

    File tempFile = new File(oldfilepath);

    String path = tempFile.getParent();
    File file = new File(path);
    if (!file.exists()) {
      file.mkdirs();
    }
    List commend = new ArrayList();
    // ffmpeg -i "北湖站_20180814062533_20180814062718.dav" -vcodec copy -acodec copy "test.mp4"
    buildCommand(oldfilepath, commend);
    commend.add(savePath + ".flv");
    try {
      ProcessBuilder builder = new ProcessBuilder();
      builder.command(commend);
      Process p = builder.start();
      doWaitFor(p);
      p.destroy();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 组装命令行
   *
   * @param oldfilepath
   * @param commend
   */
  private static void buildCommand(String oldfilepath, List commend) {
    commend.add(FFMPEG_PATH);
    commend.add("-i");
    commend.add(oldfilepath);
    commend.add("-vcodec");
    commend.add("copy");
    commend.add("-acodec");
    commend.add("copy");
  }

  /**
   * 检查格式是否支持
   *
   * @param filename
   * @return
   */
  private static int checkContentType(String filename) {
    String type = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    // type = 0 ffmpeg可解析；type= 1ffmpeg不可解析，先使用mencoder转为AVI格式
    if (type.equals("avi")) {
      return 0;
    } else if (type.equals("mpg")) {
      return 0;
    } else if (type.equals("wmv")) {
      return 0;
    } else if (type.equals("3gp")) {
      return 0;
    } else if (type.equals("mov")) {
      return 0;
    } else if (type.equals("mp4")) {
      return 0;
    } else if (type.equals("asf")) {
      return 0;
    } else if (type.equals("asx")) {
      return 0;
    } else if (type.equals("flv")) {
      return 0;
    } else if (type.equals("dav")) {
      return 0;
    } else if (type.equals("wmv9")) {
      return 1;
    } else if (type.equals("rm")) {
      return 1;
    } else if (type.equals("rmvb")) {
      return 1;
    }
    return 9;
  }

  public static int doWaitFor(Process p) {
    InputStream in = null;
    InputStream err = null;
    int exitValue = -1; // returned to caller when p is finished
    try {
      in = p.getInputStream();
      err = p.getErrorStream();
      boolean finished = false; // Set to true when p is finished

      while (!finished) {
        try {
          while (in.available() > 0) {
            Character c = new Character((char) in.read());
            // log.debug("-----------"+c);
          }
          while (err.available() > 0) {
            Character c = new Character((char) err.read());
            // log.debug("-----------"+c);
          }

          exitValue = p.exitValue();
          finished = true;

        } catch (IllegalThreadStateException e) {
          Thread.currentThread().sleep(500);
        }
      }
    } catch (Exception e) {
      log.error("doWaitFor();: unexpected exception - " + e.getMessage());
    } finally {
      try {
        if (in != null) {
          in.close();
        }

      } catch (IOException e) {
        log.debug(e.getMessage());
      }
      if (err != null) {
        try {
          err.close();
        } catch (IOException e) {
          log.debug(e.getMessage());
        }
      }
    }
    return exitValue;
  }

  public String sumTime(long ms) {
    int ss = 1000;
    long mi = ss * 60;
    long hh = mi * 60;
    long dd = hh * 24;

    long day = ms / dd;
    long hour = (ms - day * dd) / hh;
    long minute = (ms - day * dd - hour * hh) / mi;
    long second = (ms - day * dd - hour * hh - minute * mi) / ss;
    long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

    String strDay = day < 10 ? "0" + day + "天" : "" + day + "天";
    String strHour = hour < 10 ? "0" + hour + "小时" : "" + hour + "小时";
    String strMinute = minute < 10 ? "0" + minute + "分" : "" + minute + "分";
    String strSecond = second < 10 ? "0" + second + "秒" : "" + second + "秒";
    String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
    strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond + "毫秒" : "" + strMilliSecond + " 毫秒";
    return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
  }
}
