package com.kreit.movein.enumeration;

import lombok.Getter;

@Getter
public enum ConsultationStatusEnum {
    WAITING("WAITING"),
    DONE("DONE");

    private final String str;

    ConsultationStatusEnum(String str) {
        this.str = str;
    }
}
