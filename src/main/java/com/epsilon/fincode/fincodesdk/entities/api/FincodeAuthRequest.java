package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fincode on 2022/10/27.
 */
public class FincodeAuthRequest {

    @SerializedName("param")
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

}