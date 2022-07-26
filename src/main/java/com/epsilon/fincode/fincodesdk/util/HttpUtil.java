package com.epsilon.fincode.fincodesdk.util;

import com.google.gson.Gson;

import java.io.IOException;

import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorInfo;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorInfoList;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by a.nakajima on 2022/06/15.
 */
public class HttpUtil {

    private static Gson gson = new Gson();

    public static <T> FincodeErrorResponse getErrorInfo(Response<T> response, String value) {

        return new FincodeErrorResponse(response.code(), gson.fromJson(value, FincodeErrorInfoList.class));
    }

}
