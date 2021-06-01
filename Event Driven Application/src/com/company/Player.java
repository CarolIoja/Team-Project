package com.company;

import java.util.Random;

public class Player {
    Farm farm;
    Integer iron = 0;
    Integer wood = 0;
    Integer stone = 0;
    int max_quantity = 100;
    int quantity = 20;
    Random rand = new Random();
    public int level = 1;
    String name;
    int cooldown = 10;
    volatile int ir;
    volatile int st;
    volatile int wd;

    Player(String something,Farm farm){
        this.name = something;
        this.farm = farm;

    }

    synchronized void consume() throws InterruptedException {
        while (true) {
            while (farm.iron_l.size() == 0 || farm.wood_l.size() == 0 || farm.stone_l.size() == 0) {
                wait();
            }
            iron += farm.iron_l.poll();
            wood += farm.wood_l.poll();
            stone += farm.stone_l.poll();
            System.out.println(name + " collected " + iron + " iron " + stone + " stone and " + wood + " wood");

            level_up();
            win();
            notifyAll();
            cooldown --;
            if(steal()){
                if(cooldown == 0) {
                    cooldown = 10;
                    iron -= 20;
                    wood -= 20;
                    stone -= 20;
                }
            }else{
                iron += 20;
                wood += 20;
                stone += 20;
            }

            Thread.sleep(1000);

        }
    }

    synchronized void produce() throws InterruptedException {
        while (true) {
            ir = rand.nextInt(quantity);
            while (farm.iron_l.size() == 10 || farm.wood_l.size() == 10 || farm.stone_l.size() == 10) {
                wait();
            }
            farm.iron_l.offer(ir);
            //System.out.println(name + " farm's added " + ir + " iron");
            st = rand.nextInt(quantity);
            farm.stone_l.offer(st);
            //System.out.println(name + " farm's added " + st + " stone");
            wd = rand.nextInt(quantity);
            farm.wood_l.offer(wd);
            //System.out.println(name + " farm's added " + wd + " wood");
            notify();
            Thread.sleep(1000);

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
            System.out.println(name+" has leveled up to level " + level);
        }
    }

    public void win(){
        if (level >= 5){
            System.out.println(name+" WON");
            System.exit(0);
        }
    }

    public boolean steal(){
        int chance = rand.nextInt(2);
        if (chance == 0){
            return true;
        }else{
            return false;
        }
    }

}
