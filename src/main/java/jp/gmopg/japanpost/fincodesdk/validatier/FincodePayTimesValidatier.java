package jp.gmopg.japanpost.fincodesdk.validatier;

import android.widget.Spinner;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/31.
 */
public class FincodePayTimesValidatier {

    public static void validate(FincodeDataViewModel dataViewModel) {
        if (dataViewModel.payTimesPart.getIsError()){
            dataViewModel.payTimesPart.setIsError(false);
        } else {
            dataViewModel.payTimesPart.setIsError(true);
        }
    }
}
