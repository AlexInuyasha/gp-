package com.hzy;

import java.util.concurrent.TimeUnit;

public class ThreadStatus{
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            synchronized (ThreadStatus.class){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"TIME-OUT");

        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            synchronized (ThreadStatus.class){
                try {
                    ThreadStatus.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"WAIT");


        new Thread(new BlockedDemo(),"1").start();
        new Thread(new BlockedDemo(),"2").start();

    }

    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                System.out.println(Thread.currentThread().getName());
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
