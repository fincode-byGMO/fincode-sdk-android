package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodePayTimesPart extends FincodeNotifyCallbacks {

    private String payTimes = "";

    @Bindable
    public String getPayTimes() {
        return this.payTimes;
    }

    public void setPayTimes(String value) {
        this.payTimes = value;
        notifyPropertyChanged(BR.payTimes);
    }
}
