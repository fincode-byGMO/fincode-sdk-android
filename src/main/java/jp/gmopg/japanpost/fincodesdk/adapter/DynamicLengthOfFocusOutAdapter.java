package jp.gmopg.japanpost.fincodesdk.adapter;

import android.view.View;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.util.EditTextUtil;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class DynamicLengthOfFocusOutAdapter {
    @BindingAdapter("dynamicLengthOfFocusOut")
    public static void setDynamicLengthOfFocusOut(EditText view, boolean value) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String str = getText(view);
                CardBrandType type = CardBrandType.type(str);
                if(!hasFocus) {
                    // focus out
                    EditTextUtil.setMaxLength(view, type.digitsWithSpace());
                    view.setText(type.delimit(str));
                } else {
                    // focus in
                    EditTextUtil.setMaxLength(view, type.digitsWithOutSpace());
                    view.setText(str.replace(" ", ""));
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
