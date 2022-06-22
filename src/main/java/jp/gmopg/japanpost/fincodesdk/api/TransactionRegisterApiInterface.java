package jp.gmopg.japanpost.fincodesdk.api;

import java.util.Map;

import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by m.ohkawa on 2022/06/21.
 */
public interface TransactionRegisterApiInterface {

    @POST("/v1/payments")
    Call<TransactionRegisterResponse> transactionRegister(@HeaderMap Map<String, String> headers,
                                                          @Body TransactionRegisterRequest request);
}
