package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ito on 2023/07/28.
 */
public class FincodeKonbiniRequest {

    @SerializedName("pay_type")
    private String payType;

    @SerializedName("access_id")
    private String accessId;

    @SerializedName("id")
    private String orderId;

    @SerializedName("payment_term_day")
    private String paymentTermDay;

    @SerializedName("device_name")
    private String deviceName;

    @SerializedName("win_width")
    private String winWidth;

    @SerializedName("win_height")
    private String winHeight;

    @SerializedName("pixel_ratio")
    private String pixelRatio;

    @SerializedName("win_size_type")
    private String winSizeType;

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

    public String getPaymentTermDay() {
        return paymentTermDay;
    }

    public void setPaymentTermDay(String paymentTermDay) {
        this.paymentTermDay = paymentTermDay;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getWinWidth() {
        return winWidth;
    }

    public void setWinWidth(String winWidth) {
        this.winWidth = winWidth;
    }

    public String getWinHeight() {
        return winHeight;
    }

    public void setWinHeight(String winHeight) {
        this.winHeight = winHeight;
    }

    public String getPixelRatio() {
        return pixelRatio;
    }

    public void setPixelRatio(String pixelRatio) {
        this.pixelRatio = pixelRatio;
    }

    public String getWinSizeType() {
        return winSizeType;
    }

    public void setWinSizeType(String winSizeType) {
        this.winSizeType = winSizeType;
    }
}
