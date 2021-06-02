package com.company;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public interface WoodProducer {
    LinkedBlockingQueue<Integer> wood_l = new LinkedBlockingQueue<>();

  default void produce() throws InterruptedException {
      Random rand = new Random();
      int quantity = rand.nextInt(21);

     // System.out.println("WoodProducer produced-"
              //+ quantity);

      wood_l.add(quantity);

  }
}
