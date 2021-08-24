package com.flycat.common_practice.thread.threadPool;

import java.util.LinkedList;

/**
 * 可执行任务队列
 * 1，添加任务时加锁
 * 2，获取任务时加锁，如果队列为空则等待（阻塞）
 *
 */
public class RunnableTaskQueue {
    private final LinkedList<Runnable> tasks = new LinkedList<>();

    public Runnable getTask() throws InterruptedException {
        synchronized (tasks) {
            while (tasks.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " task queue is empty ,i am waiting ....");
                tasks.wait();
            }
            return tasks.removeFirst();
        }
    }

    public void addTask(Runnable runnable) {
        synchronized (tasks) {
            tasks.add(runnable);
            tasks.notifyAll();
        }
    }

}
