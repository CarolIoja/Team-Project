package com.company;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        Farm prod = new Farm();
        Player player = new Player();
        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    prod.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    player.consume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //t1.start();
        t2.start();
        //t1.join();
        //t2.join();

    }
}
