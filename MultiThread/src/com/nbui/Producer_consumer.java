package com.nbui;

import java.util.LinkedList;

public class Producer_consumer {
    LinkedList<Integer> testList = new LinkedList<>();
    int capacity = 2;

    public Producer_consumer(){}

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (this){
                while(testList.size() == capacity)
                    wait();
                System.out.println("Producer produced-" + value);

                testList.add(value++);

                notify();

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException{
        while(true){
            synchronized (this){
                while(testList.size() == 0)
                    wait();

                int val = testList.removeFirst();

                System.out.println("Consumer consumed-" + val);

                notify();

                Thread.sleep(1000);
            }
        }
    }
}
