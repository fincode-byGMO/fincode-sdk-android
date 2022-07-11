package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.ohkawa on 2022/06/20.
 */
public class FincodeCardRegisterRequest {

    @SerializedName("default_flag")
    private String defaltFlag;

    @SerializedName("card_no")
    private String cardNo;

    @SerializedName("expire")
    private String expire;

    @SerializedName("holder_name")
    private String holderName;

    @SerializedName("security_code")
    private String securityCode;

    @SerializedName("token")
    private String token;

    public String getDefaltFlag() {
        return defaltFlag;
    }

    public void setDefaltFlag(String defaltFlag) {
        this.defaltFlag = defaltFlag;
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


    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
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
}
