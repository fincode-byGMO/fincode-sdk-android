package com.epsilon.fincode.fincodesdk.enumeration;

/**
 * Created by a.nakajima on 2022/07/05.
 */
public enum MethodType {
    ONE_TIME("1"),
    INSTALLMENT("2");

    private String value;

    private MethodType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
