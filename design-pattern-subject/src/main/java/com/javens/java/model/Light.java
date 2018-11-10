/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.model;

import com.javens.java.enums.LightButtonEnum;
import com.javens.java.enums.LightEnum;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author liujing01
 * @version Light.java, v 0.1 2018-11-10 09:02 
 */
public class Light {

    public Light(LightEnum type, LightButtonEnum button) {
        this.type = type;
        this.button = button;
    }

    /**
     * 灯类型
     */
    LightEnum type;
    /**
     * 开关状态，on=true,off = false
     */
    LightButtonEnum button;


    /**
     * Getter method for property <tt>type</tt>.
     *
     * @return property value of type
     */
    public LightEnum getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     *
     * @param type value to be assigned to property type
     */
    public void setType(LightEnum type) {
        this.type = type;
    }

    /**
     * Getter method for property <tt>button</tt>.
     *
     * @return property value of button
     */
    public LightButtonEnum getButton() {
        return button;
    }

    /**
     * Setter method for property <tt>button</tt>.
     *
     * @param button value to be assigned to property button
     */
    public void setButton(LightButtonEnum button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
