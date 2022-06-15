package jp.gmopg.japanpost.fincodesdk.usecase;

import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.Repository.FincodeCardOperateRepository;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class CardOperateUseCase extends BaseUseCase {

    public void getCardInfoList(String customerId) {

        FincodeCardOperateRepository.getInstance().getCardInfoList(getHeader(), customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
            @Override
            public void onResponse(FincodeCardInfoListResponse response) {
                if(response == null && response.cardInfoList == null) { return; }
                FincodeViewModelHolder.getInstance().getDataViewModel().selectCardNoPart.setSelectCardNoList(response.cardInfoList);
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                // TODO 処理を実装する
            }
        });
    }
}
