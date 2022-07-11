package jp.gmopg.japanpost.fincodesdk.entities.api;

/**
 * Created by a.nakajima on 2022/06/14.
 */
public class FincodeErrorInfo {

    private String code;
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
