package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a.nakajima on 2022/06/14.
 */
public class FincodeErrorInfo {

    @SerializedName("error_code")
    private String code;

    @SerializedName("error_message")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
