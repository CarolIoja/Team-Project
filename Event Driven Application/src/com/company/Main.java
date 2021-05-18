package com.company;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        IronProducer iron = new IronProducer();
        WoodProducer wood = new WoodProducer();
        StoneProducer stone = new StoneProducer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("Thread 1 produced: ");
                    iron.produce();
                    wood.produce();
                    stone.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("Thread 1 produced: ");
                    iron.produce();
                    wood.produce();
                    stone.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
