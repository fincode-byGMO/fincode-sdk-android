package com.epsilon.fincode.fincodesdk.enumeration;

import com.epsilon.fincode.fincodesdk.util.StringUtil;
import com.epsilon.fincode.fincodesdk.validatier.FincodeCardNoValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeExpireMonthValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeExpireYearValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeHolderNameValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeSecurityCodeValidatier;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public enum PartsType {
    CARD_NUMBER,
    EXPIRE_MONTH,
    EXPIRE_YEAR,
    SECURITY_CODE,
    SUBMIT,
    HOLDER_NAME,
    PAY_TIMES,
    CARD_NUMBER_SELECT;

    public void doValidate(FincodeDataViewModel dataViewModel) {
        switch (this) {
            case CARD_NUMBER:
                FincodeCardNoValidatier.validate(dataViewModel);
                break;
            case EXPIRE_MONTH:
                FincodeExpireMonthValidatier.validate(dataViewModel);
                break;
            case EXPIRE_YEAR:
                FincodeExpireYearValidatier.validate(dataViewModel);
                break;
            case SECURITY_CODE:
                FincodeSecurityCodeValidatier.validate(dataViewModel);
                break;
            case HOLDER_NAME:
                FincodeHolderNameValidatier.validate(dataViewModel);
                break;
            case PAY_TIMES:
            case CARD_NUMBER_SELECT:
            case SUBMIT:
                // do nothing
                break;
        }
    }

    public void doZeroPrepend(FincodeDataViewModel dataViewModel) {
        String zeroPadding = "";
        if (this == PartsType.EXPIRE_MONTH) {
            zeroPadding = StringUtil.setZeroPrepend(dataViewModel.expireMonthPart.getValue());
            dataViewModel.expireMonthPart.setValue(zeroPadding);
        } else if (this == PartsType.EXPIRE_YEAR) {
            zeroPadding = StringUtil.setZeroPrepend(dataViewModel.expireYearPart.getValue());
            dataViewModel.expireYearPart.setValue(zeroPadding);
        }
    }
}
