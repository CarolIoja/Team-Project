package com.company;

import java.util.LinkedList;
import java.util.Random;

public interface WoodProducer {
    LinkedList<Integer> wood_l = new LinkedList<>();

  default void produce() throws InterruptedException {
      Random rand = new Random();
      int quantity = rand.nextInt(21);

      System.out.println("WoodProducer produced-"
              + quantity);

      wood_l.add(quantity);

  }
}
