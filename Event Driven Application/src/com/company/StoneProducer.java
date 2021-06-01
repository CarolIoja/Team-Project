package com.company;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public interface StoneProducer {
    LinkedBlockingQueue<Integer> stone_l = new LinkedBlockingQueue<>();

    default void produce() throws InterruptedException {
        Random rand = new Random();
        int quantity = rand.nextInt(21);

        System.out.println("StoneProducer produced-"
                + quantity);

        stone_l.add(quantity);

    }
}
