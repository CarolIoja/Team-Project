package com.company;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public interface WoodProducer {
    LinkedBlockingQueue<Integer> wood_l = new LinkedBlockingQueue<>();

  default void produce() throws InterruptedException {
      int quantity = ThreadLocalRandom.current().nextInt(21);

     // System.out.println("WoodProducer produced-"
              //+ quantity);

      wood_l.add(quantity);

  }
}
