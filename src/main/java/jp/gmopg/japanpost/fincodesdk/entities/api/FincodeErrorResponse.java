package jp.gmopg.japanpost.fincodesdk.entities.api;

/**
 * Created by a.nakajima on 2022/06/15.
 */
public class FincodeErrorResponse {

    public final Integer statusCode;
    public final FincodeErrorInfoList errorInfo;

    public FincodeErrorResponse(int statusCode, FincodeErrorInfoList errorInfo) {
        this.statusCode = statusCode;
        this.errorInfo = errorInfo;
    }
}
