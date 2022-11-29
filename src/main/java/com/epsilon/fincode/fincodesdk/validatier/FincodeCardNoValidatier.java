package com.epsilon.fincode.fincodesdk.validatier;

import com.epsilon.fincode.fincodesdk.enumeration.CardBrandType;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeCardNoValidatier {

    public static boolean validate(FincodeDataViewModel dataViewModel) {
        String str = dataViewModel.cardNoPart.getValue().replace(" ", "");
        CardBrandType type = CardBrandType.typeForNumber(str);

        if (str.isEmpty() || CardBrandType.cardNumberLength(str)
                || str.length() != type.digitsWithOutSpace()) {
            dataViewModel.cardNoPart.setIsError(true);
            return true;
        } else {
            dataViewModel.cardNoPart.setIsError(false);
            return false;
        }
    }
}
