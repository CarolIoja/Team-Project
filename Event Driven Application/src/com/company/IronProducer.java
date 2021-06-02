package com.company;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public interface IronProducer {
     LinkedBlockingQueue<Integer> iron_l = new LinkedBlockingQueue<>();

     default void produce() throws InterruptedException {

        int quantity = ThreadLocalRandom.current().nextInt(21);

        //System.out.println("IronProducer produced-"
               // + quantity);

        iron_l.add(quantity);

    }
}

