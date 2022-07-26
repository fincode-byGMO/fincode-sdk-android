package com.epsilon.fincode.fincodesdk.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public FincodeVerticalView(Activity context, ViewGroup replace) {
        this(context, null, replace);
    }

    public FincodeVerticalView(Activity context, Options options, ViewGroup replace) {
        super(context, R.layout.fincode_vertical_view, replace, options,true);
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
