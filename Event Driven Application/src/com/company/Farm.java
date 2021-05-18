package com.company;

import java.util.LinkedList;
import java.util.Random;

public class Farm {
    LinkedList<Integer> iron_l = new LinkedList<>();
    LinkedList<Integer> stone_l = new LinkedList<>();
    LinkedList<Integer> wood_l = new LinkedList<>();
    public void produce() throws InterruptedException{
        Random rand = new Random();
        while (true) {
            synchronized (this){
                int iron = rand.nextInt(20);
                iron_l.add(iron);
                System.out.println("Added "+iron+" iron");
                int stone = rand.nextInt(20);
                stone_l.add(stone);
                System.out.println("Added "+stone+" stone");
                int wood = rand.nextInt(20);
                wood_l.add(wood);
                System.out.println("Added "+wood+" wood");

                notify();

                Thread.sleep(1000);
            }
        }
    }
}
