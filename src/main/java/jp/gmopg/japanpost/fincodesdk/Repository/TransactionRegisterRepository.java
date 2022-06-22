package jp.gmopg.japanpost.fincodesdk.Repository;

import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.api.AsyncHttpClient;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.api.TransactionRegisterApiInterface;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterResponse;
import jp.gmopg.japanpost.fincodesdk.util.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m.ohkawa on 2022/06/21.
 */
public class TransactionRegisterRepository {

    private static TransactionRegisterRepository instance;

    private TransactionRegisterRepository() {
    }

    public static TransactionRegisterRepository getInstance() {
        if(instance == null) {
            instance = new TransactionRegisterRepository();
        }
        return instance;
    }

    public void transactionRegister(HashMap<String, String> header, TransactionRegisterRequest request, FincodeCallback<TransactionRegisterResponse> fincodeCallback) {
        TransactionRegisterApiInterface api = AsyncHttpClient.getInstance().getAsyncHttpClient(TransactionRegisterApiInterface.class);

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
