package jp.gmopg.japanpost.fincodesdk.api;

import java.util.Map;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeSettlementRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeSettlementResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public interface SettlementApiInterface {

    @PUT("/v1/payments/{id}")
    Call<FincodeSettlementResponse> settlement(@HeaderMap Map<String, String> headers,
                                               @Body FincodeSettlementRequest request,
                                               @Path("id") String orderId);
}
