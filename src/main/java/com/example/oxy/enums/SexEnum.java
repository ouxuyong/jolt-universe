package com.example.oxy.enums;


import lombok.Getter;

/**
 * @author oxy
 */

public enum SexEnum {
    MAN("男", "man"),
    WOMAN("女", "woman");

    @Getter
    private String desc;

    @Getter
    private String code;

    SexEnum(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}
