package com.nbui;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Producer_consumer producerConsumer = new Producer_consumer();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
