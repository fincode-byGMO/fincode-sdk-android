package jp.gmopg.japanpost.fincodesdk.viewmodel;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeDataViewModel extends FincodeNotifyCallbacks {

    public FincodeDataViewModel() {
    }

    private String cardNumber = "";

    @Bindable
    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String value) {
        this.cardNumber = value;
        notifyPropertyChanged(BR.cardNumber);
    }

}
