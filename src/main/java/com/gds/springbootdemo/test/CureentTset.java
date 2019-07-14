package com.gds.springbootdemo.test;

/**
 * @Author 龚道松
 * @Date 2019/3/31 0031 11:54
 * @Wersion 1.0
 **/
/**
 *
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.gds.springbootdemo.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 龚道松
 * @date 2019年3月31日上午9:36:37
 * @version 1.0
 */
@Slf4j
public class CureentTset {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch downLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("InterruptedException", e);
                    e.printStackTrace();
                }
                downLatch.countDown();
            });
        }
        downLatch.await();
        service.shutdown();
        log.info("count值是：" +count);
    }

    private static void add() {
        count++;
    }
}
