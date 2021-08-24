package com.flycat.common_practice.thread.threadPool;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程执行器
 * 1，维护一个固定大小线程池，
 * 2，进行不断地获取任务，并执行
 */
public class ThreadExecutor {

    private Integer poolSize;

    private RunnableTaskQueue taskQueue;

    private List<Thread> threadList = new ArrayList<>();


    public ThreadExecutor(int poolSize) {
        this.poolSize = poolSize;
        this.taskQueue = new RunnableTaskQueue();
        for (int i = 0; i < poolSize; i++) {
            this.initThreadExecutor();
        }
    }

    private void initThreadExecutor() {
        if (threadList.size() < poolSize) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = taskQueue.getTask();
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadList.add(thread);
            thread.start();
        }
    }

    public void execute(Runnable runnable) {
        taskQueue.addTask(runnable);
    }
}
