package com.gds.springbootdemo.count;
import com.gds.springbootdemo.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 龚道松
 * @date 2019年3月31日上午9:36:37
 * @version 1.0
 */
@Slf4j
public class CountExample {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static AtomicInteger count = new AtomicInteger(0);
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
        log.info("count值是：" +count.get());
    }

    private static void add() {
        count.incrementAndGet();
    }
}
