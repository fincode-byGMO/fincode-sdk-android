package com.epsilon.fincode.fincodesdk.api;

import java.util.Map;

import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentSecureRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentSecureResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public interface PaymentApiInterface {

    @PUT("/v1/payments/{id}")
    Call<FincodePaymentResponse> payment(@HeaderMap Map<String, String> headers,
                                         @Body FincodePaymentRequest request,
                                         @Path("id") String orderId);
    @PUT("/v1/payments/{id}/secure")
    Call<FincodePaymentSecureResponse> paymentSecure(@HeaderMap Map<String, String> headers,
                                                     @Body FincodePaymentSecureRequest request,
                                                     @Path("id") String id);
}
