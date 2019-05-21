package com.amyliascarlet.lib.thread;

import com.amyliascarlet.lib.log.Log;
import junit.framework.TestCase;


public class ThreadTest extends TestCase {

//    public void test_main() {
//
////        ThreadTest3.EasyThread t = new ThreadTest3.EasyThread("Do");
////        t.run();
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        t.sleep(1000);
////        t.stopThread();
//        //t.run(Do());
//
//    }
//    public void test_main3() {
//
//        new EasyThread(() -> {
//            for(int i=70;i<75;i++){
//                Log.i(i);
//                //System.out.print(i);
//
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            for(int i=80;i<85;i++){
//                Log.i(i);
//                //System.out.print(i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    public void Do(){
//
//        for(int i=0;i<10;i++){
//            Log.i(i);
//            if(i>5){
//                new EasyThread("Do2").run();
//            }else {
//                Log.i(i);
//            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void test_main2() {
//        Log.i("parent thread begin ");
//
//        EasyThread t1 = new EasyThread("Do3");
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=60;i<65;i++){
//                    Log.i(i);
//                    try {
//                        EasyThread.sleep((long) 200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//
//        Log.i("parent thread over ");
//    }
//    public void Do3(){
//
//        for(int i=50;i<55;i++){
//            Log.i(i);
//            try {
//                EasyThread.sleep((long) 200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
