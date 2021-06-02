package com.company;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Player implements Runnable{
    LinkedBlockingQueue<Integer> trade_iron = new LinkedBlockingQueue<>(1);
    LinkedBlockingQueue<Integer> trade_stone =  new LinkedBlockingQueue<>(1);
    LinkedBlockingQueue<Integer> trade_wood = new LinkedBlockingQueue<>(1);
    Farm farm;
    Integer iron = 0;
    Integer wood = 0;
    Integer stone = 0;
    int max_quantity = 100;
    int quantity = 20;
    public int level = 1;
    int name;
    int countdown = 10;
    int cooldown = 5;
    int trade_amount;

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
            cooldown--;
            if(countdown == 0){
                steal();
            }
            if(cooldown == 0){
                trade();
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
    public synchronized void trade() throws InterruptedException {
        float percent = ThreadLocalRandom.current().nextInt(1,71);
        cooldown = 5;
        /*if(trade_iron.size() < 1 || trade_stone.size() < 1 || trade_wood.size() < 1) {
            switch (trading) {
                case 1 -> {
                    trade_amount = (iron * (Math.round(percent / 100)));
                    iron -= trade_amount;
                    trade_iron.put(trade_amount);
                    System.out.println(name + " traded " + trade_amount + " iron");
                }
                case 2 -> {
                    trade_amount = (stone * (Math.round(percent / 100)));
                    stone -= trade_amount;
                    trade_iron.put(trade_amount);
                    System.out.println(name + " traded " + trade_amount + " stone");
                }
                case 3 -> {
                    trade_amount = (wood * (Math.round(percent / 100)));
                    wood -= trade_amount;
                    trade_iron.put(trade_amount);
                    System.out.println(name + " traded " + trade_amount + " wood");
                }
                default -> {
                    System.out.println("Wrong material found");
                    System.exit(0);
                }
            }
            notifyAll();
        }else if(trade_iron.size() >= 1 || trade)*/
        if(trade_iron.size() < 1 && trade_wood.size() >= 1 & trade_stone.size() >= 1){
            trade_amount = (iron * (Math.round(percent / 100)));
            iron -= trade_amount;
            trade_iron.put(trade_amount);
            System.out.println(name + " traded " + trade_amount + " iron");
        }else if(trade_iron.size() >= 1 && trade_wood.size() < 1 & trade_stone.size() >= 1){
            trade_amount = (stone * (Math.round(percent / 100)));
            stone -= trade_amount;
            trade_iron.put(trade_amount);
            System.out.println(name + " traded " + trade_amount + " stone");
        }else if(trade_iron.size() >= 1 && trade_wood.size() >= 1 & trade_stone.size() < 1){
            trade_amount = (wood * (Math.round(percent / 100)));
            wood -= trade_amount;
            trade_iron.put(trade_amount);
            System.out.println(name + " traded " + trade_amount + " wood");
        }else if(trade_iron.size() < 1 && trade_wood.size() < 1 & trade_stone.size() >= 1){

        }

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
