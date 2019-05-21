package com.amyliascarlet.lib.thread;

import com.amyliascarlet.lib.log.Log;

public class ThreadTest2 {
//
//    public void Do1(){
//        for(int i=40;i<45;i++){
//            Log.i(i);
//            //System.out.print(i);
//
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public void Do2(){
//        for(int i=20;i<25;i++){
//            Log.i(i);
//            //System.out.print(i);
//
//            try {
//                Thread.sleep(600);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public static void main(String[] args) {

        Log.i("parent thread begin ");



        EasyThread t1 = new EasyThread("DoInT3");
        EasyThread t2 = new EasyThread("DoInT3");
        t1.start();
        t2.start();

        Log.i("parent thread over ");
    }


     void DoInT3(){
        for(int i=54;i<59;i++){
            Log.i(i);
            //System.out.print(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
