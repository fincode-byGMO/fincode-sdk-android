package jp.gmopg.japanpost.fincodesdk.adapter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.enumeration.PartsType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/31.
 */
public class FocusOutBehaviorForPayTimesAdapter {

    @BindingAdapter(value={"viewModelForPayTimes", "partsTypeForPayTimes"})
    public static void setFocusOutBehaviorForPayTimes(RadioGroup radioGroup, FincodeDataViewModel dataViewModel, PartsType partsType) {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                partsType.doValidate(dataViewModel);
            }
        });
    }
}
