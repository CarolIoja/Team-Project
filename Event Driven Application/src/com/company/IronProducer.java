package com.company;

import java.util.LinkedList;
import java.util.Random;

public interface IronProducer {
    LinkedList<Integer> iron_l = new LinkedList<>();

    public default void produce() throws InterruptedException {
        Random rand = new Random();
        while (true) {
            synchronized (this) {
                int quantity = rand.nextInt(20);
                while (iron_l.size() == 10)
                    wait();

                System.out.println("IronProducer produced-"
                        + quantity);

                iron_l.add(quantity);

                notify();

                Thread.sleep(1000);
            }
        }
    }
}

