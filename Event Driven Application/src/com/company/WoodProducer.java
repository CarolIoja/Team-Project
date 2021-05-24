package com.company;

import java.util.LinkedList;
import java.util.Random;

public class WoodProducer {
    LinkedList<Integer> wood = new LinkedList<>();

    public void produce() throws InterruptedException {
        Random rand = new Random();
        while (true) {
            synchronized (this) {
                int quantity = rand.nextInt(20);
                while (wood.size() == 10)
                    wait();

                System.out.println("WoodProducer produced-"
                        + quantity);

                wood.add(quantity);

                notify();

                Thread.sleep(1000);
            }
        }
    }
}
