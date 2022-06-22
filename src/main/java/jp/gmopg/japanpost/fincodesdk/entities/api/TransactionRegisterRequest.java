package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ohkawa on 2022/06/21.
 */
public class TransactionRegisterRequest {

    @SerializedName("pay_type")
    private String payType;

    @SerializedName("id")
    private String orderId;

    @SerializedName("job_code")
    private String jobCode;

    @SerializedName("amount")
    private String amount;

    @SerializedName("tax")
    private String tax;

    @SerializedName("item_code")
    private String itemCode;

    @SerializedName("client_field_1")
    private String clientField1;

    @SerializedName("client_field_2")
    private String clientField2;

    @SerializedName("client_field_3")
    private String clientField3;

    @SerializedName("send_url")
    private String sendUrl;

    @SerializedName("tds_type")
    private String tdsType;

    @SerializedName("td_tenant_name")
    private String tdTenantName;

    @SerializedName("tds2_type")
    private String tds2Type;

    @SerializedName("subscription_id")
    private String subscriptionId;

    public TransactionRegisterRequest(
        String payType,
        String orderId,
        String jobCode,
        String amount,
        String tax,
        String itemCode,
        String clientField1,
        String clientField2,
        String clientField3,
        String sendUrl,
        String tdsType,
        String tdTenantName,
        String tds2Type,
        String subscriptionId
    ){
        this.payType = payType;
        this.orderId = orderId;
        this.jobCode = jobCode;
        this.amount = amount;
        this.tax = tax;
        this.itemCode = itemCode;
        this.clientField1 = clientField1;
        this.clientField2 = clientField2;
        this.clientField3 = clientField3;
        this.sendUrl = sendUrl;
        this.tdsType = tdsType;
        this.tdTenantName = tdTenantName;
        this.tds2Type = tds2Type;
        this.subscriptionId = subscriptionId;
    }

    public TransactionRegisterRequest(
            String payType,
            String jobCode,
            String amount,
            String tdsType
    ){
        this.payType = payType;
        this.jobCode = jobCode;
        this.amount = amount;
        this.tdsType = tdsType;
    }

    public TransactionRegisterRequest(){}

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }

    public String getTdsType() {
        return tdsType;
    }

    public void setTdsType(String tdsType) {
        this.tdsType = tdsType;
    }

    public String getTdTenantName() {
        return tdTenantName;
    }

    public void setTdTenantName(String tdTenantName) {
        this.tdTenantName = tdTenantName;
    }

    public String getTds2Type() {
        return tds2Type;
    }

    public void setTds2Type(String tds2Type) {
        this.tds2Type = tds2Type;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

}
