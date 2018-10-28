package com.lyc.singleton;

/**
 * 双重检查锁实现单例模式
 * 一般不用此方式,由于编译器优化原因和JVM底层内部模型原因，偶尔会出问题。不建议使用
 */
public class SingletonDemo3 {

    private static SingletonDemo3 instance = null;

    public static SingletonDemo3 getInstance() {
        if (instance == null) {
            SingletonDemo3 sc;
            synchronized (SingletonDemo3.class) {
                sc = instance;
                if (sc == null) {
                    synchronized (SingletonDemo3.class) {
                        if(sc == null) {
                            sc = new SingletonDemo3();
                        }
                    }
                    instance = sc;
                }
            }
        }
        return instance;
    }

    private SingletonDemo3() {

    }
}
