package com.company;


//import java.util.Random;

import java.util.concurrent.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        //Random rand = new Random();
        final Farm try1 = new Farm();
        Thread t1 = new Thread(try1);
        t1.start();
        ExecutorService exec =  Executors.newFixedThreadPool((int) Double.POSITIVE_INFINITY);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) exec;
        while(true) {
            exec.submit(new Player(try1));
        }
        //Stream.generate(new Thread(new Player(try1)::start));
        /*final Player p1 = new Player(try1);
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
        t6.join();*/


    }
}
