package com.epsilon.fincode.fincodesdk.api;

import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardInfoListResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorInfo;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;

/**
 * Created by fincode on 2022/06/15.
 */
public interface FincodeCallback<T> {
    void onResponse(T response);
    void onFailure(FincodeErrorResponse errorInfo);
}
