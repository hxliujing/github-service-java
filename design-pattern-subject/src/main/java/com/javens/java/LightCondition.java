/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java;

import com.javens.java.model.Light;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author liujing01
 * @version LightCondition.java, v 0.1 2018-11-10 09:46 
 */
public class LightCondition {
    private Light[] lights;
    public LightCondition(Light... lights){
        this.lights = lights;
    }

    /**
     * Getter method for property <tt>lights</tt>.
     *
     * @return property value of lights
     */
    public Light[] getLights() {
        return lights;
    }

    /**
     * Setter method for property <tt>lights</tt>.
     *
     * @param lights value to be assigned to property lights
     */
    public void setLights(Light[] lights) {
        this.lights = lights;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * 判断是否在条件里面
     * @param params
     * @return
     */
    public  boolean condition(Light[] params) {
        if(params==null || params.length==0){
            return false;
        }
        if(lights==null || lights.length==0){
            return true;
        }
        int rightButton = lights.length;
        AtomicInteger checkButton = new AtomicInteger(0);
        for(Light light: lights){
            for(Light param: params){
                if(light.getType() == param.getType() &&
                        light.getButton() == param.getButton()
                        ){
                    checkButton.incrementAndGet();
                }
            }
        }
        return checkButton.get() == rightButton;
    }
}
