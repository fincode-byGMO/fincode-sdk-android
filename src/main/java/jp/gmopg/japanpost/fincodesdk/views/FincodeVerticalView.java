package jp.gmopg.japanpost.fincodesdk.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.config.FincodeConfiguration;
import jp.gmopg.japanpost.fincodesdk.config.Options;
import jp.gmopg.japanpost.fincodesdk.databinding.FincodeVerticalViewBinding;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeVerticalView extends FincodeCommon {

//    public FincodeVerticalView(Activity context) {
//        super(context, R.layout.fincode_vertical_view);
//    }

    public FincodeVerticalView(Activity context, ViewGroup replace) {
        super(context, R.layout.fincode_vertical_view, replace);
    }

    public void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder) {
        if(binding instanceof FincodeVerticalViewBinding) {
            FincodeVerticalViewBinding bind = (FincodeVerticalViewBinding) binding;
            bind.setDataViewModel(holder.getDataViewModel());
            bind.setActionViewModel(holder.getActionViewModel());
        }
    }
}
