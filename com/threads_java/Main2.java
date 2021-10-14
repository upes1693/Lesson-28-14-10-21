package com.threads_java;

public class Main2 {
    public static void main(String[] args) {
        Thread thread=new CustomThread();
        thread.start();
       // thread.interrupt();

        Thread anonymousThread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Writing from anonymous runnable");
                try {
                    thread.join();
                    System.out.println("Custom thread terminated. I am running again.");
                } catch (InterruptedException e) {
                    System.out.println("Woken up again after join");
                }
            }
        });

        anonymousThread.start();
    }
}
