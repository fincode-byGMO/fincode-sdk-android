package jp.gmopg.japanpost.fincodesdk.validatier;

import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeCardNoValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {
        String str = dataViewModel.cardNoPart.getValue();
        CardBrandType type = CardBrandType.typeForNumber(str);

        if ("".equals(str) || CardBrandType.cardNumberLength(str)
                || str.length() != type.digitsWithOutSpace()) {
            dataViewModel.cardNoPart.setIsError(true);
        } else {
            dataViewModel.cardNoPart.setIsError(false);
        }
    }
}
