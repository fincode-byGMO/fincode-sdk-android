package jp.gmopg.japanpost.fincodesdk.api;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;

/**
 * Created by fincode on 2022/06/15.
 */
public interface FincodeCallback<T> {
    void onResponse(T response);
    void onFailure(FincodeErrorResponse errorInfo);
}
