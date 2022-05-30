package jp.gmopg.japanpost.fincodesdk.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.enumeration.PartsType;
import jp.gmopg.japanpost.fincodesdk.util.EditTextUtil;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FocusOutBehaviorForCardNoAdapter {

    @BindingAdapter(value={"viewModelForCardNo", "partsTypeForCardNo", "selectedBorderForCardNo"})
    public static void setFocusOutBehaviorForCardNo(EditText view, FincodeDataViewModel dataViewModel, PartsType partsType, Drawable drawable) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String str = getText(view);
                CardBrandType type = CardBrandType.type(str);
                if(!hasFocus) {
                    // focus out
                    // set max length
                    EditTextUtil.setMaxLength(view, type.digitsWithSpace());
                    // do validate
                    partsType.doValidate(dataViewModel);
                    view.setText(type.delimit(str));
                } else {
                    // focus in
                    EditTextUtil.setMaxLength(view, type.digitsWithOutSpace());
                    view.setText(str.replace(" ", ""));
                    // set selected border
                    view.setBackground(drawable);
                }
            }
        });
    }

    private static String getText(EditText view) {
        if(view.getText() != null) {
            return view.getText().toString();
        }
        return "";
    }
}
