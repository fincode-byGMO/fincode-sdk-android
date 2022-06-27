package jp.gmopg.japanpost.fincodesdk.Repository;

import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.api.AsyncHttpClient;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.api.PaymentApiInterface;
import jp.gmopg.japanpost.fincodesdk.api.TransactionRegisterApiInterface;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterResponse;
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
                            fincodeCallback.onFailure(HttpUtil.getErrorInfo(response));
                        }
                    }

                    @Override
                    public void onFailure(Call<FincodePaymentResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }

    public void transactionRegister(HashMap<String, String> header, TransactionRegisterRequest request, FincodeCallback<TransactionRegisterResponse> fincodeCallback) {
        PaymentApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(PaymentApiInterface.class);

        api.transactionRegister(header, request)
                .enqueue(new Callback<TransactionRegisterResponse>() {
                    @Override
                    public void onResponse(Call<TransactionRegisterResponse> call, Response<TransactionRegisterResponse> response) {
                        if(response.isSuccessful()) {
                            fincodeCallback.onResponse(response.body());
                        } else {
                            fincodeCallback.onFailure(HttpUtil.getErrorInfo(response));
                        }
                    }

                    @Override
                    public void onFailure(Call<TransactionRegisterResponse> call, Throwable t) {
                        // do nothing
                    }
                });
    }
}
