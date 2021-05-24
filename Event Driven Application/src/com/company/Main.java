package com.company;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        final Combine gam = new Combine();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    gam.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    gam.consume();
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
