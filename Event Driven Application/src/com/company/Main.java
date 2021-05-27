package com.company;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        final Player p1 = new Player();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    p1.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    p1.consume();
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
