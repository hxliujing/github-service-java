package com.javens.java.service.dal.tcc_java_account.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* The table TCC_ACCOUNT
*/
public class AccountDO{

    /**
    * id ID.
    */
    private Integer id;
    /**
    * type 账户类型,	1WAP,2APP.
    */
    private Integer type;
    /**
    * isDel 0-正常，1-删除.
    */
    private Integer isDel;
    /**
    * amount 账户余额.
    */
    private BigDecimal amount;
    /**
    * createTime 创建时间.
    */
    private Date createTime;
    /**
    * updateTime 修改时间.
    */
    private Date updateTime;

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
    * Set type 账户类型,	1WAP,2APP.
    */
    public void setType(Integer type){
        this.type = type;
    }

    /**
    * Get type 账户类型,	1WAP,2APP.
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
    * Set amount 账户余额.
    */
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    /**
    * Get amount 账户余额.
    *
    * @return the string
    */
    public BigDecimal getAmount(){
        return amount;
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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
        ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
