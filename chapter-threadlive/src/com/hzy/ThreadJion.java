package com.hzy;

public class ThreadJion {

    static int i = 0;
    static int a = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
             i=10;
        });

        Thread t2 = new Thread(()->{
            i = a+1;
        });
        t1.start();
        t1.join();
        t2.start();

        Thread.sleep(1000);
        System.out.println(i);
    }
}
