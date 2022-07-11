package jp.gmopg.japanpost.fincodesdk.entities.api;

/**
 * Created by a.nakajima on 2022/06/15.
 */
public class FincodeErrorResponse {

    public final Integer statusCode;
    public final FincodeErrorInfo errorInfo;

    public FincodeErrorResponse(int statusCode, FincodeErrorInfo errorInfo) {
        this.statusCode = statusCode;
        this.errorInfo = errorInfo;
    }
}
