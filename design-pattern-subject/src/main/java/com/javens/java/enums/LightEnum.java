package com.javens.java.enums;

/**
 * @author liujing01
 * @version Light.java, v 0.1 2018-11-10 08:57
 */
public enum LightEnum {
    RED("红灯",1),
    YELLOW("黄灯",2),
    GREEN("绿灯",3);
    /**
     * 枚举列表
     */
    ;

    private String name;
    private Integer value;

    LightEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public Integer getValue() {
        return value;
    }

    public static LightEnum getByValue(Integer value) {
        LightEnum[] valueList = LightEnum.values();
        for (LightEnum v : valueList) {
            if (v.getValue().equals(value)) {
                return v;
            }
        }
        return null;
    }
}