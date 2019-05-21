package com.amyliascarlet.lib.thread;

import com.amyliascarlet.lib.log.Log;

import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolManager extends EastThreadExpand {
    /**
     * 单例设计模式（饿汉式）
     *  单例首先私有化构造方法，然后饿汉式一开始就开始创建，并提供get方法
     */
    private static ThreadPoolManager mInstance = new ThreadPoolManager();
    public static ThreadPoolManager getInstance() {
        return mInstance;
    }

    private IdentityHashMap<String, EasyThreadModel> mThreadModelMap = new IdentityHashMap<>();

    private int AvailableCore = Runtime.getRuntime().availableProcessors();//当前设备可用处理器核心数

    private int corePoolSize;//核心线程池的数量，同时能够执行的线程数量
    private int maximumPoolSize;//最大线程池数量，表示当缓冲队列满的时候能继续容纳的等待任务的数量
    private long keepAliveTime = 1;//存活时间
    private TimeUnit unit = TimeUnit.HOURS;
    private ThreadPoolExecutor executor;
    private LinkedBlockingQueue mLinkedBlockingQueue = new LinkedBlockingQueue<>();

    //存储线程的返回值
    List<Future<String>> results = new LinkedList<Future<String>>();

    ThreadPoolManager() {
        /**
         * 给corePoolSize赋值：当前设备可用处理器核心数*2 + 1,能够让cpu的效率得到最大程度执行（有研究论证的）
         */
        corePoolSize = AvailableCore*2+1;
        maximumPoolSize = corePoolSize; //虽然maximumPoolSize用不到，但是需要赋值，否则报错
        executor = new ThreadPoolExecutor(
                corePoolSize, //当某个核心任务执行完毕，会依次从缓冲队列中取出等待任务
                maximumPoolSize, //5,先corePoolSize,然后new LinkedBlockingQueue<Runnable>(),然后maximumPoolSize,但是它的数量是包含了corePoolSize的
                keepAliveTime, //表示的是maximumPoolSize当中等待任务的存活时间
                unit,
                mLinkedBlockingQueue, //缓冲队列，用于存放等待任务，Linked的先进先出
                Executors.defaultThreadFactory(), //创建线程的工厂
                new ThreadPoolExecutor.CallerRunsPolicy() //用来对超出maximumPoolSize的任务的处理策略
        );
    }
    /**
     * 执行任务
     */
    public void execute(Runnable runnable){
        if(runnable==null)
            throw new ThreadException("runnable is null can't execute");

        executor.execute(runnable);
    }
    public void execute(EasyThreadModel easyThreadModel){
        if(easyThreadModel.Status != Status.Ready)
            throw new ThreadException("Thread is not Ready");

        execute(easyThreadModel.Runnable);
        easyThreadModel.Status = Status.Running;
        mThreadModelMap.put(easyThreadModel.Name, easyThreadModel);
    }

    /**
     * 从线程池中移除任务
     */
    public void remove(Runnable runnable){
        if(runnable==null)
            throw new ThreadException("runnable is null can't remove");

        executor.remove(runnable);
    }
    public void remove(EasyThreadModel easyThreadModel){
        if(easyThreadModel.Status != Status.Running)
            throw new ThreadException("Thread is not Running");

        remove(easyThreadModel.Runnable);
        easyThreadModel.Status = Status.Remove;
        mThreadModelMap.remove(easyThreadModel.Name, easyThreadModel);
    }

    public IdentityHashMap<String, EasyThreadModel> getEasyThreadModels(){
        return mThreadModelMap;
    }


    /**
     * Initiates an orderly shutdown in which previously submitted
     * tasks are executed, but no new tasks will be accepted.
     * Invocation has no additional effect if already shut down.
     * 开始一个有序的关闭，在关闭中，之前提交的任务会被执行（包含正在执行的，在阻塞队列中的），但新任务会被拒绝
     * 如果线程池已经shutdown，调用此方法不会有附加效应

     * 当前方法不会等待之前提交的任务执行结束，可以使用awaitTermination()
     */
    void shutdown() {
        executor.shutdown();
    }

    public IdentityHashMap<String, EasyThreadModel> shutdownNow() {
        List<Runnable> list = executor.shutdownNow();

        final IdentityHashMap<String, EasyThreadModel> leftThreadModelMap = mThreadModelMap;
        IdentityHashMap<String, EasyThreadModel> _ThreadModelMap = new IdentityHashMap<>();

        for (Map.Entry<String, EasyThreadModel> entry : leftThreadModelMap.entrySet()) {
           if(list.contains(entry.getValue().Runnable)){
               _ThreadModelMap.put(entry.getKey(),entry.getValue());
           }
        }
        return _ThreadModelMap;
    }
}