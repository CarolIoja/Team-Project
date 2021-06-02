package com.company;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Player implements Runnable{
    LinkedBlockingQueue<Integer> trade_iron;
    LinkedBlockingQueue<Integer> trade_stone;
    LinkedBlockingQueue<Integer> trade_wood;
    Farm farm;
    Integer iron = 0;
    Integer wood = 0;
    Integer stone = 0;
    AtomicInteger traded_iron;
    AtomicInteger traded_stone;
    AtomicInteger traded_wood;
    int max_quantity = 100;
    int quantity = 20;
    Random rand = new Random();
    public int level = 1;
    int name;
    int countdown = 10;

    Player(Farm farm){
        this.name = ThreadLocalRandom.current().nextInt(10000);
        this.farm = farm;

    }

    synchronized void consume() throws InterruptedException {
        while (true) {
            while (farm.iron_l.size() == 0 || farm.wood_l.size() == 0 || farm.stone_l.size() == 0) {
                notifyAll();
                wait();
            }
            iron += farm.iron_l.poll();
            wood += farm.wood_l.poll();
            stone += farm.stone_l.poll();
            System.out.println(name + " collected " + iron + " iron " + stone + " stone and " + wood + " wood");
            level_up();
            win();
            countdown--;
            if(countdown == 0){
                steal();
            }

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

    public void steal(){
        int chance = ThreadLocalRandom.current().nextInt(2);
        if(chance == 0){
            System.out.println(name +" tried to steal from the farm but was caught!");
            iron -= 50;
            wood -= 50;
            stone -= 50;
        }else{
            System.out.println(name +" tried to steal from the farm but was not caught!");
            iron += 50;
            wood += 50;
            stone += 50;
        }
        countdown = 10;

    }
    public void trade(){

    }

    @Override
    public void run() {
        try {
            System.out.println("Thread "+name+" started");
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
