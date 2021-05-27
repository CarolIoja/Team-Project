package com.company;

import java.util.Random;

public class Player implements IronProducer,WoodProducer,StoneProducer{
    Integer iron = 0;
    Integer wood = 0;
    Integer stone = 0;
    int max_quantity = 100;
    int quantity = 20;
    Random rand = new Random();
    public int level = 1;
    boolean is_steal = false;

    public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (iron_l.size() == 0 || wood_l.size() == 0 || stone_l.size() == 0) {
                        wait();
                    }
                    iron += iron_l.removeFirst();
                    wood += wood_l.removeFirst();
                    stone += stone_l.removeFirst();
                    System.out.println("Consumed " + iron + " iron " + stone + " stone and " + wood + " wood");

                    level_up();
                    win();
                    notify();

                    Thread.sleep(1000);
                }
            }
    }

    @Override
    public void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                int ir = rand.nextInt(quantity);
                while(iron_l.size() == 10 || wood_l.size() == 10 || stone_l.size() == 10){
                    wait();
                }
                iron_l.add(ir);
                System.out.println("Added " + ir + " iron");
                int st = rand.nextInt(quantity);
                stone_l.add(st);
                System.out.println("Added " + st + " stone");
                int wd = rand.nextInt(quantity);
                wood_l.add(wd);
                System.out.println("Added " + wd + " wood");
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public void level_up(){
        if (iron >= max_quantity && wood >= max_quantity && stone >= max_quantity) {
            iron -= 100;
            wood -= 100;
            stone -= 100;
            quantity += 20;
            level += 1;
            max_quantity += 100;
            System.out.println("Leveled up to level " + level);
        }
    }

    public void win(){
        if (level >= 5){
            System.out.println("YOU WON");
            System.exit(0);
        }
    }

    public void steal(){
        int chance = rand.nextInt(1);
        if(chance == 0){
            is_steal = true;
        }else{
            is_steal = false;
        }
    }

}
