package com.mak.skill.chaincoding;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description
 * @since 2019/5/7
 */
public class BuilderDemo {

  private String env;

  private String url;

  private int expireTime;

  public static BuilderDemo builder() {
    return new BuilderDemo();
  }

  public BuilderDemo env(String env) {
    this.env = env;
    return this;
  }

  public BuilderDemo url(String url) {
    this.url = url;
    return this;
  }

  public BuilderDemo expireTime(int expireTime) {
    this.expireTime = expireTime;
      return this;
  }

    @Override
    public String toString() {
        return "BuilderDemo{" +
                "env='" + env + '\'' +
                ", url='" + url + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }

    public BuilderDemo build() {
    return this;
  }



}
