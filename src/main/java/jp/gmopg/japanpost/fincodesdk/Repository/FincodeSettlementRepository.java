package jp.gmopg.japanpost.fincodesdk.Repository;

import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.api.AsyncHttpClient;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.api.SettlementApiInterface;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeSettlementRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeSettlementResponse;
import jp.gmopg.japanpost.fincodesdk.util.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public class FincodeSettlementRepository {

    private static FincodeSettlementRepository instance;

    private FincodeSettlementRepository() {
    }

    public static FincodeSettlementRepository getInstance() {
        if(instance == null) {
            instance = new FincodeSettlementRepository();
        }
        return instance;
    }

    public void settlement(HashMap<String, String> header, String orderId, FincodeSettlementRequest request, FincodeCallback<FincodeSettlementResponse> fincodeCallback) {
        SettlementApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(SettlementApiInterface.class);

        api.settlement(header, request, orderId)
                .enqueue(new Callback<FincodeSettlementResponse>() {
                    @Override
                    public void onResponse(Call<FincodeSettlementResponse> call, Response<FincodeSettlementResponse> response) {
                        if(response.isSuccessful()) {
                            fincodeCallback.onResponse(response.body());
                        } else {
                            fincodeCallback.onFailure(HttpUtil.getErrorInfo(response));
                        }
                    }

                    @Override
                    public void onFailure(Call<FincodeSettlementResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }
}
