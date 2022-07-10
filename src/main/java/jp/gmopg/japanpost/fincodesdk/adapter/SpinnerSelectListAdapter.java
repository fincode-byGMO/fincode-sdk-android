package jp.gmopg.japanpost.fincodesdk.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.FincodeSelectCardNoCellViewBinding;
import jp.gmopg.japanpost.fincodesdk.entities.SelectCardNoItem;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

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

        view.setText(list[position]);
        String colorText = FincodeViewModelHolder.getInstance().getOptViewModel().getColorText();
        if(!colorText.isEmpty()) {
            view.setTextColor(Color.parseColor(colorText));
        }

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
}
