package com.epsilon.fincode.fincodesdk.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;
import com.epsilon.fincode.fincodesdk.enumeration.PartsType;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/25.
 */
public class FocusOutBehaviorForExpireHorizontalAdapter {

    @BindingAdapter(value={"viewModelForExpireHorizontal", "partsTypeForExpireHorizontal", "selectedBorderForExpireHorizontal", "borderView"})
    public static void setFocusOutBehaviorForExpireHorizontal(EditText view, FincodeDataViewModel dataViewModel,
                                                              PartsType partsType, Drawable drawable, LinearLayout linearLayout) {
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
                    linearLayout.setBackground(drawable);
                }
            }
        });
    }
}
