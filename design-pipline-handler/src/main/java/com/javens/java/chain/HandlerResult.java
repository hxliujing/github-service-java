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
public class HandlerResult {
    private int code;
    private String result;


    public HandlerResult(int code,String result){
        this.code = code;
        this.result = result;
    }

    public HandlerResult(HandlerResultEnum resultEnum){
        create(resultEnum);
    }

    private void create(HandlerResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.result = resultEnum.getValue();
    }

    public HandlerResult(){
        create(HandlerResultEnum.SUCCESS);
    }
    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public String getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "code="+code + ",result="+result;
    }
}
