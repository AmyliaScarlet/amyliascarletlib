package com.amyliascarlet.lib.thread;

import com.amyliascarlet.lib.log.Log;
import java.util.*;

public class ThreadTest4 {
    private static ThreadPoolManager tpm = ThreadPoolManager.getInstance();
    public static void main(String[] args) {



        tpm.execute(new EasyThread("DoInT3").getModel());
        tpm.shutdown();

//        IdentityHashMap<String, EasyThreadModel> _ThreadModelMap = tpm.shutdownNow();
//
//        Log.i(_ThreadModelMap);

//        for (Map.Entry<String, EasyThreadModel> entry : tpm.getEasyThreadModels().entrySet()) {
//            Log.i("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            Log.i(entry.getValue());
//        }
//
//        tpm.remove(tpm.getEasyThreadModels().get("DoInT2"));
//        for (Map.Entry<String, EasyThreadModel> entry : tpm.getEasyThreadModels().entrySet()) {
//            Log.i("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            Log.i(entry.getValue());
//        }
//
//        new EasyThread("DoInT3").start();
//        new EasyThread("DoInT2").start();



    }

    void DoInT3(){
        try{
            for(int i=14;i<19;i++){
                Log.i(i);
                //System.out.print(i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }finally {

        }

    }

    void DoInT2(){
        for(int i=10;i<15;i++){
            Log.i(i);
            //System.out.print(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
}
