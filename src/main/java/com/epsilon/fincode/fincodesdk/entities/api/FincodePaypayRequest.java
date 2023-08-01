package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ito on 2023/07/28.
 */
public class FincodePaypayRequest {

    @SerializedName("pay_type")
    private String payType;

    @SerializedName("access_id")
    private String accessId;

    @SerializedName("id")
    private String orderId;

    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("redirect_url")
    private String redirectUrl;

    @SerializedName("redirect_type")
    private String redirectType;

    @SerializedName("user_agent")
    private String userAgent;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        this.redirectType = redirectType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
