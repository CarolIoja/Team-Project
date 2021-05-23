package com.company;

public class Player {
    Integer iron = 0;
    Integer wood = 0;
    Integer stone = 0;
    Farm ferma = new Farm();

    public void consume(){
        try {
            while (true) {
                synchronized (this) {
                }
                ferma.produce();
                iron += ferma.iron_l.getFirst();
                System.out.println("Player got " + iron + "  iron");
                wood += ferma.wood_l.getFirst();
                System.out.println("Player got " + wood + "  wood");
                stone += ferma.stone_l.getFirst();
                System.out.println("Player got " + stone + "  stone");
                if (iron >= 100 && wood >= 100 && stone >= 100) {
                    System.out.println("Ready to level up");

                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
