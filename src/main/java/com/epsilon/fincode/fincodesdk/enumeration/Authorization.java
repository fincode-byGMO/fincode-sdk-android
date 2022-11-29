package com.epsilon.fincode.fincodesdk.enumeration;

/**
 * Created by a.nakajima on 2022/07/04.
 */
public enum Authorization {
    NONE(""),
    BASIC("Basic"),
    BEARER("Bearer");

    private String value;

    private Authorization(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
