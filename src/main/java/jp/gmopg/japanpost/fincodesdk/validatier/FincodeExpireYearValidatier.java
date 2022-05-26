package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/25.
 */
public class FincodeExpireYearValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {

        if (dataViewModel.expirePart.getExpireYear().equals("")) {
            dataViewModel.expirePart.setIsExpireYearError(true);
        } else {
            dataViewModel.expirePart.setIsExpireYearError(false);
        }

    }

}
