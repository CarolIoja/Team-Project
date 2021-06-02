package com.company;


public class Farm implements IronProducer,StoneProducer,WoodProducer{

    public synchronized void produce() throws InterruptedException {
        while(true) {
            IronProducer.super.produce();
            StoneProducer.super.produce();
            WoodProducer.super.produce();
            if(stone_l.size() < 10 || wood_l.size() < 10 || iron_l.size() < 10) {
                continue;
            }

            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
