package com.company;

import java.util.LinkedList;
import java.util.Random;

public class WoodProducer {
    LinkedList<Integer> iron = new LinkedList<>();

    public void produce() throws InterruptedException {
        Random rand = new Random();
        while (true) {
            synchronized (this) {
                int quantity = rand.nextInt(20);
                while (iron.size() == 10)
                    wait();

                System.out.println("\nWoodProducer produced-"
                        + quantity);

                iron.add(quantity);

                notify();

                Thread.sleep(1000);
            }
        }
    }
}
