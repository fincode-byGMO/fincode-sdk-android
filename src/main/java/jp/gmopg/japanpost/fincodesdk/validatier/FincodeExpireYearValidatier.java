package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.enumeration.SubmitButtonType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/25.
 */
public class FincodeExpireYearValidatier {

    public static boolean validate(FincodeDataViewModel dataViewModel) {
        if (dataViewModel.expireYearPart.getValue().isEmpty() && dataViewModel.getButtonType() != SubmitButtonType.CARD_UPDATE) {
            dataViewModel.expireYearPart.setIsError(true);
            return true;
        } else {
            dataViewModel.expireYearPart.setIsError(false);
            return false;
        }
    }
}
