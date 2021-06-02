package com.company;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public interface IronProducer {
     LinkedBlockingQueue<Integer> iron_l = new LinkedBlockingQueue<>();

     default void produce() throws InterruptedException {
        Random rand = new Random();

        int quantity = rand.nextInt(21);

        //System.out.println("IronProducer produced-"
               // + quantity);

        iron_l.add(quantity);

    }
}

