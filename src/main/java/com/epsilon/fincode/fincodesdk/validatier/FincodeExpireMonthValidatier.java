package com.epsilon.fincode.fincodesdk.validatier;

import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeExpireMonthValidatier {

    public static boolean validate(FincodeDataViewModel dataViewModel) {

        if (dataViewModel.expireMonthPart.getValue().isEmpty() &&
                dataViewModel.getButtonType() != SubmitButtonType.CARD_UPDATE) {
            dataViewModel.expireMonthPart.setIsError(true);
            return true;
        } else {
            if(dataViewModel.expireMonthPart.getValue().matches("(^[1-9]?$)|(^0[1-9]$)|(^1[0-2]$)")){
                dataViewModel.expireMonthPart.setIsError(false);
                return false;
            } else {
                dataViewModel.expireMonthPart.setIsError(true);
                return true;
            }
        }
    }
}
