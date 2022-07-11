package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by fincode on 2022/05/24.
 */
public class FincodeHolderNameValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {
        if (!dataViewModel.holderNamePart.getValue().isEmpty() &&
                !dataViewModel.holderNamePart.getValue().matches("^[a-zA-Z0-9 ¥¥x2c-¥¥x2f]{0,50}$")) {
            dataViewModel.holderNamePart.setIsError(true);
        } else {
            dataViewModel.holderNamePart.setIsError(false);
        }
    }
}