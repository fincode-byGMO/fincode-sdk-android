package jp.gmopg.japanpost.fincodesdk.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.entities.CardInfoItem;
import jp.gmopg.japanpost.fincodesdk.entities.SelectCardNoItem;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

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
