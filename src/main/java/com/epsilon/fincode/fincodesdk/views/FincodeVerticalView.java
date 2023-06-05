package com.epsilon.fincode.fincodesdk.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import com.epsilon.fincode.fincodesdk.R;
import com.epsilon.fincode.fincodesdk.config.FincodeConfiguration;
import com.epsilon.fincode.fincodesdk.config.Options;
import com.epsilon.fincode.fincodesdk.databinding.FincodeVerticalViewBinding;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeVerticalView extends FincodeCommon {

    public FincodeVerticalView(@NonNull Context context) {
        this(context, null);
    }

    public FincodeVerticalView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, R.layout.fincode_vertical_view);
    }

    protected void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder) {
        if(binding instanceof FincodeVerticalViewBinding) {
            FincodeVerticalViewBinding bind = (FincodeVerticalViewBinding) binding;
            bind.setDataViewModel(holder.getDataViewModel());
            bind.setActionViewModel(holder.getActionViewModel());
            bind.setOptViewModel(holder.getOptViewModel());
        }
    }
}
