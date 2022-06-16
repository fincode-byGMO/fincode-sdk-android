package jp.gmopg.japanpost.fincodesdk.Repository;

import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.api.AsyncHttpClient;
import jp.gmopg.japanpost.fincodesdk.api.CardOperateApiInterface;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.util.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by a.nakajima on 2022/06/15.
 */
public class FincodeCardOperateRepository<T> {

    private static FincodeCardOperateRepository instance;

    private FincodeCardOperateRepository() {
    }

    public static FincodeCardOperateRepository getInstance() {
        if(instance == null) {
            instance = new FincodeCardOperateRepository();
        }
        return instance;
    }

    public void getCardInfoList(HashMap<String, String> header, String customerId, FincodeCallback<FincodeCardInfoListResponse> fincodeCallback) {
        CardOperateApiInterface httpClient = AsyncHttpClient.getInstance().getAsyncHttpClient(CardOperateApiInterface.class);

        httpClient.cardInfoList(header, customerId)
                .enqueue(new Callback<FincodeCardInfoListResponse>() {
                    @Override
                    public void onResponse(Call<FincodeCardInfoListResponse> call, Response<FincodeCardInfoListResponse> response) {
                        if(response.isSuccessful()) {
                            fincodeCallback.onResponse(response.body());
                        } else {
                            fincodeCallback.onFailure(HttpUtil.getErrorInfo(response));
                        }
                    }

                    @Override
                    public void onFailure(Call<FincodeCardInfoListResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    // TODO カード登録APIの実装する

    // TODO カード更新APIの実装する
}
