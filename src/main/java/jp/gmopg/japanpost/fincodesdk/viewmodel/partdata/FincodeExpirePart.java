package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeExpirePart extends FincodeNotifyCallbacks {

    private String expire = "";
    private boolean isExpireError = false;

    @Bindable
    public String getExpire() {
        return this.expire;
    }

    public void setExpire(String value) {
        this.expire = value;
        notifyPropertyChanged(BR.expire);
    }

    @Bindable
    public boolean getIsExpireError() {
        return this.isExpireError;
    }

    public void setIsExpireError(boolean value) {
        this.isExpireError = value;
        notifyPropertyChanged(BR.isExpireError);
    }
}
