package com.company;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args)
            throws InterruptedException
    {
        final Farm try1 = new Farm();
        final Player p0 = new Player("Farm",try1);
        final Player p1 = new Player("Ron",try1);
        final Player p2 = new Player("Billy",try1);
        final Player p3 = new Player("Josh",try1);
        /*Thread t1 = new Thread(() -> {
            try{
                p0.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try{
                p1.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() ->{
           try{
               p2.consume();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();*/
        Thread t1 = new Thread(() -> {
            try{
                p1.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try{
                p1.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try{
                p2.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try{
                p2.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t5 = new Thread(() -> {
            try{
                p3.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t6 = new Thread(() -> {
            try{
                p3.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t3.start();
        t5.start();
        t2.start();
        t4.start();
        t6.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();


    }
}
