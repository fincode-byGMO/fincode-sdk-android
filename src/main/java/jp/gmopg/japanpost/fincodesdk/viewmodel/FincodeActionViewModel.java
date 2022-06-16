package jp.gmopg.japanpost.fincodesdk.viewmodel;

import android.view.View;

import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.enumeration.ButtonPressType;
import jp.gmopg.japanpost.fincodesdk.usecase.CardOperateUseCase;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class FincodeActionViewModel {

    public void execute(View view) {

        // TODO API実行ロジックの動作確認用
        cardInfoList();

        // TODO お支払い・カード登録・カード更新のボタン タッチ時の処理を実装する
        switch (ButtonPressType.getButtonPressType()){
            case PAYMENT:
                // TODO お支払いボタン押下

                break;
            case CARD_REGISTER:
                // TODO カード登録ボタン押下

                break;
            case CARD_RENEWAL:
                // TODO カード更新ボタン押下

                break;
        }

    }

    // TODO 動作確認後に削除する
    private void cardInfoList() {
        CardOperateUseCase useCase = new CardOperateUseCase();
        useCase.getCardInfoList("c_HSZkCAxNS2q_7TbLcO9y1A", new FincodeCallback<FincodeCardInfoListResponse>() {
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
