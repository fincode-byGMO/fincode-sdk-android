package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSecurityCodePart extends FincodeNotifyCallbacks {

    private String securityCode = "";
    private boolean isSecurityCodeError = false;

    @Bindable
    public String getSecurityCode() {
        return this.securityCode;
    }

    public void setSecurityCode(String value) {
        this.securityCode = value;
        notifyPropertyChanged(BR.securityCode);
    }

    @Bindable
    public boolean getIsSecurityCodeError() {
        return this.isSecurityCodeError;
    }

    public void setIsSecurityCodeError(boolean value) {
        this.isSecurityCodeError = value;
        notifyPropertyChanged(BR.isSecurityCodeError);
    }
}
