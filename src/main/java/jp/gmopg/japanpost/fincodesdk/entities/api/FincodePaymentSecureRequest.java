package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;
public class FincodePaymentSecureRequest {
    @SerializedName("pay_type")
    private String payType;

    @SerializedName("access_id")
    private String accessId;

    @SerializedName("id")
    private String id;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
