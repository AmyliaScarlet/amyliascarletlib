package com.amyliascarlet.lib.thread;


import com.amyliascarlet.lib.log.Log;

public class ThreadTest3 {
    public static void main(String[] args) {
//
//        new EasyThread("Do1").run();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new EasyThread("Do2").run();
//
//
        Log.i("parent thread begin ");

        new EasyThread(() -> {
            for(int i=70;i<75;i++){
                Log.i(i);
                //System.out.print(i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i=80;i<85;i++){
                Log.i(i);
                //System.out.print(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Log.i("parent thread over ");

    }
    public void Do3(){
        for(int i=50;i<55;i++){
            Log.i(i);
            EasyThread.sleep(400);
        }
    }

//    static class EasyThread extends Thread {
//
//        static Thread t = null;
//
//        private static boolean stop;
//
//        public EasyThread(){
//
//        }
//        public EasyThread(Runnable runnable){
//            t = new Thread(runnable);
//        }
//        public void run(Runnable runnable) {
//            t = new Thread(runnable);
//
//        }
//        public EasyThread(String methodName, Object... oParam){
//            t = new Thread(() -> {
//
//                Method method;
//                try {
//                    StackTraceElement[] stes = Thread.currentThread().getStackTrace();
//                    Class c = Class.forName(stes[4].getClassName());
//                    Object obj = c.newInstance();
//                    method = c.getMethod(methodName);
//                    method.invoke(obj, oParam);
//                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//
//
//            });
//        }
//        public EasyThread(Class clz,String methodName, Object... oParam){
//            t = new Thread(() -> {
//
//                Method method;
//                try {
//                    Class c;
//                    if(clz !=null){
//                        c=clz;
//                    }else{
//                        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
//                        c = Class.forName(stes[4].getClassName());
//                    }
//                    Object obj = c.newInstance();
//                    method = c.getMethod(methodName);
//                    method.invoke(obj, oParam);
//                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//
//
//            });
//        }
//
//        public void run(String methodName, Object... oParam) {
//            t = new Thread(() -> {
//
//                Method method;
//                try {
//                    StackTraceElement[] stes = Thread.currentThread().getStackTrace();
//                    Class c = Class.forName(stes[4].getClassName());
//                    Object obj = c.newInstance();
//                    method = c.getMethod(methodName);
//                    method.invoke(obj, oParam);
//                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            });
//            t.run();
//
//        }
//        public void run(Class clz,String methodName, Object... oParam) {
//            t = new Thread(() -> {
//
//                Method method;
//                try {
//                    Class c;
//                    if(clz !=null){
//                        c=clz;
//                    }else{
//                        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
//                        c = Class.forName(stes[4].getClassName());
//                    }
//                    Object obj = c.newInstance();
//                    method = c.getMethod(methodName);
//                    method.invoke(obj, oParam);
//                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            });
//            t.run();
//
//        }
//
//        public void run(){
//            if(t != null){
//                t.run();
//            }
//        }
//
//        public void stopThread() {
//            stop = true;
//        }
//
//        public void sleep(int millis){
//            try {
//                Thread.sleep(millis);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//
//    }

    public void Do1(){
        for(int i=90;i<95;i++){
            Log.i(i);
            //System.out.print(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void Do2(){
        for(int i=20;i<25;i++){
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
