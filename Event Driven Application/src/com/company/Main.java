package com.company;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int quantity = 3;//(int) Double.POSITIVE_INFINITY;
        final TradeCenter trd = new TradeCenter();
        final Farm try1 = new Farm();
        Thread t1 = new Thread(try1);
        t1.start();
        ExecutorService exec =  Executors.newFixedThreadPool(quantity);
        while(quantity!=0) {
            try {
                exec.submit(new Player(try1,trd));
                quantity--;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
