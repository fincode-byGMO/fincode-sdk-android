package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSelectCardNoPart extends FincodeNotifyCallbacks {

    private String selectCardNo = "";

    @Bindable
    public String getSelectCardNo() {
        return this.selectCardNo;
    }

    public void setSelectCardNo(String value) {
        this.selectCardNo = value;
        notifyPropertyChanged(BR.selectCardNo);
    }
}
