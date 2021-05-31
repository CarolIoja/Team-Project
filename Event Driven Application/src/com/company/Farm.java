package com.company;

public class Farm implements IronProducer,WoodProducer,StoneProducer{
    @Override
    public synchronized void produce() throws InterruptedException {
        while(true) {
            IronProducer.super.produce();
            WoodProducer.super.produce();
            StoneProducer.super.produce();
            while (stone_l.size() == 10 && wood_l.size() == 10 && iron_l.size() == 10) {
                wait();
            }
            notify();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
