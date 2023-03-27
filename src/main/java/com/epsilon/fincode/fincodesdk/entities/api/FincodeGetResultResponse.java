package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fincode on 2022/10/27.
 */
public class FincodeGetResultResponse {

    @SerializedName("tds2_trans_result")
    private String tdsTransResult;

    @SerializedName("tds2_trans_result_reason")
    private String tdsTransResultReason;

    public String getTdsTransResult() {
        return tdsTransResult;
    }

    public void setTdsTransResult(String tdsTransResult) {
        this.tdsTransResult = tdsTransResult;
    }

    public String getTdsTransResultReason() {
        return tdsTransResultReason;
    }

    public void setTdsTransResultReason(String tdsTransResultReason) {
        this.tdsTransResultReason = tdsTransResultReason;
    }
}