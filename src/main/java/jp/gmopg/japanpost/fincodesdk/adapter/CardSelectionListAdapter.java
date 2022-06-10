package jp.gmopg.japanpost.fincodesdk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.entities.CardInfoItem;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;

/**
 * Created by m.ohkawa on 2022/06/03.
 */
public class CardSelectionListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private int layoutID;

    private static int imageViewId;
    private static List<Integer> imageIDs;
    private static List<String> cardInformationList;
    private static List<String> expirsList;
    private static List<String> brandTypeList;
    private static ArrayList<CardInfoItem> cardInfoItemArrayList;

    static class ViewHolder {
        ImageView imageView;
        TextView cardNumberView;
        TextView expirView;
    }

    CardSelectionListAdapter(Context context,
                             int itemLayoutId,
                             ArrayList<CardInfoItem> cardInfoItems){

        inflater = LayoutInflater.from(context);
        layoutID = itemLayoutId;
        cardInfoItemArrayList = cardInfoItems;
        imageIDs = new ArrayList<>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(layoutID, null);
            holder = new ViewHolder();

            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.cardNumberView = convertView.findViewById(R.id.textView);
            holder.expirView = convertView.findViewById(R.id.expirText);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        getImage(position);
        holder.imageView.setImageResource(imageIDs.get(position));
        holder.cardNumberView.setText(cardInfoItemArrayList.get(position).getCardNumber());
        holder.expirView.setText(cardInfoItemArrayList.get(position).getExpire());

        return convertView;
    }

    @Override
    public int getCount() {
        return cardInfoItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static CardSelectionListAdapter getAdapter(Spinner spinner, ArrayList<CardInfoItem> cardInfoItems){
        return new CardSelectionListAdapter(spinner.getContext(),
                R.layout.fincode_spinner_selected_item, cardInfoItems);
    }

    private static void getImage(int position) {
        imageViewId = CardBrandType.getImage(cardInfoItemArrayList.get(position).getCardBrand());
        imageIDs.add(position, imageViewId);
    }

    public static List<String> getCardNumber() {
        cardInformationList = new ArrayList<>();
        cardInformationList.add("3500000000000000");
        cardInformationList.add("4800000000000000");
        cardInformationList.add("5500000000000000");
        cardInformationList.add("39000000000000");
        return cardInformationList;
    }

    public static List<String> getExpir() {
        expirsList = new ArrayList<>();
        expirsList.add("0527");
        expirsList.add("0130");
        expirsList.add("1226");
        expirsList.add("1035");
        return expirsList;
    }

    public static List<String> getBrandType() {
        brandTypeList = new ArrayList<>();
        brandTypeList.add("JCB");
        brandTypeList.add("VISA");
        brandTypeList.add("MASTER");
        brandTypeList.add("DINERS");
        return brandTypeList;
    }
}
