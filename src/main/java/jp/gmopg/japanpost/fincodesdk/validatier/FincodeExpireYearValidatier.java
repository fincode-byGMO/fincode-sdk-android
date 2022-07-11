package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/25.
 */
public class FincodeExpireYearValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {
        if ("".equals(dataViewModel.expireYearPart.getValue())) {
            dataViewModel.expireYearPart.setIsError(true);
        } else {
            dataViewModel.expireYearPart.setIsError(false);
        }
    }
}
