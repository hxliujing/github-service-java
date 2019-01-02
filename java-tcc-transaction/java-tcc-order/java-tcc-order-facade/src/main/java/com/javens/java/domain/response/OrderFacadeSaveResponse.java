/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.domain.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 *
 * @author liujing01
 * @version OrderFacadeSaveResponse.java, v 0.1 2019-01-02 14:31 
 */
public class OrderFacadeSaveResponse implements Serializable {

    private static final long serialVersionUID = -3271075793123146715L;
    private Long result;

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public Long getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(Long result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
