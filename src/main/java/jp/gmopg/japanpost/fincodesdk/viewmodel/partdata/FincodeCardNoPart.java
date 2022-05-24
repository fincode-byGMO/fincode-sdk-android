package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeNotifyCallbacks;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeCardNoPart extends FincodeNotifyCallbacks {

    private String cardNo = "";
    private boolean isCardNoError = false;

    @Bindable
    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String value) {
        this.cardNo = value;
        notifyPropertyChanged(BR.cardNo);
    }

    @Bindable
    public boolean getIsCardNoError() {
        return this.isCardNoError;
    }

    public void setIsCardNoError(boolean value) {
        this.isCardNoError = value;
        notifyPropertyChanged(BR.isCardNoError);
    }
}
