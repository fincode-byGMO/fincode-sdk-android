package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ito on 2023/07/28.
 */
public class FincodeKonbiniResponse {

    @SerializedName("shop_id")
    private String shopId;

    @SerializedName("id")
    private String orderId;

    @SerializedName("pay_type")
    private String payType;

    @SerializedName("status")
    private String status;

    @SerializedName("access_id")
    private String accessId;

    @SerializedName("process_date")
    private String processDate;

    @SerializedName("amount")
    private Long amount;

    @SerializedName("tax")
    private Long tax;

    @SerializedName("total_amount")
    private Long totalAmount;

    @SerializedName("payment_term_day")
    private String paymentTermDay;

    @SerializedName("payment_term")
    private String paymentTerm;

    @SerializedName("device_name")
    private String deviceName;

    @SerializedName("os_version")
    private String osVersion;

    @SerializedName("win_width")
    private String winWidth;

    @SerializedName("win_height")
    private String winHeight;

    @SerializedName("xdpi")
    private String xdpi;

    @SerializedName("ydpi")
    private String ydpi;

    @SerializedName("client_field_1")
    private String clientField1;

    @SerializedName("client_field_2")
    private String clientField2;

    @SerializedName("client_field_3")
    private String clientField3;

    @SerializedName("result")
    private String result;

    @SerializedName("order_serial")
    private String orderSerial;

    @SerializedName("invoice_id")
    private String invoiceId;

    @SerializedName("barcode")
    private String barcode;

    @SerializedName("barcode_format")
    private String barcodeFormat;

    @SerializedName("barcode_width")
    private String barcodeWidth;

    @SerializedName("barcode_height")
    private String barcodeHeight;

    @SerializedName("payment_date")
    private String paymentDate;

    @SerializedName("konbini_code")
    private String konbiniCode;

    @SerializedName("konbini_store_code")
    private String konbiniStoreCode;

    @SerializedName("error_code")
    private String errorCode;

    @SerializedName("overpayment_flag")
    private String overpaymentFlag;

    @SerializedName("cancel_overpayment_flag")
    private String cancelOverpaymentFlag;

    @SerializedName("created")
    private String created;

    @SerializedName("updated")
    private String updated;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentTermDay() {
        return paymentTermDay;
    }

    public void setPaymentTermDay(String paymentTermDay) {
        this.paymentTermDay = paymentTermDay;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
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

    public String getXdpi() {
        return xdpi;
    }

    public void setXdpi(String xdpi) {
        this.xdpi = xdpi;
    }

    public String getYdpi() {
        return ydpi;
    }

    public void setYdpi(String ydpi) {
        this.ydpi = ydpi;
    }

    public String getClientField1() {
        return clientField1;
    }

    public void setClientField1(String clientField1) {
        this.clientField1 = clientField1;
    }

    public String getClientField2() {
        return clientField2;
    }

    public void setClientField2(String clientField2) {
        this.clientField2 = clientField2;
    }

    public String getClientField3() {
        return clientField3;
    }

    public void setClientField3(String clientField3) {
        this.clientField3 = clientField3;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOrderSerial() {
        return orderSerial;
    }

    public void setOrderSerial(String orderSerial) {
        this.orderSerial = orderSerial;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcodeFormat() {
        return barcodeFormat;
    }

    public void setBarcodeFormat(String barcodeFormat) {
        this.barcodeFormat = barcodeFormat;
    }

    public String getBarcodeWidth() {
        return barcodeWidth;
    }

    public void setBarcodeWidth(String barcodeWidth) {
        this.barcodeWidth = barcodeWidth;
    }

    public String getBarcodeHeight() {
        return barcodeHeight;
    }

    public void setBarcodeHeight(String barcodeHeight) {
        this.barcodeHeight = barcodeHeight;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getKonbiniCode() {
        return konbiniCode;
    }

    public void setKonbiniCode(String konbiniCode) {
        this.konbiniCode = konbiniCode;
    }

    public String getKonbiniStoreCode() {
        return konbiniStoreCode;
    }

    public void setKonbiniStoreCode(String konbiniStoreCode) {
        this.konbiniStoreCode = konbiniStoreCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getOverpaymentFlag() {
        return overpaymentFlag;
    }

    public void setOverpaymentFlag(String overpaymentFlag) {
        this.overpaymentFlag = overpaymentFlag;
    }

    public String getCancelOverpaymentFlag() {
        return cancelOverpaymentFlag;
    }

    public void setCancelOverpaymentFlag(String cancelOverpaymentFlag) {
        this.cancelOverpaymentFlag = cancelOverpaymentFlag;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}