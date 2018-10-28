package com.lyc.singleton;

/**
 * 饿汉式单例模式
 * 缺点类加载时就创建对象，可能并没有用到，浪费内存
 */
public class SingletonDemo1 {

    //类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全的！
    private static SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1(){
    }

    //方法没有同步，调用效率高！
    public static SingletonDemo1  getInstance(){
        return instance;
    }
}
