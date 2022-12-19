package com.epsilon.fincode.fincodesdk.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

/**
 * Created by a.nakajima on 2022/05/23.
 */
public class FontFamilyAdapter {

    @BindingAdapter(value={"fontFamily"}, requireAll=false)
    public static void fontFamily(TextView view, Typeface typeface) {
        if(typeface != null) {
            view.setTypeface(typeface);
        }
    }
}
