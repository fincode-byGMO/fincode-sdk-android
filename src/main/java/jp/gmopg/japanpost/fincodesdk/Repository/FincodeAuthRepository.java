package jp.gmopg.japanpost.fincodesdk.Repository;

import java.io.IOException;
import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.api.AsyncHttpClient;
import jp.gmopg.japanpost.fincodesdk.api.AuthenticationApiInterface;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeAuthRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeAuthResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeGetResultResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentSecureRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentSecureResponse;
import jp.gmopg.japanpost.fincodesdk.util.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m.sakaida on 2022/10/28.
 */
public class FincodeAuthRepository {

    private static FincodeAuthRepository instance;

    private FincodeAuthRepository() {
    }

    public static FincodeAuthRepository getInstance() {
        if(instance == null) {
            instance = new FincodeAuthRepository();
        }
        return instance;
    }

    public void authentication(HashMap<String, String> header, String id, FincodeAuthRequest request, FincodeCallback<FincodeAuthResponse> fincodeCallback) {
        AuthenticationApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(AuthenticationApiInterface.class);

        api.authentication(header, request, id)
                .enqueue(new Callback<FincodeAuthResponse>() {
                    @Override
                    public void onResponse(Call<FincodeAuthResponse> call, Response<FincodeAuthResponse> response) {
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
                    public void onFailure(Call<FincodeAuthResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void getResult(HashMap<String, String> header, String id, FincodeCallback<FincodeGetResultResponse> fincodeCallback) {
        AuthenticationApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(AuthenticationApiInterface.class);

        api.getResult(header, id)
                .enqueue(new Callback<FincodeGetResultResponse>() {
                    @Override
                    public void onResponse(Call<FincodeGetResultResponse> call, Response<FincodeGetResultResponse> response) {
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
                    public void onFailure(Call<FincodeGetResultResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

}