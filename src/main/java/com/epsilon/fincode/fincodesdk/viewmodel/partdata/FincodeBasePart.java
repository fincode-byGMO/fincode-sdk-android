package com.epsilon.fincode.fincodesdk.viewmodel.partdata;

import android.view.View;

import androidx.databinding.Bindable;
import com.epsilon.fincode.fincodesdk.BR;

/**
 * Created by a.nakajima on 2022/05/26.
 */
public class FincodeBasePart extends FincodeNotifyCallbacks {

    private String value = "";
    private boolean isError = false;

    @Bindable
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    @Bindable
    public boolean getIsError() {
        return this.isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
        notifyPropertyChanged(BR.isError);
    }
}
