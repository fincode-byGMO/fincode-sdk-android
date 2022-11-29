package com.epsilon.fincode.fincodesdk.Repository;

import java.io.IOException;
import java.util.HashMap;

import com.epsilon.fincode.fincodesdk.api.AsyncHttpClient;
import com.epsilon.fincode.fincodesdk.api.AuthenticationApiInterface;
import com.epsilon.fincode.fincodesdk.api.FincodeCallback;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeAuthRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeAuthResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeGetResultResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentSecureRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentSecureResponse;
import com.epsilon.fincode.fincodesdk.util.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m.sakaida on 2022/10/28.
 */
public class FincodeAuthRepository {

    private static FincodeAuthRepository instance;

    private FincodeAuthRepository() {
    }

    public static FincodeAuthRepository getInstance() {
        if(instance == null) {
            instance = new FincodeAuthRepository();
        }
        return instance;
    }

    public void authentication(HashMap<String, String> header, String id, FincodeAuthRequest request, FincodeCallback<FincodeAuthResponse> fincodeCallback) {
        AuthenticationApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(AuthenticationApiInterface.class);

        api.authentication(header, request, id)
                .enqueue(new Callback<FincodeAuthResponse>() {
                    @Override
                    public void onResponse(Call<FincodeAuthResponse> call, Response<FincodeAuthResponse> response) {
                        if(response.isSuccessful()) {
                            fincodeCallback.onResponse(response.body());
                        } else {
                            try {
                                String value = response.errorBody().string();
                                fincodeCallback.onFailure(HttpUtil.getErrorInfo(response, value));
                            } catch (IOException e) {
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<FincodeAuthResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void getResult(HashMap<String, String> header, String id, FincodeCallback<FincodeGetResultResponse> fincodeCallback) {
        AuthenticationApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(AuthenticationApiInterface.class);

        api.getResult(header, id)
                .enqueue(new Callback<FincodeGetResultResponse>() {
                    @Override
                    public void onResponse(Call<FincodeGetResultResponse> call, Response<FincodeGetResultResponse> response) {
                        if(response.isSuccessful()) {
                            fincodeCallback.onResponse(response.body());
                        } else {
                            try {
                                String value = response.errorBody().string();
                                fincodeCallback.onFailure(HttpUtil.getErrorInfo(response, value));
                            } catch (IOException e) {
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<FincodeGetResultResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

}