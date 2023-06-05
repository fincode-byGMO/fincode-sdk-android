package com.epsilon.fincode.fincodesdk.usecase;

import com.epsilon.fincode.fincodesdk.api.FincodeCallback;
import com.epsilon.fincode.fincodesdk.Repository.FincodeCardOperateRepository;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardInfo;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardInfoListResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardRegisterRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardRegisterResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardUpdateRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardUpdateResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class CardOperateUseCase extends BaseUseCase {

    public void getCardInfoList(String customerId, FincodeCallback<FincodeCardInfoListResponse> fincodeCallback) {
        showProgress();
        FincodeCardOperateRepository.getInstance().getCardInfoList(getHeader(), customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
            @Override
            public void onResponse(FincodeCardInfoListResponse response) {
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

    public void cardRegister(String customerId, FincodeCardRegisterRequest request, FincodeCallback<FincodeCardRegisterResponse> fincodeCallback) {
        showProgress();
        FincodeCardOperateRepository.getInstance().cardRegister(getHeader(), customerId, request, new FincodeCallback<FincodeCardRegisterResponse>() {
            @Override
            public void onResponse(FincodeCardRegisterResponse response) {
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

    public void cardUpdate(String customerId, String cardId, FincodeCardUpdateRequest request, FincodeCallback<FincodeCardUpdateResponse> fincodeCallback) {
        showProgress();
        FincodeCardOperateRepository.getInstance().cardUpdate(getHeader(), customerId, cardId, request, new FincodeCallback<FincodeCardUpdateResponse>() {
            @Override
            public void onResponse(FincodeCardUpdateResponse response) {
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
