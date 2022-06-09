package jp.gmopg.japanpost.fincodesdk.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.entities.CardList;
import jp.gmopg.japanpost.fincodesdk.entities.CardListItem;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/06/06.
 */
public class CardSelectionListItemAdapter {

    private static List<String> cardNumberList;
    private static List<String> expirsList;
    private static List<Integer> imageList;
    private static CardList cardList;
    private static List<CardListItem> cardListItemArrayList;

    private static TextView cardNumberViewId;
    private static ImageView imageViewId;
    private static TextView expirViewId;

    @BindingAdapter(value={"viewModelForSpinnerList"})
    public static void setSpinnerSelect(Spinner spinner, FincodeDataViewModel dataViewModel) {

        cardNumberList = CardSelectionListAdapter.getCardNumber();
        expirsList = CardSelectionListAdapter.getExpir();

        spinner.setAdapter(CardSelectionListAdapter.getAdapter(spinner, cardNumberList, expirsList));

        CardListItem.Builder builder = new CardListItem.Builder();
        CardList.Builder cardListBuilder = new CardList.Builder();
        cardListItemArrayList = new ArrayList<>();

        for (int i=0; i < cardNumberList.size(); i++) {
            builder.setCardNumber(cardNumberList.get(i));
            builder.setExpire(expirsList.get(i));
            cardListBuilder.setCardLists(builder.build());
            cardListItemArrayList = cardListBuilder.build();
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String val = String.valueOf(cardListItemArrayList.get(position).getCardNumber());
                dataViewModel.selectCardNoPart.setValue(val);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });
    }

    @BindingAdapter(value={"cardNumberText"})
    public static void setCardNumberText(TextView textView, FincodeDataViewModel dataViewModel) {

        cardNumberViewId = textView;

        for (int i=0; i < cardListItemArrayList.size(); i++) {
            textView.setText(cardList.getCardLists().get(i).getCardNumber());
        }
    }

    @BindingAdapter(value={"cardImageView"})
    public static void setCardImageView(ImageView imageView, FincodeDataViewModel dataViewModel) {

        imageViewId = imageView;

        String cardNumber = dataViewModel.selectCardNoPart.getValue();

        for (int i=0; i < cardListItemArrayList.size(); i++) {
            imageView.setImageResource(getImage(i, cardListItemArrayList.get(i).getCardNumber()));
        }
    }

    @BindingAdapter(value={"expirText"})
    public static void setExpirText(TextView textView, FincodeDataViewModel dataViewModel) {

        expirViewId = textView;

        for (int i=0; i < cardListItemArrayList.size(); i++) {
            textView.setText(cardList.getCardLists().get(i).getExpire());
        }

    }

    private static int getImage(int i, String value) {
//        for (int i=0; i < cardInformationList.size(); i++){
        imageList.add(CardBrandType.type(value).getImage());
        return imageList.get(i);
//        }
//        return imageList.get(i);
    }
}
