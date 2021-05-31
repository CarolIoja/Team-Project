package com.company;

import java.util.LinkedList;
import java.util.Random;

public interface IronProducer {
    LinkedList<Integer> iron_l = new LinkedList<>();

     default void produce() throws InterruptedException {
        Random rand = new Random();

        int quantity = rand.nextInt(21);

        System.out.println("IronProducer produced-"
                + quantity);

        iron_l.add(quantity);

    }
}

