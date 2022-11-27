package jp.gmopg.japanpost.fincodesdk.api;

import java.util.Map;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeAuthRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeAuthResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeGetResultResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentSecureRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentSecureResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
* Created by m.sakaida on 2022/10/26.
*/
public interface AuthenticationApiInterface {

    @PUT("/v1/secure2/{id}")
    Call<FincodeAuthResponse> authentication(@HeaderMap Map<String, String> headers,
                                      @Body FincodeAuthRequest request,
                                      @Path("id") String orderId);

    @GET("/v1/secure2/{id}")
    Call<FincodeGetResultResponse> getResult(@HeaderMap Map<String, String> headers,
                                                       @Path("id") String id);

}