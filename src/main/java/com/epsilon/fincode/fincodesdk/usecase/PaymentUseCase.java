package com.epsilon.fincode.fincodesdk.usecase;

import com.epsilon.fincode.fincodesdk.Repository.FincodePaymentRepository;
import com.epsilon.fincode.fincodesdk.api.FincodeCallback;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentResponse;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeActionViewModel;

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
                fincodeCallback.onResponse(response);
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                hideProgress();
                fincodeCallback.onFailure(errorInfo);
            }
        });
    }

}
