package jp.gmopg.japanpost.fincodesdk.usecase;

import jp.gmopg.japanpost.fincodesdk.Repository.FincodePaymentRepository;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentResponse;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeActionViewModel;

/**
 * Created by m.ohkawa on 2022/06/23.
 */
public class PaymentUseCase extends BaseUseCase {

    public void payment(String orderId, FincodePaymentRequest request, FincodeCallback<FincodePaymentResponse> fincodeCallback) {
        showProgress();
        FincodePaymentRepository.getInstance().payment(getHeader(), orderId, request, new FincodeCallback<FincodePaymentResponse>() {
            @Override
            public void onResponse(FincodePaymentResponse response) {
                hideProgress();
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                hideProgress();
            }
        });
    }

}
