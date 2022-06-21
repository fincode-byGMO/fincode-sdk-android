package jp.gmopg.japanpost.fincodesdk.usecase;

import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.Repository.FincodeCardOperateRepository;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class CardOperateUseCase extends BaseUseCase {

    public void getCardInfoList(String customerId, FincodeCallback<FincodeCardInfoListResponse> fincodeCallback) {

        FincodeCardOperateRepository.getInstance().getCardInfoList(getHeader(), customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
            @Override
            public void onResponse(FincodeCardInfoListResponse response) {
                fincodeCallback.onResponse(response);
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                fincodeCallback.onFailure(errorInfo);
            }
        });
    }

    public void cardRegister(String customerId, FincodeCardInfoRequest cardInfoRequest) {

        FincodeCardOperateRepository.getInstance().cardRegister(getHeader(), customerId, cardInfoRequest, new FincodeCallback<FincodeCardInfo>() {
            @Override
            public void onResponse(FincodeCardInfo response) {
                FincodeViewModelHolder.getInstance().getDataViewModel().cardNoPart.setValue(response.getCardNo());
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                // do nothing
            }
        });
    }

    public void cardUpdate(String customerId, String cardId, FincodeCardInfoRequest cardInfoRequest) {

        FincodeCardOperateRepository.getInstance().cardUpdate(getHeader(), customerId, cardId, cardInfoRequest, new FincodeCallback<FincodeCardInfo>() {
            @Override
            public void onResponse(FincodeCardInfo response) {
                FincodeViewModelHolder.getInstance().getDataViewModel().cardNoPart.setValue(response.getCardNo());
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                // do nothing
            }
        });
    }
}
