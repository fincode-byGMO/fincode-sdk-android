package jp.gmopg.japanpost.fincodesdk.Repository;

import java.io.IOException;
import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.api.AsyncHttpClient;
import jp.gmopg.japanpost.fincodesdk.api.CardOperateApiInterface;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardRegisterRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardRegisterResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardUpdateRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardUpdateResponse;
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
                            try {
                                String value = response.errorBody().string();
                                fincodeCallback.onFailure(HttpUtil.getErrorInfo(response, value));
                            } catch (IOException e) {
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<FincodeCardInfoListResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void cardRegister(HashMap<String, String> header, String customerId, FincodeCardRegisterRequest cardInfoRequest, FincodeCallback<FincodeCardRegisterResponse> fincodeCallback) {
        CardOperateApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(CardOperateApiInterface.class);

        api.cardRegister(header, cardInfoRequest, customerId)
                .enqueue(new Callback<FincodeCardRegisterResponse>() {
                    @Override
                    public void onResponse(Call<FincodeCardRegisterResponse> call, Response<FincodeCardRegisterResponse> response) {
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
                    public void onFailure(Call<FincodeCardRegisterResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void cardUpdate(HashMap<String, String> header, String customerId, String cardId, FincodeCardUpdateRequest cardInfoRequest, FincodeCallback<FincodeCardUpdateResponse> fincodeCallback) {
        CardOperateApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(CardOperateApiInterface.class);

        api.cardUpdate(header, cardInfoRequest, customerId, cardId)
                .enqueue(new Callback<FincodeCardUpdateResponse>() {
                    @Override
                    public void onResponse(Call<FincodeCardUpdateResponse> call, Response<FincodeCardUpdateResponse> response) {
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
                    public void onFailure(Call<FincodeCardUpdateResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }
}
