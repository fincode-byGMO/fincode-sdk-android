package com.epsilon.fincode.fincodesdk.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import com.epsilon.fincode.fincodesdk.R;
import com.epsilon.fincode.fincodesdk.databinding.FincodeSelectCardNoCellViewBinding;
import com.epsilon.fincode.fincodesdk.entities.SelectCardNoItem;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by m.ohkawa on 2022/06/03.
 */
public class SpinnerSelectListAdapter extends BaseAdapter {

    private Context context;
    private final LayoutInflater inflater;
    private String[] list;

    public SpinnerSelectListAdapter(Context context, String[] list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView view;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fincode_pay_times_cell_view, null);
            view = convertView.findViewById(R.id.pay_times_text);
            convertView.setTag(view);
        } else {
            view = (TextView) convertView.getTag();
        }

        setColorText(view);
        setFontFamily(view);
        view.setText(list[position]);

        return convertView;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String  item(int position) {
        return list[position];
    }

    private void setColorText(TextView view) {
        String colorText = FincodeViewModelHolder.getInstance().getOptViewModel().getColorText();
        if(!colorText.isEmpty()) {
            view.setTextColor(Color.parseColor(colorText));
        }
    }

    private void setFontFamily(TextView view) {
        Typeface fontFamily = FincodeViewModelHolder.getInstance().getOptViewModel().getFontFamily();
        if(fontFamily != null) {
            view.setTypeface(fontFamily);
        }
    }
}
