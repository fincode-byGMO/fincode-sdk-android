package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeHolderNamePart extends FincodeNotifyCallbacks {

    private String holderName = "";
    private boolean isHolderNameError = false;

    @Bindable
    public String getHolderName() {
        return this.holderName;
    }

    public void setHolderName(String value) {
        this.holderName = value;
        notifyPropertyChanged(BR.holderName);
    }

    @Bindable
    public boolean getIsHolderNameError() {
        return this.isHolderNameError;
    }

    public void setIsHolderNameError(boolean value) {
        this.isHolderNameError = value;
        notifyPropertyChanged(BR.isHolderNameError);
    }
}
