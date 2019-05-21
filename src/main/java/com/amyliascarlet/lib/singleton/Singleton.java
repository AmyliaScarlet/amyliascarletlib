package com.amyliascarlet.lib.singleton;

import java.lang.reflect.Constructor;

public class Singleton {

    protected Singleton() {

    }
    private static Object obj = null;

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }


    public static Object getSingleton(Class<?> clz)  {

        synchronized (clz) {
            try {
                if(obj != null){
                    return obj;
                }else {
                    return clz.newInstance();
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static <T> T getInstanceByReflex(Class<T> clz)  {
        //通过反射方式获取对象
        T singleton = null;
        Constructor<?> constructor = null;//获取当前Class所表示类中指定的一个的构造器
        try {
            constructor = clz.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (constructor != null) {
            constructor.setAccessible(true);  //设置私有方法的可访问
            try {
                if(obj != null){
                    singleton = (T) obj;
                }else {
                    singleton = clz.newInstance();//实例化对象
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return singleton;
    }

}
