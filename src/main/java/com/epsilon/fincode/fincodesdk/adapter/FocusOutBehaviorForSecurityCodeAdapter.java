package com.epsilon.fincode.fincodesdk.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import com.epsilon.fincode.fincodesdk.enumeration.PartsType;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/26.
 */
public class FocusOutBehaviorForSecurityCodeAdapter {

    @BindingAdapter(value={"viewModelForSecurityCode", "partsTypeForSecurityCode", "selectedBorderForSecurityCode"})
    public static void setFocusOutBehaviorForSecurityCode(EditText view, FincodeDataViewModel dataViewModel, PartsType partsType, Drawable drawable) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    // focus out
                    // do validate
                    partsType.doValidate(dataViewModel);
                } else {
                    // focus in
                    // set selected border
                    view.setBackground(drawable);
                }
            }
        });
    }

}
