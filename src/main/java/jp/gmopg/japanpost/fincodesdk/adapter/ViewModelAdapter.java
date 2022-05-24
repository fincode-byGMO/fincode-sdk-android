package jp.gmopg.japanpost.fincodesdk.adapter;

import android.view.View;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.enumeration.PartsType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class ViewModelAdapter {

    @BindingAdapter(value={"viewModel", "partsType"})
    public static void setViewModel(EditText view, FincodeDataViewModel dataViewModel, PartsType partsType) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String str = getText(view);
                if(!hasFocus) {
                    // focus out
                    partsType.doValidate(dataViewModel);
                } else {
                    // focus in
                    // do nothing
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
