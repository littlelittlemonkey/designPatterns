package com.lyc.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种创建单例模式的效率
 */
public class SingletonTest2 {

    public static void main(String[] args) throws Exception {

        test1();
    }
    public static void test1(){
        System.out.println("--------饿汉式调--------");
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for(int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int i=0;i<1000000;i++){
						Object o = SingletonDemo1.getInstance();
//                        Object o = SingletonDemo5.INSTANCE;
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        try {

            countDownLatch.await();	//main线程阻塞，直到计数器变为0，才会继续往下执行！
        }catch ( Exception e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }

}
