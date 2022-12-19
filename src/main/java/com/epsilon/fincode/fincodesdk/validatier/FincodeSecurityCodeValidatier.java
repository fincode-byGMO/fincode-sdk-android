package com.epsilon.fincode.fincodesdk.validatier;

import com.epsilon.fincode.fincodesdk.enumeration.CardBrandType;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSecurityCodeValidatier {

    public static boolean validate(FincodeDataViewModel dataViewModel) {
        if (!dataViewModel.securityCodePart.getValue().isEmpty() &&
                CardBrandType.securityCodeLength(dataViewModel.securityCodePart.getValue())) {
            dataViewModel.securityCodePart.setIsError(true);
            return true;
        } else {
            dataViewModel.securityCodePart.setIsError(false);
            return false;
        }
    }
}