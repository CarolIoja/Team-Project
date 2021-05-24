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


    public void produce() throws InterruptedException {
        Random rand = new Random();
            while (true) {
                synchronized (this) {
                    int ir = rand.nextInt(20);
                    iron_l.add(ir);
                    System.out.println("Added " + ir + " iron");
                    int st = rand.nextInt(20);
                    stone_l.add(st);
                    System.out.println("Added " + st + " stone");
                    int wd = rand.nextInt(20);
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
                iron += iron_l.getFirst();
                wood += wood_l.getFirst();
                stone += stone_l.getFirst();
                System.out.println("Consumed " + iron + " iron " + stone + " stone and " + wood + " wood");

                notify();

                Thread.sleep(1000);
            }
    }
}
