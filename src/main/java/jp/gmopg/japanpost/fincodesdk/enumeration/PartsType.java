package jp.gmopg.japanpost.fincodesdk.enumeration;

import jp.gmopg.japanpost.fincodesdk.validatier.FincodeCardNoValidatier;
import jp.gmopg.japanpost.fincodesdk.validatier.FincodeExpireValidatier;
import jp.gmopg.japanpost.fincodesdk.validatier.FincodeHolderNameValidatier;
import jp.gmopg.japanpost.fincodesdk.validatier.FincodeSecurityCodeValidatier;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public enum PartsType {
    CARD_NUMBER,
    EXPIRE,
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
            case EXPIRE:
                FincodeExpireValidatier.validate(dataViewModel);
                break;
            case SECURITY_CODE:
                FincodeSecurityCodeValidatier.validate(dataViewModel);
                break;
            case HOLDER_NAME:
                FincodeHolderNameValidatier.validate(dataViewModel);
                break;
            case CARD_NUMBER_SELECT:
            case SUBMIT:
            case PAY_TIMES:
                // do nothing
                break;
        }
    }
}
