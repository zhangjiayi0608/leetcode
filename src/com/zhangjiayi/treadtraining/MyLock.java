package com.zhangjiayi.treadtraining;

import java.util.concurrent.atomic.AtomicInteger;

public class MyLock {
    public static AtomicInteger i=new AtomicInteger();

    public static void main(String[] args) {
        for (;;){
            int current=i.get();
            int target=4;
            if (!i.compareAndSet(current,target)){
            }
        }
        //System.out.println(i.compareAndSet(0,2));
    }

}
