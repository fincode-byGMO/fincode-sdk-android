package jp.gmopg.japanpost.fincodesdk.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.databinding.DataBindingUtil;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.FincodeSelectCardNoCellViewBinding;
import jp.gmopg.japanpost.fincodesdk.entities.SelectCardNoItem;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by m.ohkawa on 2022/06/03.
 */
public class CardSelectionListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SelectCardNoItem> selectCardNoList;

    public CardSelectionListAdapter(Context context, ArrayList<SelectCardNoItem> selectCardNoList) {
        this.context = context;
        this.selectCardNoList = selectCardNoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FincodeSelectCardNoCellViewBinding binding = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            binding = DataBindingUtil.inflate(inflater, R.layout.fincode_select_card_no_cell_view, parent, false);
            binding.getRoot().setTag(binding);
        } else {
            if(convertView.getTag() instanceof FincodeSelectCardNoCellViewBinding) {
                binding = (FincodeSelectCardNoCellViewBinding) convertView.getTag();
            }
        }

        setColorText(binding);
        setFontFamily(binding);
        binding.setItem(selectCardNoList.get(position));


        return binding.getRoot();
    }

    @Override
    public int getCount() {
        return selectCardNoList.size();
    }

    @Override
    public Object getItem(int position) {
        return selectCardNoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public SelectCardNoItem item(int position) {
        return selectCardNoList.get(position);
    }

    private void setColorText(FincodeSelectCardNoCellViewBinding binding) {
        String colorText = FincodeViewModelHolder.getInstance().getOptViewModel().getColorText();
        if(!colorText.isEmpty()) {
            binding.selectCardNo.setTextColor(Color.parseColor(colorText));
            binding.selectCardExpire.setTextColor(Color.parseColor(colorText));
        }
    }

    private void setFontFamily(FincodeSelectCardNoCellViewBinding binding) {
        Typeface fontFamily = FincodeViewModelHolder.getInstance().getOptViewModel().getFontFamily();
        if(fontFamily != null) {
            binding.selectCardNo.setTypeface(fontFamily);
            binding.selectCardExpire.setTypeface(fontFamily);
        }
    }
}
