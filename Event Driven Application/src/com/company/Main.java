package com.company;


//import java.util.Random;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        //Random rand = new Random();
        final Farm try1 = new Farm();
        //Stream.generate(new Player(String.valueOf(rand.nextInt(1000)),try1)::consume);
        final Player p1 = new Player(try1);
        final Player p2 = new Player(try1);
        final Player p3 = new Player(try1);
        Thread t1 = new Thread(try1);
        Thread t2 = new Thread(p1);
        Thread t4 = new Thread(p2);
        Thread t6 = new Thread(p3);
        t1.start();
        t2.start();
        t4.start();
        t6.start();
        t1.join();
        t2.join();
        t4.join();
        t6.join();


    }
}
