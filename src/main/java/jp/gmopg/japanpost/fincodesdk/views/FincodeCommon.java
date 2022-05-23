package jp.gmopg.japanpost.fincodesdk.views;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import androidx.databinding.ViewDataBinding;
import jp.gmopg.japanpost.fincodesdk.config.OptionData;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
abstract class FincodeCommon extends ConstraintLayout {

    public OptionData optionData = OptionData.getInstance();

    public FincodeCommon(Context context, int layoutId) {
        super(context);

        inflate(context, layoutId, this);

        LayoutInflater inflater = LayoutInflater.from(context);
        initBinding(DataBindingUtil.inflate(inflater, layoutId, this, true),
                    FincodeViewModelHolder.getInstance());
    }

    abstract void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder);

}
