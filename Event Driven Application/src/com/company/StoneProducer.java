package com.company;

import java.util.LinkedList;
import java.util.Random;

public interface StoneProducer {
    LinkedList<Integer> stone_l = new LinkedList<>();

    default void produce() throws InterruptedException {
        Random rand = new Random();
        int quantity = rand.nextInt(21);

        System.out.println("StoneProducer produced-"
                + quantity);

        stone_l.add(quantity);

    }
}
