package com.multiple_threads_counter;

public class Main {
    public static void main(String[] args) {
        Counter counter=new Counter();
        Class class1=counter.getClass();
        Thread thread1=new CounterThread(counter);
        thread1.setName("Thread 1");
        Thread thread2=new CounterThread(counter);
        thread2.setName("Thread 2");
        Thread thread3=new CounterThread(counter);
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    //Instance variable
    int i;
    public void countdown() {
        //Local variable
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + ", i= " + i);
            }
        }
    }
}

class CounterThread extends Thread{
    private Counter counter;

    public CounterThread(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run(){
        counter.countdown();
    }
}

