package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeExpireMonthValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {
        if ("".equals(dataViewModel.expireMonthPart.getValue())) {
            dataViewModel.expireMonthPart.setIsError(true);
        } else {
            if(dataViewModel.expireMonthPart.getValue().matches("(^[1-9]?$)|(^0[1-9]$)|(^1[0-2]$)")){
                dataViewModel.expireMonthPart.setIsError(false);
            } else {
                dataViewModel.expireMonthPart.setIsError(true);
            }
        }
    }
}
