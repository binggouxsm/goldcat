package com.eden.finance.goldcat.system.entity.enums;


public enum TypeCode  {
    IN_OUT_TYPE(1,"收入支出类型"),
    IN(2,"收入"),
    OUT(3,"支出"),
    TRANSFER(4,"转账"),
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

    public static Integer resolveDesc(String desc){
        TypeCode[] all = TypeCode.values();
        for (TypeCode code : all){
            if(desc != null && desc.equals(code.desc))
                return code.value;
        }
        return null;
    }


}
