package jp.gmopg.japanpost.fincodesdk.viewmodel;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeCardNoPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeExpireMonthPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeExpireYearPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeHolderNamePart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeNotifyCallbacks;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodePayTimesPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeSecurityCodePart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeSelectCardNoPart;


/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeDataViewModel extends FincodeNotifyCallbacks {

    public boolean radioSelect = false;
    // TODO 動作確認用に仮実装 初期値はブランクにする
    public String customerID = "4649";
    public boolean isProgressBar = true;

    public FincodeDataViewModel() { }

    public FincodeCardNoPart cardNoPart = new FincodeCardNoPart();
    public FincodeExpireMonthPart expireMonthPart = new FincodeExpireMonthPart();
    public FincodeExpireYearPart expireYearPart = new FincodeExpireYearPart();
    public FincodeHolderNamePart holderNamePart = new FincodeHolderNamePart();
    public FincodePayTimesPart payTimesPart = new FincodePayTimesPart();
    public FincodeSecurityCodePart securityCodePart = new FincodeSecurityCodePart();
    public FincodeSelectCardNoPart selectCardNoPart = new FincodeSelectCardNoPart();

    @Bindable
    public boolean getRadioSelect() {
        return this.radioSelect;
    }

    public void setRadioSelect(boolean radioSelect) {
        this.radioSelect = radioSelect;
        notifyPropertyChanged(BR.radioSelect);
    }

    @Bindable
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Bindable
    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    @Bindable
    public boolean getIsProgressBar() {
        return isProgressBar;
    }

    public void setIsProgressBar(boolean isProgressBar) {
        this.isProgressBar = isProgressBar;
        notifyPropertyChanged(BR.isProgressBar);
    }
}
