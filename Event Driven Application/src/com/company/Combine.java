package com.company;

import java.util.LinkedList;
import java.util.Random;

public class Combine {
    public LinkedList<Integer> iron_l = new LinkedList<>();
    public LinkedList<Integer> stone_l = new LinkedList<>();
    public LinkedList<Integer> wood_l = new LinkedList<>();
    public Integer iron = 0;
    public Integer wood = 0;
    public Integer stone = 0;
    public int quantity = 20;
    public int level = 1;


    public void produce() throws InterruptedException {
        Random rand = new Random();
            while (true) {
                synchronized (this) {
                    int ir = rand.nextInt(quantity);
                    iron_l.add(ir);
                    System.out.println("Added " + ir + " iron");
                    int st = rand.nextInt(quantity);
                    stone_l.add(st);
                    System.out.println("Added " + st + " stone");
                    int wd = rand.nextInt(quantity);
                    wood_l.add(wd);
                    System.out.println("Added " + wd + " wood");

                    while(iron_l.size() == 10 || wood_l.size() == 10 || stone_l.size() == 10){
                        wait();
                    }
                    notify();
                    Thread.sleep(1000);
                }
            }
    }

    public void consume() throws InterruptedException{
            while(true) synchronized (this) {
                while (iron_l.size() == 0 || wood_l.size() == 0 || stone_l.size() == 0) {
                    wait();
                }
                iron += iron_l.removeFirst();
                wood += wood_l.removeFirst();
                stone += stone_l.removeFirst();
                System.out.println("Consumed " + iron + " iron " + stone + " stone and " + wood + " wood");

                if (iron >= 100 && wood >= 100 && stone >= 100){
                    iron -= 100;
                    wood -= 100;
                    stone -= 100;
                    quantity += 20;
                    level += 1;
                    System.out.println("Leveled up to level "+level);
                }
                if (level >= 5){
                    System.out.println("YOU WON");
                    System.exit(0);
                }

                notify();

                Thread.sleep(1000);
            }
    }
   /* public void level_up() throws InterruptedException{
        while(true) {
            synchronized (this) {
                if (iron == 100 && wood == 100 && stone == 100){
                    System.out.println("Level up");
                    iron -= 100;
                    wood -= 100;
                    stone -= 100;
                    quantity += 20;
                    level += 1;
                }
                if (level >= 5){
                    System.out.println("YOU WON");
                }
            }
        }
    }*/
}
