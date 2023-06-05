package com.epsilon.fincode.fincodesdk.validatier;

import com.epsilon.fincode.fincodesdk.enumeration.CardBrandType;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by fincode on 2022/05/24.
 */
public class FincodeHolderNameValidatier {

    public static boolean validate(FincodeDataViewModel dataViewModel) {
        if (!dataViewModel.holderNamePart.getValue().isEmpty() &&
                !dataViewModel.holderNamePart.getValue().matches("^[a-zA-Z0-9 ¥¥x2c-¥¥x2f]{0,50}$")) {
            dataViewModel.holderNamePart.setIsError(true);
            return true;
        } else {
            dataViewModel.holderNamePart.setIsError(false);
            return false;
        }
    }
}