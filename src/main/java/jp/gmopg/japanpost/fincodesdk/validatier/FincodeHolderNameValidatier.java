package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeHolderNameValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {

        // TODO 入力チェックをする。入力チェックでエラーの場合は、Errorフラグをtrueにする
        if (dataViewModel.holderNamePart.getHolderName().equals("")
                || !dataViewModel.holderNamePart.getHolderName().matches("^[a-zA-Z0-9 ¥¥x2c-¥¥x2f]{0,50}$")) {
            dataViewModel.holderNamePart.setIsHolderNameError(true);
        } else {
            dataViewModel.holderNamePart.setIsHolderNameError(false);
        }
    }
}