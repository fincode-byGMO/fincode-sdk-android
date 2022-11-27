package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.sakaida on 2022/10/27.
 */
public class FincodeAuthResponse {

    @SerializedName("tds2_trans_result")
    private String tdsTransResult;

    @SerializedName("tds2_trans_result_reason")
    private String tdsTransResultReason;

    @SerializedName("challenge_url")
    private String challegeUrl;

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

    public String getChallegeUrl() {
        return challegeUrl;
    }

    public void setChallegeUrl(String challegeUrl) {
        this.challegeUrl = challegeUrl;
    }
}