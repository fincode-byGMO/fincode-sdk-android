package jp.gmopg.japanpost.fincodesdk.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BindingAdapter;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeDataViewModel;

/**
 * Created by m.ohkawa on 2022/06/03.
 */
public class CardSelectionListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private int layoutID;
    private TextView cardNumberID;
    private ImageView imageID;
    private TextView expirID;

    private static List<String> cardNumbers;
    private static List<Integer> imageIDs;
    private static List<String> expirs;
    private static List<String> cardInformationList;
    private static List<Integer> imageList;
    private static List<String> expirsList;

    static class ViewHolder {
        ImageView imageView;
        TextView cardNumberView;
        TextView expirView;
    }

    CardSelectionListAdapter(Context context,
                             int itemLayoutId,
                             List<String> cardNumbersItems,
                             List<String> expirsItems){
//        getCardNumber();
//        getExpir();

        inflater = LayoutInflater.from(context);
        layoutID = itemLayoutId;
//        cardNumbers = cardNumbersItems;
//        imageIDs = imageList;
        expirs = expirsItems;

        cardNumbers = cardNumbersItems;
//        cardNumberID = cardNumberId;
//        imageID = imageViewId;
//        expirID = expirViewId;

    }

    CardSelectionListAdapter(ImageView imageViewId){
//        getCardNumber();
//        getExpir();

//        inflater = LayoutInflater.from(context);
//        cardNumbers = cardNumbersItems;
//        imageIDs = imageList;
        imageID = imageViewId;
//        expirID = expirViewId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(layoutID, null);
            holder = new ViewHolder();

//            holder.imageView = imageID;
//            holder.cardNumberView = cardNumberID;
//            holder.expirView = expirID;
            holder.imageView = convertView.findViewById(R.id.image_view);
            holder.cardNumberView = convertView.findViewById(R.id.textView);
            holder.expirView = convertView.findViewById(R.id.expir_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        holder.imageView.setImageResource(imageIDs.get(position));
        holder.cardNumberView.setText(cardNumbers.get(position));
        holder.expirView.setText(expirs.get(position));

        return convertView;
    }

    @Override
    public int getCount() {
        return cardNumbers.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @BindingAdapter(value={"cardNumberText"})
//    public static void setCardNumberText(TextView textView, FincodeDataViewModel dataViewModel) {
//
//        cardNumberViewId = textView;
//
//        for (int i=0; i < cardInformationList.size(); i++) {
//            textView.setText(cardList.getCardLists().get(i).getCardNumber());
//        }
//    }

    @BindingAdapter(value={"cardImageView"})
    public static void setCardImageView(ImageView imageView, FincodeDataViewModel dataViewModel) {

        CardSelectionListAdapter.getAdapter(imageView);

        for (int i=0; i < cardInformationList.size(); i++) {
            imageView.setImageResource(getImage(i));
        }
    }

//    @BindingAdapter(value={"expirText"})
//    public static void setExpirText(TextView textView, FincodeDataViewModel dataViewModel) {
//
//        expirViewId = textView;
//
//        for (int i=0; i < cardInformationList.size(); i++) {
//            textView.setText(cardList.getCardLists().get(i).getExpire());
//        }
//
//    }

//    @BindingAdapter(value={"viewModelForSpinnerList"})
//    public static void setSpinnerSelect(Spinner spinner, FincodeDataViewModel dataViewModel) {
//
//        spinner.setAdapter(getAdapter(spinner));
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String val = String.valueOf(cardNumbers.get(position));
//                dataViewModel.payTimesPart.setValue(val);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//                // do nothing
//            }
//        });
//    }

    public static CardSelectionListAdapter getAdapter(Spinner spinner, List<String> cardNumberList,
                                                      List<String> expirsList){
        return new CardSelectionListAdapter(spinner.getContext(),
                R.layout.sample_spinner_selected_item, cardNumberList, expirsList);
    }

    public static CardSelectionListAdapter getAdapter(ImageView imageView){
        return new CardSelectionListAdapter(imageView);
    }

    public static List<String> getCardNumber() {
        cardInformationList = new ArrayList<String>();
        cardInformationList.add("3500000000000000");
        cardInformationList.add("4800000000000000");
        cardInformationList.add("5500000000000000");
        cardInformationList.add("39000000000000");
        return cardInformationList;
    }

    private static int getImage(int i) {
//        for (int i=0; i < cardInformationList.size(); i++){
            imageList.add(CardBrandType.type(String.valueOf(cardInformationList.get(i))).getImage());
            return imageList.get(i);
//        }
//        return imageList.get(i);
    }

    public static List<String> getExpir() {
        expirsList = new ArrayList<String>();
        expirsList.add("05/27");
        expirsList.add("01/30");
        expirsList.add("12/26");
        expirsList.add("10/35");
        return expirsList;
    }
}
