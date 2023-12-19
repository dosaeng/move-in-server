package com.kreit.movein.enumeration;

import lombok.Getter;

@Getter
public enum FilterCardStatusEnum {
    DEFAULT_CREATED("DEFAULT-CREATED"),
    OPEN("OPEN"),
    CLOSE("CLOSE");

    private final String str;

    FilterCardStatusEnum(String str) {
        this.str = str;
    }
}
