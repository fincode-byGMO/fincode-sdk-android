package jp.gmopg.japanpost.fincodesdk.views;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.config.FincodeConfiguration;
import jp.gmopg.japanpost.fincodesdk.config.Options;
import jp.gmopg.japanpost.fincodesdk.databinding.FincodeHorizontalViewBinding;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeHorizontalView extends FincodeCommon {

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
