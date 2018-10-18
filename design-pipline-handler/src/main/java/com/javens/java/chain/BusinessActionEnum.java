package com.javens.java.chain;

/**
 * Created by Gonzo on 17-9-21.
 */
public enum BusinessActionEnum {
    INVEST("INVEST"),
    RECHARGE("RECHARGE");

    private String typeName;
    BusinessActionEnum(String typeName) {
        this.typeName = typeName;

    }
}
