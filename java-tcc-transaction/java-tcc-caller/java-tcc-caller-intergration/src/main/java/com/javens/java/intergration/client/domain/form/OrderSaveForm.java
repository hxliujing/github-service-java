/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.intergration.client.domain.form;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author liujing01
 * @version OrderSaveForm.java, v 0.1 2019-01-02 14:53 
 */
public class OrderSaveForm implements Serializable{

    private static final long serialVersionUID = 2498309801452111179L;
    /**
     * id ID.
     */
    private Integer id;
    /**
     * type 支付方式,	1WAP,2APP.
     */
    private Integer type;
    /**
     * isDel 0-正常，1-删除.
     */
    private Integer isDel;
    /**
     * amount 订单金额.
     */
    private BigDecimal amount;
    /**
     * orderSn 订单编号.
     */
    private String orderSn;
    /**
     * accountId UNION 账户ID.
     */
    private Integer accountId;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;


    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>type</tt>.
     *
     * @return property value of type
     */
    public Integer getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     *
     * @param type value to be assigned to property type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Getter method for property <tt>isDel</tt>.
     *
     * @return property value of isDel
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * Setter method for property <tt>isDel</tt>.
     *
     * @param isDel value to be assigned to property isDel
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     *
     * @return property value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     *
     * @param amount value to be assigned to property amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * Getter method for property <tt>accountId</tt>.
     *
     * @return property value of accountId
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * Setter method for property <tt>accountId</tt>.
     *
     * @param accountId value to be assigned to property accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter method for property <tt>createTime</tt>.
     *
     * @return property value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     *
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property <tt>updateTime</tt>.
     *
     * @return property value of updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * Setter method for property <tt>updateTime</tt>.
     *
     * @param updateTime value to be assigned to property updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
