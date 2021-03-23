package com.eden.finance.goldcat.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum TypeCode implements IEnum<Integer> {
    IN_OUT_TYPE(1,"收入支出类型"),
    ACCOUNT_TYPE(20,"账户类型"),
    ASSET_TYPE(40,"资产负债类型");

    private int value;
    private String desc;

    TypeCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
