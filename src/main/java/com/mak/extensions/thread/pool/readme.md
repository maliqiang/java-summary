* ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 
* ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
* ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
* ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务