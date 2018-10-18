/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;

/**
 * @author zhilinzhang
 * @version PayPlatformEnum.java, v 0.1 2018-09-03 11:53
 */
public enum PayPlatformEnum {
    //1微信支付,2支付宝,3会员卡,4京东支付 5银联 6 QQ钱包 7支付宝口碑 8翼支付
    //微信
    WX(1),
    //支付宝
    ALIPAY(2),
    //会员卡
    MEMBERCARD(3),
    //京东
    JD(4),
    //银联
    UNION(5),
    //QQ钱包
    QQ(6),
    //口碑
    KOUBEI(7);

    private int value = 0;

    PayPlatformEnum(int value) {
        this.value = value;
    }

    public static PayPlatformEnum valueOf(int value) {
        switch (value) {
            case 1:
                return WX;
            case 2:
                return ALIPAY;
            case 3:
                return MEMBERCARD;
            case 4:
                return JD;
            case 5:
                return UNION;
            case 6:
                return QQ;
            default:
                return KOUBEI;
        }
    }

    public int value() {
        return this.value;
    }


}