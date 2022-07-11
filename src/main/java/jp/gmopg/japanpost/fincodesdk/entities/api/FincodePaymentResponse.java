package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

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

    @Expose
    @SerializedName("process_date")
    private Date processDate;

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

    @Expose
    @SerializedName("auth_max_date")
    private Date authMaxDate;

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

    @SerializedName("brand")
    private String cardBrand;

    @SerializedName("error_code")
    private String errorCode;

    @SerializedName("acs_url")
    private String acsUrl;

    @SerializedName("pa_req")
    private String paReq;

    @Expose
    @SerializedName("created")
    private Date created;

    @Expose
    @SerializedName("updated")
    private Date updated;

}
