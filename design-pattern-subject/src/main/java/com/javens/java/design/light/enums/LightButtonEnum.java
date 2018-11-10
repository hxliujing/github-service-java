package com.javens.java.design.light.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liujing01
 * @version LightButton.java, v 0.1 2018-11-10 09:15
 */
public enum LightButtonEnum {
    /**
     * 枚举列表
     */
    OFF("关闭","off"),
    ON("打开","on"),
    /**
     * 枚举列表
     */
    ;

    private String name;
    private String value;

    LightButtonEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public String getValue() {
        return value;
    }

    public static LightButtonEnum getByValue(String value) {
        LightButtonEnum[] valueList = LightButtonEnum.values();
        for (LightButtonEnum v : valueList) {
            if (StringUtils.equalsIgnoreCase(v.getValue(), value)) {
                return v;
            }
        }
        return null;
    }
}