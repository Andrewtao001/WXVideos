package com.lnsfwx.utils;

public enum UserVideoStatusEnum {
    SUCCESS(1),
    BAN(0);
    public final int value ;

    UserVideoStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
