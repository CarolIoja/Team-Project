package com.company;

import java.util.concurrent.LinkedBlockingQueue;

public class TradeCenter {
    LinkedBlockingQueue<Integer> trade_iron = new LinkedBlockingQueue<>(5);
    LinkedBlockingQueue<Integer> trade_stone =  new LinkedBlockingQueue<>(5);
    LinkedBlockingQueue<Integer> trade_wood = new LinkedBlockingQueue<>(5);

    TradeCenter(){
        trade_iron.add(0);
        trade_stone.add(0);
        trade_wood.add(0);
    }
}
