package com.gds.springbootdemo.annotation.example.atomic.sync;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 龚道松
 * @Date 2019/3/31 0031 16:09
 * @Wersion 1.0
 **/
@Slf4j
public class SyncronizedExample1 {
    // 修饰一个代码块
    public void test1(int j){
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} {}",j,i);
            }
        }
    }
    // 修饰一个方法
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} {}",j, i);
        }
    }

    public static void main(String[] args) {
        SyncronizedExample1 example1 = new SyncronizedExample1();
        SyncronizedExample1 example2 = new SyncronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }

}
