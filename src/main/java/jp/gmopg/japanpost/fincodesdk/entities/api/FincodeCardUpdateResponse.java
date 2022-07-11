package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by m.ohkawa on 2022/06/06.
 */
public class FincodeCardUpdateResponse {

    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("id")
    private String cardId;

    @SerializedName("default_flag")
    private String defaltFlag;

    @SerializedName("card_no")
    private String cardNo;

    @SerializedName("expire")
    private String expire;

    @SerializedName("holder_name")
    private String holderName;

    @SerializedName("card_no_hash")
    private String cardNoHash;

    @Expose
    @SerializedName("created")
    private Date created;

    @Expose
    @SerializedName("updated")
    private Date updated;

    @SerializedName("type")
    private String cardType;

    @SerializedName("brand")
    private String cardBrand;

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

    public String getDefaltFlag() {
        return defaltFlag;
    }

    public void setDefaltFlag(String defaltFlag) {
        this.defaltFlag = defaltFlag;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

}
