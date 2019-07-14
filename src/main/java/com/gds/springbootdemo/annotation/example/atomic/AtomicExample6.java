package com.gds.springbootdemo.annotation.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author 龚道松
 * @Date 2019/3/31 0031 15:23
 * @Wersion 1.0
 **/
@Slf4j
public class AtomicExample6 {
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws Exception{

        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch downLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
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
        log.info("atomicBoolean值是：" +atomicBoolean.get());
    }
    private static void test(){
        if(atomicBoolean.compareAndSet(false,true)){
            log.info("execute");
        }
    }
}
