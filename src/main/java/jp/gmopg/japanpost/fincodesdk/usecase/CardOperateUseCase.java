package jp.gmopg.japanpost.fincodesdk.usecase;

import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.Repository.FincodeCardOperateRepository;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeActionViewModel;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class CardOperateUseCase extends BaseUseCase {

    public void getCardInfoList(String customerId, FincodeCallback<FincodeCardInfoListResponse> fincodeCallback) {

        showProgress();

        FincodeCardOperateRepository.getInstance().getCardInfoList(getHeader(), customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
            @Override
            public void onResponse(FincodeCardInfoListResponse response) {
                fincodeCallback.onResponse(response);
                hideProgress();
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                fincodeCallback.onFailure(errorInfo);
                hideProgress();
            }
        });
    }

    public void cardRegister(String customerId, FincodeCardInfoRequest cardInfoRequest) {

        showProgress();

        FincodeCardOperateRepository.getInstance().cardRegister(getHeader(), customerId, cardInfoRequest, new FincodeCallback<FincodeCardInfo>() {
            @Override
            public void onResponse(FincodeCardInfo response) {
                FincodeViewModelHolder.getInstance().getDataViewModel().cardNoPart.setValue(response.getCardNo());
                hideProgress();
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                hideProgress();
            }
        });
    }

    public void cardUpdate(String customerId, String cardId, FincodeCardInfoRequest cardInfoRequest) {

        showProgress();

        FincodeCardOperateRepository.getInstance().cardUpdate(getHeader(), customerId, cardId, cardInfoRequest, new FincodeCallback<FincodeCardInfo>() {
            @Override
            public void onResponse(FincodeCardInfo response) {
                FincodeViewModelHolder.getInstance().getDataViewModel().cardNoPart.setValue(response.getCardNo());
                hideProgress();
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                hideProgress();
            }
        });
    }
}
