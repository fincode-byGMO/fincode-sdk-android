package jp.gmopg.japanpost.fincodesdk.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

/**
 * Created by a.nakajima on 2022/05/23.
 */
public class ColorTextAdapter {

    @BindingAdapter("colorText")
    public static void colorText(TextView view, String color) {
        if(!color.isEmpty()) {
            view.setTextColor(Color.parseColor(color));
        }
    }
}
