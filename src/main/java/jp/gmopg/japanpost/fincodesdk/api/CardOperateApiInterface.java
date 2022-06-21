package jp.gmopg.japanpost.fincodesdk.api;

import java.util.Map;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public interface CardOperateApiInterface {

    @GET("/v1/customers/{customerId}/cards")
    Call<FincodeCardInfoListResponse> cardInfoList(@HeaderMap Map<String, String> headers,
                                                   @Path("customerId") String customerId);

    @POST("/v1/customers/{customerId}/cards")
    Call<FincodeCardInfo> cardRegister(@HeaderMap Map<String, String> headers,
                                       @Body FincodeCardInfoRequest request,
                                       @Path("customerId") String customerId);

    @PUT("/v1/customers/{customerId}/cards/{cardId}")
    Call<FincodeCardInfo> cardUpdate(@HeaderMap Map<String, String> headers,
                                                 @Body FincodeCardInfoRequest request,
                                                 @Path("customerId") String customerId,
                                                 @Path("cardId") String cardId);
}
