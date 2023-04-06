package com.example.ttit.core.thread;

public class P60_RunnableThread implements Runnable {

    @Override
    public void run() {
        doSomeThing();
    }

    private void doSomeThing() {
        System.out.println("我是一个线程方法");
    }

}
