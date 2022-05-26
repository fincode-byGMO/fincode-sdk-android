package jp.gmopg.japanpost.fincodesdk.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.enumeration.PartsType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/25.
 */
public class FocusOutBehaviorForExpireHorizontalAdapter {

    @BindingAdapter(value={"viewModelForExpireHorizontal", "partsTypeForExpireHorizontal", "selectedBorderForExpireHorizontal"})
    public static void setFocusOutBehaviorForExpireHorizontal(LinearLayout view, FincodeDataViewModel dataViewModel, PartsType partsType, Drawable drawable) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // focus out
                    // do validate
                    partsType.doValidate(dataViewModel);
                    partsType.doZeroPrepend(dataViewModel);
                } else {
                    // focus in
                    // set selected border
                    view.setBackground(drawable);
                }
            }
        });
    }
}
