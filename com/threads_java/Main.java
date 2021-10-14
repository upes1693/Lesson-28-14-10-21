package com.threads_java;

public class Main {

    public static void main(String[] args) {
//        String name= Thread.currentThread().getName();
//        System.out.println(name);
//        System.out.println("Writing from the main thread");
//        Thread thread=new AnotherThread();
//        thread.setName("Another thread");
//        thread.start();
//        Thread thread2=new AnotherThread();
//        thread.setName("Another thread 2");
//        thread2.start();

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Writing from the main thread again");
//
//        new Thread(){
//            @Override
//            public void run(){
//                System.out.println("Writing from anonymous thread");
//            }
//        }.start();

        //anonymousThread.start();
//        Thread thread2=new Thread(){
//            @Override
//            public void run(){
//                System.out.println(Thread.currentThread().getName());
//            }
//        };
//
//        thread2.setName("Thread 2");
//        thread2.run();
        //Runnable runnableThread=new RunnableThread();
        Thread thread=new Thread(new RunnableThread());
        thread.setName("Runnable thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();

        Thread anonymousRunnableThread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Writing from anonymous runnable instance");
            }
        });
        anonymousRunnableThread.start();


//        new Thread("new thread"){
//            @Override
//            public void run() {
//                System.out.println("Writing from: "+Thread.currentThread().getName());
//            }
//        }.start();

        Thread thread2=new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println("Writing from: "+Thread.currentThread().getName());
            }
        },"new runnable thread");

        thread2.start();
    }
}
