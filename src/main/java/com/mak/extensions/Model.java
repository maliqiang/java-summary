package com.mak.extensions;

public interface Model {
  Runnable newRunnableConsumer();
  Runnable newRunnableProducer();
}