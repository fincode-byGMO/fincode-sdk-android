package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;
import jp.gmopg.japanpost.fincodesdk.R;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodePayTimesPart extends FincodeBasePart {

    private boolean isOneTime;

    @Bindable
    public boolean getIsOneTime() {
        return this.isOneTime;
    }

    public void setIsOneTime(boolean value) {
        this.isOneTime = value;
        notifyPropertyChanged(BR.isOneTime);
    }
}
