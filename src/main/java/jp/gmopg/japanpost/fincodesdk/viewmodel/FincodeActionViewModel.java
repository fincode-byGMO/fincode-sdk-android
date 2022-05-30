package jp.gmopg.japanpost.fincodesdk.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;
import jp.gmopg.japanpost.fincodesdk.enumeration.ButtonPressType;

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
                // TODO カード登録ボタン押下

                break;
            case CARD_RENEWAL:
                // TODO カード更新ボタン押下

                break;
        }

    }
}
