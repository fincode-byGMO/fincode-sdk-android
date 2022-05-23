package jp.gmopg.japanpost.fincodesdk.views;

import android.content.Context;

import androidx.databinding.ViewDataBinding;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.FincodeVerticalViewBinding;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeVerticalView extends FincodeCommon {

    public FincodeVerticalView(Context context) {
        super(context, R.layout.fincode_vertical_view);
    }

    public void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder) {
        if(binding instanceof FincodeVerticalViewBinding) {
            FincodeVerticalViewBinding bind = (FincodeVerticalViewBinding) binding;
            bind.setDataViewModel(holder.getDataViewModel());
            bind.setActionViewModel(holder.getActionViewModel());
        }
    }
}
