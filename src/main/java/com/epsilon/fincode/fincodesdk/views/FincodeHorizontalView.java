package com.epsilon.fincode.fincodesdk.views;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;
import com.epsilon.fincode.fincodesdk.R;
import com.epsilon.fincode.fincodesdk.config.FincodeConfiguration;
import com.epsilon.fincode.fincodesdk.config.Options;
import com.epsilon.fincode.fincodesdk.databinding.FincodeHorizontalViewBinding;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeHorizontalView extends FincodeCommon {

    public FincodeHorizontalView(Activity context, ViewGroup replace) {
        this(context, null, replace);
    }

    public FincodeHorizontalView(Activity context, Options options, ViewGroup replace) {
        super(context, R.layout.fincode_horizontal_view, replace, options, false);
    }

    protected void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder) {
        if(binding instanceof FincodeHorizontalViewBinding) {
            FincodeHorizontalViewBinding bind = (FincodeHorizontalViewBinding) binding;
            bind.setDataViewModel(holder.getDataViewModel());
            bind.setActionViewModel(holder.getActionViewModel());
            bind.setOptViewModel(holder.getOptViewModel());
        }
    }
}
