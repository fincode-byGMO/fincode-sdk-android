package com.epsilon.fincode.fincodesdk.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.BindingAdapter;

/**
 * Created by a.nakajima on 2022/05/23.
 */
public class ColorBackgroundAdapter {

    @BindingAdapter("colorBackground")
    public static void colorBackground(View view, String color) {
        if(!color.isEmpty()) {
            view.setBackgroundColor(Color.parseColor(color));
        }
    }
}
