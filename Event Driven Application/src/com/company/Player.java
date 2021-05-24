package com.company;

public class Player extends Farm{
    Integer iron = 0;
    Integer wood = 0;
    Integer stone = 0;
    IronProducer iron_prod = new IronProducer();
    StoneProducer stone_prod = new StoneProducer();
    WoodProducer wood_prod = new WoodProducer();

    public void consume() throws InterruptedException {
        try {
            while (true) {
                iron += iron_l.getFirst();
                System.out.println("Got " + iron + " iron");
                wood += wood_l.getFirst();
                System.out.println("Got " + wood + " wood");
                stone += stone_l.getFirst();
                System.out.println("Got " + stone + " stone");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
