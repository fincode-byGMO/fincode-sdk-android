package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public class FincodePaymentResponse {

    @SerializedName("acs")
    private String acs;

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

    @SerializedName("item_code")
    private String itemCode;

    @SerializedName("amount")
    private Long amount;

    @SerializedName("tax")
    private Long tax;

    @SerializedName("total_amount")
    private Long totalAmount;

    @SerializedName("customer_group_id")
    private String customerGroupId;

    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("card_no")
    private String cardNo;

    @SerializedName("card_id")
    private String cardId;

    @SerializedName("expire")
    private String expire;

    @SerializedName("holder_name")
    private String holderName;

    @SerializedName("card_no_hash")
    private String cardNoHash;

    @SerializedName("method")
    private String method;

    @SerializedName("pay_times")
    private Long payTimes;

    @SerializedName("forward")
    private String forward;

    @SerializedName("issuer")
    private String issuer;

    @SerializedName("transaction_id")
    private String transactionId;

    @SerializedName("approve")
    private String approve;

    @SerializedName("auth_max_date")
    private String authMaxDate;

    @SerializedName("client_field_1")
    private String clientField1;

    @SerializedName("client_field_2")
    private String clientField2;

    @SerializedName("client_field_3")
    private String clientField3;

    @SerializedName("tds_type")
    private String tdsType;

    @SerializedName("tds2_type")
    private String tds2Type;

    @SerializedName("tds2_ret_url")
    private String tds2RetUrl;

    @SerializedName("tds2_status")
    private String tds2Status;

    @SerializedName("merchant_name")
    private String merchantName;

    @SerializedName("send_url")
    private String sendUrl;

    @SerializedName("subscription_id")
    private String subscriptionId;

    @SerializedName("bulk_payment_id")
    private String bulkPaymentId;

    @SerializedName("brand")
    private String cardBrand;

    @SerializedName("error_code")
    private String errorCode;

    @SerializedName("acs_url")
    private String acsUrl;

    @SerializedName("pa_req")
    private String paReq;

    @SerializedName("created")
    private String created;

    @SerializedName("updated")
    private String updated;

    public String getAcs() { return this.acs; }

    public void setAcs(String acs) { this.acs = acs; }

    public String getShopId() { return this.shopId; }

    public void setShopId(String shopId) { this.shopId = shopId; }

    public String getOrderId() { return this.orderId; }

    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getPayType() { return this.payType; }

    public void setPayType(String payType) { this.payType = payType; }

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    public String getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCardNoHash() {
        return cardNoHash;
    }

    public void setCardNoHash(String cardNoHash) {
        this.cardNoHash = cardNoHash;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getPayTimes() {
        return payTimes;
    }

    public void setPayTimes(Long payTimes) {
        this.payTimes = payTimes;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }

    public String getAuthMaxDate() {
        return authMaxDate;
    }

    public void setAuthMaxDate(String authMaxDate) {
        this.authMaxDate = authMaxDate;
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

    public String getTdsType() {
        return tdsType;
    }

    public void setTdsType(String tdsType) {
        this.tdsType = tdsType;
    }

    public String getTds2Type() {
        return tds2Type;
    }

    public void setTds2Type(String tds2Type) {
        this.tds2Type = tds2Type;
    }

    public String getTds2RetUrl() {
        return tds2RetUrl;
    }

    public void setTds2RetUrl(String tds2RetUrl) {
        this.tds2RetUrl = tds2RetUrl;
    }

    public String getTds2Status() {
        return tds2Status;
    }

    public void setTds2Status(String tds2Status) {
        this.tds2Status = tds2Status;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getBulkPaymentId() {
        return bulkPaymentId;
    }

    public void setBulkPaymentId(String cardBrand) {
        this.bulkPaymentId = bulkPaymentId;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getAcsUrl() {
        return acsUrl;
    }

    public void setAcsUrl(String acsUrl) {
        this.acsUrl = acsUrl;
    }

    public String getPaReq() {
        return paReq;
    }

    public void setPaReq(String paReq) {
        this.paReq = paReq;
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