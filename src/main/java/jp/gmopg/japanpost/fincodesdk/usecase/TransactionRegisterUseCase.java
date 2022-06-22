package jp.gmopg.japanpost.fincodesdk.usecase;

import jp.gmopg.japanpost.fincodesdk.Repository.TransactionRegisterRepository;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.TransactionRegisterResponse;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by m.ohkawa on 2022/06/22.
 */
public class TransactionRegisterUseCase extends BaseUseCase {

    public void transactionRegister(TransactionRegisterRequest request) {

        TransactionRegisterRepository.getInstance().transactionRegister(getHeader(), request, new FincodeCallback<TransactionRegisterResponse>() {
            @Override
            public void onResponse(TransactionRegisterResponse response) {
                FincodeViewModelHolder.getInstance().getDataViewModel().customerID = response.getCustomerId();
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                // do nothing
            }
        });
    }
}
