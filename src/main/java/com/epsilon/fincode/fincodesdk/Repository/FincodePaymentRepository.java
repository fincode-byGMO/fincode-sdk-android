package com.epsilon.fincode.fincodesdk.Repository;

import com.epsilon.fincode.fincodesdk.entities.api.FincodeKonbiniRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeKonbiniResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaypayRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaypayResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import com.epsilon.fincode.fincodesdk.api.AsyncHttpClient;
import com.epsilon.fincode.fincodesdk.api.AuthenticationApiInterface;
import com.epsilon.fincode.fincodesdk.api.FincodeCallback;
import com.epsilon.fincode.fincodesdk.api.PaymentApiInterface;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorInfoList;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentSecureRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentSecureResponse;
import com.epsilon.fincode.fincodesdk.util.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public class FincodePaymentRepository {

    private static FincodePaymentRepository instance;

    private FincodePaymentRepository() {
    }

    public static FincodePaymentRepository getInstance() {
        if(instance == null) {
            instance = new FincodePaymentRepository();
        }
        return instance;
    }

    public void payment(HashMap<String, String> header, String orderId, FincodePaymentRequest request, FincodeCallback<FincodePaymentResponse> fincodeCallback) {
        PaymentApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(PaymentApiInterface.class);

        api.payment(header, request, orderId)
                .enqueue(new Callback<FincodePaymentResponse>() {
                    @Override
                    public void onResponse(Call<FincodePaymentResponse> call, Response<FincodePaymentResponse> response) {
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
                    public void onFailure(Call<FincodePaymentResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void payment(HashMap<String, String> header, String orderId, FincodeKonbiniRequest request, FincodeCallback<FincodeKonbiniResponse> fincodeCallback) {
        PaymentApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(PaymentApiInterface.class);

        api.payment(header, request, orderId)
                .enqueue(new Callback<FincodeKonbiniResponse>() {
                    @Override
                    public void onResponse(Call<FincodeKonbiniResponse> call, Response<FincodeKonbiniResponse> response) {
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
                    public void onFailure(Call<FincodeKonbiniResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void payment(HashMap<String, String> header, String orderId, FincodePaypayRequest request, FincodeCallback<FincodePaypayResponse> fincodeCallback) {
        PaymentApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(PaymentApiInterface.class);

        api.payment(header, request, orderId)
                .enqueue(new Callback<FincodePaypayResponse>() {
                    @Override
                    public void onResponse(Call<FincodePaypayResponse> call, Response<FincodePaypayResponse> response) {
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
                    public void onFailure(Call<FincodePaypayResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void paymentSecure(HashMap<String, String> header, String id, FincodePaymentSecureRequest request, FincodeCallback<FincodePaymentSecureResponse> fincodeCallback) {
        PaymentApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(PaymentApiInterface.class);

        api.paymentSecure(header, request, id)
                .enqueue(new Callback<FincodePaymentSecureResponse>() {
                    @Override
                    public void onResponse(Call<FincodePaymentSecureResponse> call, Response<FincodePaymentSecureResponse> response) {
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
                    public void onFailure(Call<FincodePaymentSecureResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

}
