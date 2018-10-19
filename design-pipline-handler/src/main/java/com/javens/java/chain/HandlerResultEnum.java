/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;

/**
 * @author liujing01
 * @version HandlerResultEnum.java, v 0.1 2018-09-03 11:53
 */
public enum HandlerResultEnum {
    SUCCESS(200, "成功"),
    ERROR(0, "失败"),
    ;

    private Integer code;
    private String value;

    HandlerResultEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static PayTypeEnum getByValue(Integer code) {
        PayTypeEnum[] valueList = PayTypeEnum.values();
        for (PayTypeEnum v : valueList) {
            if (v.getCode().equals(code)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public String getValue() {
        return value;
    }


}