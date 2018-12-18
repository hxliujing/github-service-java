/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.singletion;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author liujing01
 * @version Singleton.java, v 0.1 2018-12-07 09:07 
 */
public class Singleton {
    private volatile  static  Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 线程安全问题，此处是线程进来后，i变量相当于new出来的。不存在多个线程修改同一个共享数据源
     * @return
     */
    public int getNum(){
        int i = 0;
        for(int j=0;j<10;j++){
            i ++;
        }
        return  i;
    }
    /**
     * 线程安全问题，此处是线程进来后，i变量相当于new出来的。不存在多个线程修改同一个共享数据源
     * @return
     */
    public int getAtomicNum(){
        AtomicInteger i = new AtomicInteger();
        for(int j=0;j<10;j++){
            i.incrementAndGet();
        }
        return i.get();
    }

}
