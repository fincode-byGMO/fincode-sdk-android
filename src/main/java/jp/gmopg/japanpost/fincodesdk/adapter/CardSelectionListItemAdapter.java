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
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/06/06.
 */
public class CardSelectionListItemAdapter {

    @BindingAdapter(value={"viewModelForSpinnerList", "cardInfoList"})
    public static void setSpinnerSelect(Spinner spinner, FincodeDataViewModel dataViewModel,
                                        ArrayList<CardInfoItem> cardInfoItems) {

        spinner.setAdapter(CardSelectionListAdapter.getAdapter(spinner, cardInfoItems));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CardInfoItem selectCard = cardInfoItems.get(position);
                dataViewModel.selectCardNoPart.setValue(selectCard.getCardNumber());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });
    }

}
