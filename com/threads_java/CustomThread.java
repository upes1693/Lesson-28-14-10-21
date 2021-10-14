package com.threads_java;

public class CustomThread extends Thread{
    @Override
    public void run(){
        System.out.println("Writing from custom thread");
        try {
            Thread.sleep(3000);
            System.out.println("Woken up after 3 sec");
        } catch (InterruptedException e) {
            System.out.println("Someone interrupted me while I was sleeping");
        }
    }
}
