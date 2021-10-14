package com.threads_java;

public class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Writing from runnable thread");
    }
}
