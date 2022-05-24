package jp.gmopg.japanpost.fincodesdk.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.util.EditTextUtil;

/**
 * Created by a.nakajima on 2022/05/23.
 */
public class TextChangedBehaviorForCardNoAdapter {

    // Model --> View
    @BindingAdapter("dynamicLength")
    public static void setTextChangedBehaviorForCardNo(EditText view, String oldValue, String newValue) {
        // do nothing
    }

    // View --> Model
    @InverseBindingAdapter(attribute = "dynamicLength")
    public static String getTextChangedBehaviorForCardNo(EditText view) {
        Editable editable = view.getText();
        if(editable != null) {
            CardBrandType type = CardBrandType.type(editable.toString());
            EditTextUtil.setMaxLength(view, type.digitsWithOutSpace());
        }
        return view.getText().toString();
    }

    // Set a change trigger
    @BindingAdapter("dynamicLengthAttrChanged")
    public static void setListeners(EditText view, final InverseBindingListener attrChange) {
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                attrChange.onChange();
            }

            @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // do nothing
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // do nothing
            }
        });
    }
}
