package practice.thread;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable 线程 的call 方法 会返回线程的 返回值
 * 他的调用  要经过 FutureTask 的封装 后者实现 Runable接口 可以用Thread启动
 * get 方法将导致 当前线程阻塞
 */
public class MyThread_Callable {

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)()->{
                int i;
                for (i = 0;i<100;i++)
                    System.out.println(Thread.currentThread().getName()+i);
                return i;
        });
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                try {
                    new Thread(task,"有返回值的线程").start();
                    System.out.println("返回值 " +task.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                continue;
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
