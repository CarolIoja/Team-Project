package com.company;

import java.util.LinkedList;
import java.util.Random;

public interface WoodProducer {
    LinkedList<Integer> wood_l = new LinkedList<>();

    public default void produce() throws InterruptedException {
        Random rand = new Random();
        while (true) {
            synchronized (this) {
                int quantity = rand.nextInt(20);
                while (wood_l.size() == 10)
                    wait();

                System.out.println("WoodProducer produced-"
                        + quantity);

                wood_l.add(quantity);

                notify();

                Thread.sleep(1000);
            }
        }
    }
}
