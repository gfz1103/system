package com.buit.his.sys.centermaintenance.enums;

/**
 * 调价单生效判别枚举
 * fee_xmfytj01.sxpb
 */
public enum TjdSxpbEnum {

    DEACTIVATE(0, "未生效"),
    ACTIVATE(1, "已生效"),
    CANCELED(2, "作废");

    private int value;
    private String text;

    TjdSxpbEnum(int value, String text) {
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
