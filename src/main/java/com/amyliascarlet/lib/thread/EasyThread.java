package com.amyliascarlet.lib.thread;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EasyThread extends Thread {
    private Thread mThread;
    private Runnable mRunnable;
    private Status mStatus;

    private EasyThreadModel mEasyThreadModel = new EasyThreadModel();

    private static EasyThread mInstance = new EasyThread();
    public static EasyThread getInstance() {
        return mInstance;
    }

    public EasyThread(){

    }
    public EasyThread(Runnable runnable){
        mThread = new Thread(runnable);
    }
    public void run(Runnable runnable) {
        mThread = new Thread(runnable);
    }
    public EasyThread(String methodName, Object... oParam){
        Ready(null,methodName, oParam);
    }

    public EasyThread(Class clz, String methodName, Object... oParam){
        Ready(clz,methodName, oParam);
    }

    public void run(String methodName, Object... oParam) {
        Ready(null,methodName, oParam);
        run();
    }
    public void run(Class clz,String methodName, Object... oParam) {
        Ready(clz,methodName, oParam);
        run();
    }
     public void start(String methodName, Object... oParam) {
         Ready(null,methodName, oParam);
         start();
     }
     public void start(Class clz,String methodName, Object... oParam) {
         Ready(clz,methodName, oParam);
         start();
     }

     private void Ready(Class clz, String methodName, Object... oParam) {
         StackTraceElement[] stes = Thread.currentThread().getStackTrace();
         Method method = null;
         Object obj = null;
         Class mClass;
         try {
             if(clz != null){
                 mClass = clz;
             }else {
                 mClass = Class.forName(stes[3].getClassName());
             }

             Constructor<?> constructor = null;//获取当前Class所表示类中指定的一个的构造器
             try {
                 constructor = mClass.getDeclaredConstructor();
             } catch (NoSuchMethodException e) {
                 e.printStackTrace();
             }
             if (constructor != null) {
                 constructor.setAccessible(true);  //设置私有方法的可访问
                 try {
                     obj = constructor.newInstance();//实例化对象
                 } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                     e.printStackTrace();
                 }
             }
             method = mClass.getDeclaredMethod(methodName);
             method.setAccessible(true);
         } catch (NoSuchMethodException | ClassNotFoundException e) {
             e.printStackTrace();
         }

         Method finalMethod = method;
         Object finalObj = obj;
         mRunnable = () -> {
             try {
                 finalMethod.invoke(finalObj, oParam);
             } catch (IllegalAccessException | InvocationTargetException e) {
                 e.printStackTrace();
             }
             finally {

             }
         };

         mThread = new Thread(mRunnable);
         mStatus = Status.Ready;

         mEasyThreadModel.Name = methodName;
         mEasyThreadModel.Runnable = mRunnable;
         mEasyThreadModel.Method = finalMethod;
         mEasyThreadModel.Status = mStatus;
         mEasyThreadModel.Object = finalObj;
         mEasyThreadModel.Param = oParam;
         mEasyThreadModel.Thread = mThread;
     }

     public void run(){
        if(mThread != null){
            mStatus = Status.Running;
            mThread.run();
        }
    }

    public void start(){
        if(mThread != null){
            mStatus = Status.Started;
            mThread.start();
        }
    }

    public void stopThread() {
        if(mThread != null){
            mStatus = Status.Stop;
            mThread.stop();
        }
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Status getStatus() {
        return mStatus;
    }

    public Runnable getRunnable() {
        return mRunnable;
    }
    public EasyThreadModel getModel() {
        return mEasyThreadModel;
    }

 }
