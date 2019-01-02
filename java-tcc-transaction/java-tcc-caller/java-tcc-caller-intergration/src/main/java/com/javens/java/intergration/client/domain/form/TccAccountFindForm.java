/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.intergration.client.domain.form;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 *
 * @author liujing01
 * @version TccAccountFindForm.java, v 0.1 2019-01-02 15:12 
 */
public class TccAccountFindForm implements Serializable {


    private static final long serialVersionUID = 5091316509684246129L;


    private Integer id;

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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
