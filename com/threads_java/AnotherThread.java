package com.threads_java;

public class AnotherThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Writing from another thread");
        System.out.println("name: "+getName());
    }
}
