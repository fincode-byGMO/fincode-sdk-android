package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSecurityCodeValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {
        if (!dataViewModel.securityCodePart.getValue().isEmpty() &&
                CardBrandType.securityCodeLength(dataViewModel.securityCodePart.getValue())) {
            dataViewModel.securityCodePart.setIsError(true);
        } else {
            dataViewModel.securityCodePart.setIsError(false);
        }
    }
}