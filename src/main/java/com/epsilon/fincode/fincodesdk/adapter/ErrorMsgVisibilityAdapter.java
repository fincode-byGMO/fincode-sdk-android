package com.epsilon.fincode.fincodesdk.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.databinding.BindingAdapter;
import com.epsilon.fincode.fincodesdk.enumeration.PartsType;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;
import com.epsilon.fincode.fincodesdk.viewmodel.partdata.FincodeBasePart;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class ErrorMsgVisibilityAdapter {

    @BindingAdapter(value={"errorVisibile", "viewModelPart", "noInputErrorMsg", "formatErrorMsg"})
    public static void setErrorVisibile(TextView view, boolean isError, FincodeBasePart basePart,
                                        String noInputErrorMsg, String formatErrorMsg) {
        if(isError) {
            view.setVisibility(View.VISIBLE);
            String msg = "".equals(basePart.getValue()) ? noInputErrorMsg : formatErrorMsg;
            view.setText(msg);
        } else {
            view.setVisibility(View.GONE);
            view.setText("");
        }
    }
}
