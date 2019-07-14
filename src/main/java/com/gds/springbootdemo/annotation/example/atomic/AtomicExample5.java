package com.gds.springbootdemo.annotation.example.atomic;

import com.oracle.deploy.update.Updater;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author 龚道松
 * @Date 2019/3/31 0031 15:23
 * @Wersion 1.0
 **/
@Slf4j
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");
    @Getter
    private volatile int count = 100;

//    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
         AtomicExample5 example5 = new AtomicExample5();
        if(updater.compareAndSet(example5, 100,120)){
            log.info("updater success 1, {}",example5.getCount());
        }
        if(updater.compareAndSet(example5, 100,120)){
            log.info("updater success 2, {}",example5.getCount());
        } else {
            log.info("updater faild , {}",example5.getCount());
        }
    }
}
