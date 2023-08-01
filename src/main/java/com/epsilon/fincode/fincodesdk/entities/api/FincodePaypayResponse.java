package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ito on 2023/07/28.
 */
public class FincodePaypayResponse {

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

    @SerializedName("job_code")
    private String jobCode;

    @SerializedName("amount")
    private Long amount;

    @SerializedName("tax")
    private Long tax;

    @SerializedName("total_amount")
    private Long totalAmount;

    @SerializedName("customer_id")
    private Long customerId;

    @SerializedName("code_expiry_date")
    private String codeExpiryDate;

    @SerializedName("auth_max_date")
    private String authMaxDate;

    @SerializedName("order_description")
    private String orderDescription;

    @SerializedName("capture_description")
    private String captureDescription;

    @SerializedName("update_description")
    private String updateDescription;

    @SerializedName("cancel_description")
    private String cancelDescription;

    @SerializedName("redirect_url")
    private String redirectUrl;

    @SerializedName("redirect_type")
    private String redirectType;

    @SerializedName("client_field_1")
    private String clientField1;

    @SerializedName("client_field_2")
    private String clientField2;

    @SerializedName("client_field_3")
    private String clientField3;

    @SerializedName("store_id")
    private String storeId;

    @SerializedName("code_id")
    private String codeId;

    @SerializedName("code_url")
    private String codeUrl;

    @SerializedName("payment_id")
    private String paymentId;

    @SerializedName("paypay_result_code")
    private String paypayResultCode;

    @SerializedName("merchant_payment_id")
    private String merchantPaymentId;

    @SerializedName("merchant_capture_id")
    private String merchantCaptureId;

    @SerializedName("merchant_update_id")
    private String merchantUpdateId;

    @SerializedName("merchant_revert_id")
    private String merchantRevertId;

    @SerializedName("merchant_refund_id")
    private String merchantRefundId;

    @SerializedName("payment_date")
    private String paymentDate;

    @SerializedName("error_code")
    private String errorCode;

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

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCodeExpiryDate() {
        return codeExpiryDate;
    }

    public void setCodeExpiryDate(String codeExpiryDate) {
        this.codeExpiryDate = codeExpiryDate;
    }

    public String getAuthMaxDate() {
        return authMaxDate;
    }

    public void setAuthMaxDate(String authMaxDate) {
        this.authMaxDate = authMaxDate;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getCaptureDescription() {
        return captureDescription;
    }

    public void setCaptureDescription(String captureDescription) {
        this.captureDescription = captureDescription;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getCancelDescription() {
        return cancelDescription;
    }

    public void setCancelDescription(String cancelDescription) {
        this.cancelDescription = cancelDescription;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaypayResultCode() {
        return paypayResultCode;
    }

    public void setPaypayResultCode(String paypayResultCode) {
        this.paypayResultCode = paypayResultCode;
    }

    public String getMerchantPaymentId() {
        return merchantPaymentId;
    }

    public void setMerchantPaymentId(String merchantPaymentId) {
        this.merchantPaymentId = merchantPaymentId;
    }

    public String getMerchantCaptureId() {
        return merchantCaptureId;
    }

    public void setMerchantCaptureId(String merchantCaptureId) {
        this.merchantCaptureId = merchantCaptureId;
    }

    public String getMerchantUpdateId() {
        return merchantUpdateId;
    }

    public void setMerchantUpdateId(String merchantUpdateId) {
        this.merchantUpdateId = merchantUpdateId;
    }

    public String getMerchantRevertId() {
        return merchantRevertId;
    }

    public void setMerchantRevertId(String merchantRevertId) {
        this.merchantRevertId = merchantRevertId;
    }

    public String getMerchantRefundId() {
        return merchantRefundId;
    }

    public void setMerchantRefundId(String merchantRefundId) {
        this.merchantRefundId = merchantRefundId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
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