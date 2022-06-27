package jp.gmopg.japanpost.fincodesdk.api;

import java.util.Map;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
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

    @POST("/v1/payments")
    Call<TransactionRegisterResponse> transactionRegister(@HeaderMap Map<String, String> headers,
                                                          @Body TransactionRegisterRequest request);
}
