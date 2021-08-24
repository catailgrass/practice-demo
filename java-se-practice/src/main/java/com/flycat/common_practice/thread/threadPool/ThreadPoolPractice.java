package com.flycat.common_practice.thread.threadPool;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 手动实现线程池
 * 1，一个任务队列，可以添加、取出任务 由linkedlist实现
 * 2,一个固定大小的线程池，可以从任务队列中取任务执行
 *
 */
public class ThreadPoolPractice {

    public static void client1() {
        ThreadExecutor executor = new ThreadExecutor(5);
        Stream.iterate(1,item->item+1).limit(10).forEach((item)->{
            executor.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+" execute this task");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public static void client2() {
        ThreadExecutor executor = new ThreadExecutor(5);
        Stream.iterate(1,item->item+1).limit(10).forEach((item)->{
            try {
                if (item % 2 == 0) {
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+" execute this task");
            });
        });
    }

    public static void main(String[] args) {

        client2();

    }
}
