package com.epsilon.fincode.fincodesdk.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

import androidx.databinding.BindingAdapter;
import com.epsilon.fincode.fincodesdk.R;
import com.epsilon.fincode.fincodesdk.entities.SelectCardNoItem;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/06/06.
 */
public class CardSelectionListItemAdapter {

    @BindingAdapter(value={"viewModelForSelectCardNo", "dataSource"})
    public static void setSpinnerSelect(Spinner spinner, FincodeDataViewModel viewModel, ArrayList<SelectCardNoItem> cardInfoList) {

        spinner.setAdapter(new CardSelectionListAdapter(spinner.getContext() , cardInfoList));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getAdapter() != null && parent.getAdapter() instanceof CardSelectionListAdapter) {
                    CardSelectionListAdapter adapter = (CardSelectionListAdapter) parent.getAdapter();
                    viewModel.selectCardNoPart.setValue(adapter.item(position).getCardId());
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });
    }
}
