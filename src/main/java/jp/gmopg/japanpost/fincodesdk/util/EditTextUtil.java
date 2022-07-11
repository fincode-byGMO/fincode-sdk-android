package jp.gmopg.japanpost.fincodesdk.util;

import android.text.InputFilter;
import android.widget.EditText;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class EditTextUtil {

    public static void setMaxLength(EditText view, int maxLength) {
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(maxLength);
        view.setFilters(filters);
    }
}
