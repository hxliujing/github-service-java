/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.design.light;

import com.javens.java.design.light.enums.LightButtonEnum;
import com.javens.java.design.light.model.Light;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  设计红黄绿(Red,Yellow,Green)灯
 * @author liujing01
 * @version DesignRYGLight.java, v 0.1 2018-11-10 08:56 
 */
public class DesignRedGreenYellowLight {
    private List<LightCondition> list;



    /**
     * Setter method for property <tt>list</tt>.
     *
     * @param list value to be assigned to property list
     */
    public void setList(List<LightCondition> list) {
        this.list = list;
    }

    /**
s     * 是否需要打开开关
     * @param lights
     * @return boolean
     */
    public boolean open(Light... lights){

        if(list==null || list.isEmpty()){
            return true;
        }
        return condition(lights);
    }

    /**
     * 判断是否在条件里面
     * @param params
     * @return
     */
    private  boolean condition(Light... params) {
        if(params==null || params.length==0){
            return false;
        }
        AtomicInteger checkButton = new AtomicInteger(0);
        for(LightCondition condition : list){
            if(condition.condition(params)){
                checkButton.incrementAndGet();
                break;
            }
        }
        return checkButton.get() > 0;
    }
}