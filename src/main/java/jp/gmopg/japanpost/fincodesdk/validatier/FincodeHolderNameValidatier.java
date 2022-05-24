package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeHolderNameValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {

        // TODO 入力チェックをする。入力チェックでエラーの場合は、Errorフラグをtrueにする
        dataViewModel.holderNamePart.setIsHolderNameError(true);
    }
}