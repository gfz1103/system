package com.buit.his.enums;

/**
 * 设备启用状态枚举
 * dic_device.status
 */
public enum DeviceStatusEnum {

    ENABLE(0, "启用"),
    DISABLE(1, "停用");

    private int value;
    private String text;

    DeviceStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //参数类型不能改为int 否则Integer类型入参会调用enum类equals(Object o)方法，而非本方法
    public boolean equals(Integer value) {
        return this.value == value;
    }
}
