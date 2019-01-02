package com.javens.java.service.dal.tcc_java_order.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* The table TCC_ORDER
*/
public class OrderDO{

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
    * orderStatus 状态.
    */
    private String orderStatus;

    /**
    * Set id ID.
    */
    public void setId(Integer id){
        this.id = id;
    }

    /**
    * Get id ID.
    *
    * @return the string
    */
    public Integer getId(){
        return id;
    }

    /**
    * Set type 支付方式,	1WAP,2APP.
    */
    public void setType(Integer type){
        this.type = type;
    }

    /**
    * Get type 支付方式,	1WAP,2APP.
    *
    * @return the string
    */
    public Integer getType(){
        return type;
    }

    /**
    * Set isDel 0-正常，1-删除.
    */
    public void setIsDel(Integer isDel){
        this.isDel = isDel;
    }

    /**
    * Get isDel 0-正常，1-删除.
    *
    * @return the string
    */
    public Integer getIsDel(){
        return isDel;
    }

    /**
    * Set amount 订单金额.
    */
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    /**
    * Get amount 订单金额.
    *
    * @return the string
    */
    public BigDecimal getAmount(){
        return amount;
    }

    /**
    * Set orderSn 订单编号.
    */
    public void setOrderSn(String orderSn){
        this.orderSn = orderSn;
    }

    /**
    * Get orderSn 订单编号.
    *
    * @return the string
    */
    public String getOrderSn(){
        return orderSn;
    }

    /**
    * Set accountId UNION 账户ID.
    */
    public void setAccountId(Integer accountId){
        this.accountId = accountId;
    }

    /**
    * Get accountId UNION 账户ID.
    *
    * @return the string
    */
    public Integer getAccountId(){
        return accountId;
    }

    /**
    * Set createTime 创建时间.
    */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
    * Get createTime 创建时间.
    *
    * @return the string
    */
    public Date getCreateTime(){
        return createTime;
    }

    /**
    * Set updateTime 修改时间.
    */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
    * Get updateTime 修改时间.
    *
    * @return the string
    */
    public Date getUpdateTime(){
        return updateTime;
    }

    /**
    * Set orderStatus 状态.
    */
    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    /**
    * Get orderStatus 状态.
    *
    * @return the string
    */
    public String getOrderStatus(){
        return orderStatus;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
        ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
