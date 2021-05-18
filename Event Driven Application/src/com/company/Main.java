package com.company;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        Farm prod = new Farm();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    prod.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        
    }
}
