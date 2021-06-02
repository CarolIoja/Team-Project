package com.company;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public interface StoneProducer {
    LinkedBlockingQueue<Integer> stone_l = new LinkedBlockingQueue<>();

    default void produce() throws InterruptedException {
        int quantity = ThreadLocalRandom.current().nextInt(21);

        //System.out.println("StoneProducer produced-"
               // + quantity);

        stone_l.add(quantity);

    }
}
