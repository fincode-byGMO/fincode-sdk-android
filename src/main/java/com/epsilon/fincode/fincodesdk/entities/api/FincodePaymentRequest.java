package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public class FincodePaymentRequest {

    @SerializedName("pay_type")
    private String payType;

    @SerializedName("access_id")
    private String accessId;

    @SerializedName("id")
    private String orderId;

    @SerializedName("token")
    private String token;

    @SerializedName("card_no")
    private String cardNo;

    @SerializedName("expire")
    private String expire;

    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("card_id")
    private String cardId;

    @SerializedName("method")
    private String method;

    @SerializedName("pay_times")
    private String payTimes;

    @SerializedName("security_code")
    private String securityCode;

    @SerializedName("holder_name")
    private String holderName;

    @SerializedName("tds2_ret_url")
    private String tds2RetUrl;

    @SerializedName("tds2_ch_acc_change")
    private String tds2ChAccChange;

    @SerializedName("tds2_ch_acc_date")
    private String tds2ChAccDate;

    @SerializedName("tds2_ch_acc_pw_change")
    private String tds2ChAccPwChange;

    @SerializedName("tds2_nb_purchase_account")
    private String tds2NbPurchaseAccount;

    @SerializedName("tds2_payment_acc_age")
    private String tds2PaymentAccAge;

    @SerializedName("tds2_provision_attempts_day")
    private String tds2ProvisionAttemptsDay;

    @SerializedName("tds2_ship_address_usage")
    private String tds2ShipAddressUsage;

    @SerializedName("tds2_ship_name_ind")
    private String tds2ShipNameInd;

    @SerializedName("tds2_suspicious_acc_activity")
    private String tds2SuspiciousAccActivity;

    @SerializedName("tds2_txn_activity_day")
    private String tds2TxnActivityDay;

    @SerializedName("tds2_txn_activity_year")
    private String tds2TxnActivityYear;

    @SerializedName("tds2_three_ds_req_auth_data")
    private String tds2ThreeDsReqAuthData;

    @SerializedName("tds2_three_ds_req_auth_method")
    private String tds2ThreeDsReqAuthMethod;

    @SerializedName("tds2_three_ds_req_auth_timestamp")
    private String tds2ThreeDsReqAuthTimestamp;

    @SerializedName("tds2_addr_match")
    private String tds2AddrMatch;

    @SerializedName("tds2_bill_addr_city")
    private String tds2BillAddrCity;

    @SerializedName("tds2_bill_addr_country")
    private String tds2BillAddrCountry;

    @SerializedName("tds2_bill_addr_line_1")
    private String tds2BillAddrLine1;

    @SerializedName("tds2_bill_addr_line_2")
    private String tds2BillAddrLine2;

    @SerializedName("tds2_bill_addr_line_3")
    private String tds2BillAddrLine3;

    @SerializedName("tds2_bill_addr_post_code")
    private String tds2BillAddrPostCode;

    @SerializedName("tds2_bill_addr_state")
    private String tds2BillAddrState;

    @SerializedName("tds2_email")
    private String tds2Email;

    @SerializedName("tds2_home_phone_cc")
    private String tds2HomePhoneCc;

    @SerializedName("tds2_home_phone_no")
    private String tds2HomePhoneNo;

    @SerializedName("tds2_mobile_phone_cc")
    private String tds2MobilePhoneCc;

    @SerializedName("tds2_mobile_phone_no")
    private String tds2MobilePhoneNo;

    @SerializedName("tds2_work_phone_cc")
    private String tds2WorkPhoneCc;

    @SerializedName("tds2_work_phone_no")
    private String tds2WorkPhoneNo;

    @SerializedName("tds2_ship_addr_city")
    private String tds2ShipAddrCity;

    @SerializedName("tds2_ship_addr_country")
    private String tds2ShipAddrCountry;

    @SerializedName("tds2_ship_addr_line_1")
    private String tds2ShipAddrLine1;

    @SerializedName("tds2_ship_addr_line_2")
    private String tds2ShipAddrLine2;

    @SerializedName("tds2_ship_addr_line_3")
    private String tds2ShipAddrLine3;

    @SerializedName("tds2_ship_addr_post_code")
    private String tds2ShipAddrPostCode;

    @SerializedName("tds2_ship_addr_state")
    private String tds2ShipAddrState;

    @SerializedName("tds2_delivery_email_address")
    private String tds2DeliveryEmailAddress;

    @SerializedName("tds2_delivery_timeframe")
    private String tds2DeliveryTimeframe;

    @SerializedName("tds2_gift_card_amount")
    private String tds2GiftCardAmount;

    @SerializedName("tds2_gift_card_count")
    private String tds2GiftCardCount;

    @SerializedName("tds2_gift_card_curr")
    private String tds2GiftCardCurr;

    @SerializedName("tds2_pre_order_date")
    private String tds2PreOrderDate;

    @SerializedName("tds2_pre_order_purchaseInd")
    private String tds2PreOrderPurchaseInd;

    @SerializedName("tds2_reorder_items_ind")
    private String tds2ReorderItemsInd;

    @SerializedName("tds2_ship_ind")
    private String tds2ShipInd;

    @SerializedName("tds2_recurring_expiry")
    private String tds2RecurringExpiry;

    @SerializedName("tds2_recurring_frequency")
    private String tds2RecurringFrequency;


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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPayTimes() {
        return payTimes;
    }

    public void setPayTimes(String payTimes) {
        this.payTimes = payTimes;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getTds2RetUrl() {
        return tds2RetUrl;
    }

    public void setTds2RetUrl(String tds2RetUrl) {
        this.tds2RetUrl = tds2RetUrl;
    }

    public String getTds2ChAccChange() {
        return tds2ChAccChange;
    }

    public void setTds2ChAccChange(String tds2ChAccChange) {
        this.tds2ChAccChange = tds2ChAccChange;
    }

    public String getTds2ChAccDate() {
        return tds2ChAccDate;
    }

    public void setTds2ChAccDate(String tds2ChAccDate) {
        this.tds2ChAccDate = tds2ChAccDate;
    }

    public String getTds2ChAccPwChange() {
        return tds2ChAccPwChange;
    }

    public void setTds2ChAccPwChange(String tds2ChAccPwChange) {
        this.tds2ChAccPwChange = tds2ChAccPwChange;
    }

    public String getTds2NbPurchaseAccount() {
        return tds2NbPurchaseAccount;
    }

    public void setTds2NbPurchaseAccount(String tds2NbPurchaseAccount) {
        this.tds2NbPurchaseAccount = tds2NbPurchaseAccount;
    }

    public String getTds2PaymentAccAge() {
        return tds2PaymentAccAge;
    }

    public void setTds2PaymentAccAge(String tds2PaymentAccAge) {
        this.tds2PaymentAccAge = tds2PaymentAccAge;
    }

    public String getTds2ProvisionAttemptsDay() {
        return tds2ProvisionAttemptsDay;
    }

    public void setTds2ProvisionAttemptsDay(String tds2ProvisionAttemptsDay) {
        this.tds2ProvisionAttemptsDay = tds2ProvisionAttemptsDay;
    }

    public String getTds2ShipAddressUsage() {
        return tds2ShipAddressUsage;
    }

    public void setTds2ShipAddressUsage(String tds2ShipAddressUsage) {
        this.tds2ShipAddressUsage = tds2ShipAddressUsage;
    }

    public String getTds2ShipNameInd() {
        return tds2ShipNameInd;
    }

    public void setTds2ShipNameInd(String tds2ShipNameInd) {
        this.tds2ShipNameInd = tds2ShipNameInd;
    }

    public String getTds2SuspiciousAccActivity() {
        return tds2SuspiciousAccActivity;
    }

    public void setTds2SuspiciousAccActivity(String tds2SuspiciousAccActivity) {
        this.tds2SuspiciousAccActivity = tds2SuspiciousAccActivity;
    }

    public String getTds2TxnActivityDay() {
        return tds2TxnActivityDay;
    }

    public void setTds2TxnActivityDay(String tds2TxnActivityDay) {
        this.tds2TxnActivityDay = tds2TxnActivityDay;
    }

    public String getTds2TxnActivityYear() {
        return tds2TxnActivityYear;
    }

    public void setTds2TxnActivityYear(String tds2TxnActivityYear) {
        this.tds2TxnActivityYear = tds2TxnActivityYear;
    }

    public String getTds2ThreeDsReqAuthData() {
        return tds2ThreeDsReqAuthData;
    }

    public void setTds2ThreeDsReqAuthData(String tds2ThreeDsReqAuthData) {
        this.tds2ThreeDsReqAuthData = tds2ThreeDsReqAuthData;
    }

    public String getTds2ThreeDsReqAuthMethod() {
        return tds2ThreeDsReqAuthMethod;
    }

    public void setTds2ThreeDsReqAuthMethod(String tds2ThreeDsReqAuthMethod) {
        this.tds2ThreeDsReqAuthMethod = tds2ThreeDsReqAuthMethod;
    }

    public String getTds2ThreeDsReqAuthTimestamp() {
        return tds2ThreeDsReqAuthTimestamp;
    }

    public void setTds2ThreeDsReqAuthTimestamp(String tds2ThreeDsReqAuthTimestamp) {
        this.tds2ThreeDsReqAuthTimestamp = tds2ThreeDsReqAuthTimestamp;
    }

    public String getTds2AddrMatch() {
        return tds2AddrMatch;
    }

    public void setTds2AddrMatch(String tds2AddrMatch) {
        this.tds2AddrMatch = tds2AddrMatch;
    }

    public String getTds2BillAddrCity() {
        return tds2BillAddrCity;
    }

    public void setTds2BillAddrCity(String tds2BillAddrCity) {
        this.tds2BillAddrCity = tds2BillAddrCity;
    }

    public String getTds2BillAddrCountry() {
        return tds2BillAddrCountry;
    }

    public void setTds2BillAddrCountry(String tds2BillAddrCountry) {
        this.tds2BillAddrCountry = tds2BillAddrCountry;
    }

    public String getTds2BillAddrLine1() {
        return tds2BillAddrLine1;
    }

    public void setTds2BillAddrLine1(String tds2BillAddrLine1) {
        this.tds2BillAddrLine1 = tds2BillAddrLine1;
    }

    public String getTds2BillAddrLine2() {
        return tds2BillAddrLine2;
    }

    public void setTds2BillAddrLine2(String tds2BillAddrLine2) {
        this.tds2BillAddrLine2 = tds2BillAddrLine2;
    }

    public String getTds2BillAddrLine3() {
        return tds2BillAddrLine3;
    }

    public void setTds2BillAddrLine3(String tds2BillAddrLine3) {
        this.tds2BillAddrLine3 = tds2BillAddrLine3;
    }

    public String getTds2BillAddrPostCode() {
        return tds2BillAddrPostCode;
    }

    public void setTds2BillAddrPostCode(String tds2BillAddrPostCode) {
        this.tds2BillAddrPostCode = tds2BillAddrPostCode;
    }

    public String getTds2BillAddrState() {
        return tds2BillAddrState;
    }

    public void setTds2BillAddrState(String tds2BillAddrState) {
        this.tds2BillAddrState = tds2BillAddrState;
    }

    public String getTds2Email() {
        return tds2Email;
    }

    public void setTds2Email(String tds2Email) {
        this.tds2Email = tds2Email;
    }

    public String getTds2HomePhoneCc() {
        return tds2HomePhoneCc;
    }

    public void setTds2HomePhoneCc(String tds2HomePhoneCc) {
        this.tds2HomePhoneCc = tds2HomePhoneCc;
    }

    public String getTds2HomePhoneNo() {
        return tds2HomePhoneNo;
    }

    public void setTds2HomePhoneNo(String tds2HomePhoneNo) {
        this.tds2HomePhoneNo = tds2HomePhoneNo;
    }

    public String getTds2MobilePhoneCc() {
        return tds2MobilePhoneCc;
    }

    public void setTds2MobilePhoneCc(String tds2MobilePhoneCc) {
        this.tds2MobilePhoneCc = tds2MobilePhoneCc;
    }

    public String getTds2MobilePhoneNo() {
        return tds2MobilePhoneNo;
    }

    public void setTds2MobilePhoneNo(String tds2MobilePhoneNo) {
        this.tds2MobilePhoneNo = tds2MobilePhoneNo;
    }

    public String getTds2WorkPhoneCc() {
        return tds2WorkPhoneCc;
    }

    public void setTds2WorkPhoneCc(String tds2WorkPhoneCc) {
        this.tds2WorkPhoneCc = tds2WorkPhoneCc;
    }

    public String getTds2WorkPhoneNo() {
        return tds2WorkPhoneNo;
    }

    public void setTds2WorkPhoneNo(String tds2WorkPhoneNo) {
        this.tds2WorkPhoneNo = tds2WorkPhoneNo;
    }

    public String getTds2ShipAddrCity() {
        return tds2ShipAddrCity;
    }

    public void setTds2ShipAddrCity(String tds2ShipAddrCity) {
        this.tds2ShipAddrCity = tds2ShipAddrCity;
    }

    public String getTds2ShipAddrCountry() {
        return tds2ShipAddrCountry;
    }

    public void setTds2ShipAddrCountry(String tds2ShipAddrCountry) {
        this.tds2ShipAddrCountry = tds2ShipAddrCountry;
    }

    public String getTds2ShipAddrLine1() {
        return tds2ShipAddrLine1;
    }

    public void setTds2ShipAddrLine1(String tds2ShipAddrLine1) {
        this.tds2ShipAddrLine1 = tds2ShipAddrLine1;
    }

    public String getTds2ShipAddrLine2() {
        return tds2ShipAddrLine2;
    }

    public void setTds2ShipAddrLine2(String tds2ShipAddrLine2) {
        this.tds2ShipAddrLine2 = tds2ShipAddrLine2;
    }

    public String getTds2ShipAddrLine3() {
        return tds2ShipAddrLine3;
    }

    public void setTds2ShipAddrLine3(String tds2ShipAddrLine3) {
        this.tds2ShipAddrLine3 = tds2ShipAddrLine3;
    }

    public String getTds2ShipAddrPostCode() {
        return tds2ShipAddrPostCode;
    }

    public void setTds2ShipAddrPostCode(String tds2ShipAddrPostCode) {
        this.tds2ShipAddrPostCode = tds2ShipAddrPostCode;
    }

    public String getTds2ShipAddrState() {
        return tds2ShipAddrState;
    }

    public void setTds2ShipAddrState(String tds2ShipAddrState) {
        this.tds2ShipAddrState = tds2ShipAddrState;
    }

    public String getTds2DeliveryEmailAddress() {
        return tds2DeliveryEmailAddress;
    }

    public void setTds2DeliveryEmailAddress(String tds2DeliveryEmailAddress) {
        this.tds2DeliveryEmailAddress = tds2DeliveryEmailAddress;
    }

    public String getTds2DeliveryTimeframe() {
        return tds2DeliveryTimeframe;
    }

    public void setTds2DeliveryTimeframe(String tds2DeliveryTimeframe) {
        this.tds2DeliveryTimeframe = tds2DeliveryTimeframe;
    }

    public String getTds2GiftCardAmount() {
        return tds2GiftCardAmount;
    }

    public void setTds2GiftCardAmount(String tds2GiftCardAmount) {
        this.tds2GiftCardAmount = tds2GiftCardAmount;
    }

    public String getTds2GiftCardCount() {
        return tds2GiftCardCount;
    }

    public void setTds2GiftCardCount(String tds2GiftCardCount) {
        this.tds2GiftCardCount = tds2GiftCardCount;
    }

    public String getTds2GiftCardCurr() {
        return tds2GiftCardCurr;
    }

    public void setTds2GiftCardCurr(String tds2GiftCardCurr) {
        this.tds2GiftCardCurr = tds2GiftCardCurr;
    }

    public String getTds2PreOrderDate() {
        return tds2PreOrderDate;
    }

    public void setTds2PreOrderDate(String tds2PreOrderDate) {
        this.tds2PreOrderDate = tds2PreOrderDate;
    }

    public String getTds2PreOrderPurchaseInd() {
        return tds2PreOrderPurchaseInd;
    }

    public void setTds2PreOrderPurchaseInd(String tds2PreOrderPurchaseInd) {
        this.tds2PreOrderPurchaseInd = tds2PreOrderPurchaseInd;
    }

    public String getTds2ReorderItemsInd() {
        return tds2ReorderItemsInd;
    }

    public void setTds2ReorderItemsInd(String tds2ReorderItemsInd) {
        this.tds2ReorderItemsInd = tds2ReorderItemsInd;
    }

    public String getTds2ShipInd() {
        return tds2ShipInd;
    }

    public void setTds2ShipInd(String tds2ShipInd) {
        this.tds2ShipInd = tds2ShipInd;
    }

    public String getTds2RecurringExpiry() {
        return tds2RecurringExpiry;
    }

    public void setTds2RecurringExpiry(String tds2RecurringExpiry) {
        this.tds2RecurringExpiry = tds2RecurringExpiry;
    }

    public String getTds2RecurringFrequency() {
        return tds2RecurringFrequency;
    }

    public void setTds2RecurringFrequency(String tds2RecurringFrequency) {
        this.tds2RecurringFrequency = tds2RecurringFrequency;
    }

}
