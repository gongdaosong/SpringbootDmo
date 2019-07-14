package com.gds.springbootdemo.annotation.example.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author 龚道松
 * @Date 2019/3/31 0031 15:11
 * @Wersion 1.0
 **/
@Slf4j
public class AtomicExample4 {
    private static AtomicReference<Integer> count = new AtomicReference<Integer>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(6,7);
        count.compareAndSet(4,5);
        log.info("count: {}",count.get());
    }

}
