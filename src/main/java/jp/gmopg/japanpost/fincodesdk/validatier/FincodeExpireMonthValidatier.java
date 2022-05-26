package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeExpireMonthValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {

        if (dataViewModel.expirePart.getExpireMonth().equals("")) {
            dataViewModel.expirePart.setIsExpireMonthError(true);
            dataViewModel.expirePart.setIsExpireMonthFormatError(false);
        } else {
            if(dataViewModel.expirePart.getExpireMonth().matches("(^[1-9]?$)|(^0[1-9]$)|(^1[0-2]$)")){// 0or00
                dataViewModel.expirePart.setIsExpireMonthError(false);
                dataViewModel.expirePart.setIsExpireMonthFormatError(false);
            } else {
                dataViewModel.expirePart.setIsExpireMonthError(false);
                dataViewModel.expirePart.setIsExpireMonthFormatError(true);
            }
        }
    }
}
