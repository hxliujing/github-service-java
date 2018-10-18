/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;

/**
 * @author yangdw
 * @version PayTypeEnum.java, v 0.1 2018-09-09 下午3:33
 */
public enum PayTypeEnum {
    //1WAP,2APP,3刷卡,4扫码(3、4属于商户版),5公共号会员卡充值,12H5支付.
    WAP_PAY(1, "WAP支付"),
    APP_PAY(2, "APP支付"),
    SCAN_PAY(3, "刷卡支付"),
    QRCODE_PAY(4, "扫码支付"),
    MEMBER_PAY(5, "公共号会员卡充值"),
    QRCODE_FIXED_PAY(9, "定额二维码支付"),
    H5_PAY(12, "H5支付"),;

    private Integer code;
    private String value;

    PayTypeEnum(Integer code, String value) {
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
