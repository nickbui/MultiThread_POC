package com.nbui;

import java.util.LinkedList;

public class Producer_consumer {
    LinkedList<Integer> testList = new LinkedList<>();
    int capacity = 2;

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
}
