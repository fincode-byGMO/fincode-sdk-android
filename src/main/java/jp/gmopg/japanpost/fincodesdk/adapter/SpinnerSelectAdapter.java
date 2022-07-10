package jp.gmopg.japanpost.fincodesdk.adapter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.enumeration.PartsType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/05/31.
 */
public class SpinnerSelectAdapter {

    @BindingAdapter(value={"viewModelForSpinner", "dataSourceForSpinner"})
    public static void setSpinnerSelect(Spinner spinner, FincodeDataViewModel dataViewModel, String[] list) {

        spinner.setAdapter(new SpinnerSelectListAdapter(spinner.getContext() , list));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = getSpinner(parent);
                if(spinner != null && spinner.getSelectedItem() instanceof String) {
                    String val = (String)spinner.getSelectedItem();
                    String withoutUnit = val.replace(spinner.getContext().getString(R.string.payment_times_unit), "");
                    dataViewModel.payTimesPart.setValue(withoutUnit);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });
    }

    private static Spinner getSpinner(AdapterView<?> parent) {
        if(parent instanceof Spinner) {
           return  (Spinner) parent;
        }
        return null;
    }
}
