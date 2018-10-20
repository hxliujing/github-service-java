/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;

/**
 *
 * @author liujing01
 * @version HandlerModel.java, v 0.1 2018-10-18 08:59 
 */
public class HandlerRequest<T extends HandlerResult> {
    private PayPlatformEnum payPlatformEnum;
    private PayTypeEnum payTypeEnum;
    /**
     * 订单号
     */
    private String orderSn;
    /**
     * 用户token值
     */
    private String token;

    private T result;

    /**
     * Getter method for property <tt>payPlatformEnum</tt>.
     *
     * @return property value of payPlatformEnum
     */
    public PayPlatformEnum getPayPlatformEnum() {
        return payPlatformEnum;
    }

    /**
     * Setter method for property <tt>payPlatformEnum</tt>.
     *
     * @param payPlatformEnum value to be assigned to property payPlatformEnum
     */
    public void setPayPlatformEnum(PayPlatformEnum payPlatformEnum) {
        this.payPlatformEnum = payPlatformEnum;
    }

    /**
     * Getter method for property <tt>payTypeEnum</tt>.
     *
     * @return property value of payTypeEnum
     */
    public PayTypeEnum getPayTypeEnum() {
        return payTypeEnum;
    }

    /**
     * Setter method for property <tt>payTypeEnum</tt>.
     *
     * @param payTypeEnum value to be assigned to property payTypeEnum
     */
    public void setPayTypeEnum(PayTypeEnum payTypeEnum) {
        this.payTypeEnum = payTypeEnum;
    }

    /**
     * Getter method for property <tt>orderSn</tt>.
     *
     * @return property value of orderSn
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * Setter method for property <tt>orderSn</tt>.
     *
     * @param orderSn value to be assigned to property orderSn
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * Getter method for property <tt>token</tt>.
     *
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     *
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public T getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(T result) {
        this.result = result;
    }
}
