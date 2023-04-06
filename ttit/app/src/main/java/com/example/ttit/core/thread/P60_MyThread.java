package com.example.ttit.core.thread;

public class P60_MyThread extends Thread {

    @Override
    public void run() {
        doSomething();
    }

    private void doSomething() {
        System.out.println("我是一个线程中的方法");
    }
}
