package com.company;

import java.util.LinkedList;
import java.util.Random;

public class Farm {
    public LinkedList<Integer> iron_l = new LinkedList<>();
    public LinkedList<Integer> stone_l = new LinkedList<>();
    public LinkedList<Integer> wood_l = new LinkedList<>();


    public void produce() throws InterruptedException {
        Random rand = new Random();
        try {
            while (true) {
                synchronized (this) {
                    int iron = rand.nextInt(20);
                    iron_l.add(iron);
                    System.out.println("Added " + iron + " iron");
                    int stone = rand.nextInt(20);
                    stone_l.add(stone);
                    System.out.println("Added " + stone + " stone");
                    int wood = rand.nextInt(20);
                    wood_l.add(wood);
                    System.out.println("Added " + wood + " wood");

                    while(iron_l.size() == 10 || wood_l.size() == 10 || stone_l.size() == 10){
                        wait();
                    }
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
