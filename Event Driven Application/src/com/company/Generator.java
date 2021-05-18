package com.company;


import java.util.Random;

class Generator implements Runnable {

    @Override
    public void run(){
        Random rand=new Random();
        int wood=0;
        int iron=0;
        int stone=0;
        int max=35;
        int[] generator_array={wood,iron,stone};
        //Resource Generator every 60 seconds with max capacity of 35
        try{
            while (true){
                //Wood
                if(generator_array[0]<=max){generator_array[0]+= rand.nextInt(5);}
                if(generator_array[0]>max){generator_array[0]=max;}
                //Iron
                if(generator_array[1]<=max){generator_array[1]+= rand.nextInt(5);}
                if(generator_array[1]>max){generator_array[1]=max;}
                //Stone
                if(generator_array[2]<=max){generator_array[2]+= rand.nextInt(5);}
                if(generator_array[2]>max){generator_array[2]=max;}

                System.out.println("Thread is Generating Wood:"+generator_array[0]);
                System.out.println("Thread is Generating Iron:"+generator_array[1]);
                System.out.println("Thread is Generating Sone:"+generator_array[2]);

                Thread.sleep(1*1000);//60*1000 ms=60 seconds
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }



    public static void main(String args[]){
        Generator Runable1=new Generator();
        Thread t1=new Thread(Runable1);
        t1.start();

    }
}
