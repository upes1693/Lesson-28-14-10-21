package com.stop_a_thread_demo;

public class Main {
    public static void main(String[] args) {
        CustomThread customThread=new CustomThread();
        Thread thread=new Thread(customThread,"custom thread instance");
        thread.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}

class CustomThread implements Runnable{
    private volatile boolean exit=false;
    @Override
    public void run(){
        while(!exit){
            System.out.println("Running...");
        }
        System.out.println("Stopped.. terminating..");
    }

    public void stop(){
        exit=true;
    }
}
