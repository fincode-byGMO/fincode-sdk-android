package jp.gmopg.japanpost.fincodesdk.Repository;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.api.AsyncHttpClient;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.api.PaymentApiInterface;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorInfoList;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentResponse;
import jp.gmopg.japanpost.fincodesdk.util.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public class FincodePaymentRepository {

    private static FincodePaymentRepository instance;

    private FincodePaymentRepository() {
    }

    public static FincodePaymentRepository getInstance() {
        if(instance == null) {
            instance = new FincodePaymentRepository();
        }
        return instance;
    }

    public void payment(HashMap<String, String> header, String orderId, FincodePaymentRequest request, FincodeCallback<FincodePaymentResponse> fincodeCallback) {
        PaymentApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(PaymentApiInterface.class);

        api.payment(header, request, orderId)
                .enqueue(new Callback<FincodePaymentResponse>() {
                    @Override
                    public void onResponse(Call<FincodePaymentResponse> call, Response<FincodePaymentResponse> response) {
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
                    public void onFailure(Call<FincodePaymentResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

}
