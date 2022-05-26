package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeExpirePart extends FincodeNotifyCallbacks {

    private String expireMonth = "";
    private String expireYear = "";
    private boolean isExpireMonthError = false;
    private boolean isExpireYearError = false;
    private boolean isExpireMonthFormatError = false;

    @Bindable
    public String getExpireMonth() {
        return this.expireMonth;
    }

    public void setExpireMonth(String value) {
        this.expireMonth = value;
        notifyPropertyChanged(BR.expireMonth);
    }

    @Bindable
    public boolean getIsExpireMonthError() {
        return this.isExpireMonthError;
    }

    public void setIsExpireMonthError(boolean value) {
        this.isExpireMonthError = value;
        notifyPropertyChanged(BR.isExpireMonthError);
    }

    @Bindable
    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
        notifyPropertyChanged(BR.expireYear);
    }

    @Bindable
    public boolean getIsExpireYearError() {
        return isExpireYearError;
    }

    public void setIsExpireYearError(boolean expireYearError) {
        isExpireYearError = expireYearError;
        notifyPropertyChanged(BR.isExpireYearError);
    }

    @Bindable
    public boolean getIsExpireMonthFormatError() {
        return isExpireMonthFormatError;
    }

    public void setIsExpireMonthFormatError(boolean expireMonthFormatError) {
        isExpireMonthFormatError = expireMonthFormatError;
        notifyPropertyChanged(BR.isExpireMonthFormatError);
    }
}
