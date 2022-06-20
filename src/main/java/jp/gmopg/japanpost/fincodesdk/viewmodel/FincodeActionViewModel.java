package jp.gmopg.japanpost.fincodesdk.viewmodel;

import android.view.View;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoRequest;
import jp.gmopg.japanpost.fincodesdk.enumeration.ButtonPressType;
import jp.gmopg.japanpost.fincodesdk.usecase.CardOperateUseCase;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class FincodeActionViewModel {

    public void execute(View view) {

        // TODO お支払い・カード登録・カード更新のボタン タッチ時の処理を実装する
        switch (ButtonPressType.getButtonPressType()){
            case PAYMENT:
                // TODO お支払いボタン押下

                break;
            case CARD_REGISTER:
                FincodeCardInfoRequest cardInfoRequest = new FincodeCardInfoRequest();
                CardOperateUseCase useCase = new CardOperateUseCase();
                useCase.cardRegister("c_HSZkCAxNS2q_7TbLcO9y1A", cardInfoRequest);
                break;
            case CARD_RENEWAL:
                // TODO カード更新ボタン押下

                break;
        }

    }

}
