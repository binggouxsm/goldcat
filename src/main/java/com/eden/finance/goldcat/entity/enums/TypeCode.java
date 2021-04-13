package com.eden.finance.goldcat.entity.enums;


public enum TypeCode  {
    IN_OUT_TYPE(1,"收入支出类型"),
    ACCOUNT_TYPE(20,"账户类型"),
    ASSET_TYPE(40,"资产负债类型");

    private int value;
    private String desc;

    TypeCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return this.value;
    }
}
