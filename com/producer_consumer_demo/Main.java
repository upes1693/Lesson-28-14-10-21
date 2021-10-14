package com.producer_consumer_demo;

public class Main {
    public static void main(String[] args) {
        Message message=new Message();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();
    }
}

class Message{
    private String message;
    private boolean isEmpty=true;

    public synchronized String read(){
        while (isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isEmpty=true;
        notifyAll();
        return message;
    }

    public synchronized void write(String msg){
        while (!isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isEmpty=false;
        message=msg;
        notifyAll();
    }
}

class Producer implements Runnable{
    private Message message;

    public Producer(Message message){
        this.message=message;
    }

    @Override
    public void run() {
        String[] messages={
                "Msg A",
                "Msg B",
                "Msg C",
                "Msg D"
        };

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        message.write("Finished");
    }
}

class Consumer implements Runnable{
    private Message message;

    public Consumer(Message message){
        this.message=message;
    }

    @Override
    public void run() {
        for (String latestMessage= message.read();!latestMessage.equals("Finished");
        latestMessage=message.read()){
            System.out.println(latestMessage);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}