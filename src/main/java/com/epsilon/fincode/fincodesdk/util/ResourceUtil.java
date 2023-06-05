package com.epsilon.fincode.fincodesdk.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.Log;
import android.widget.TextView;

import com.epsilon.fincode.fincodesdk.R;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/07/10.
 */
public class ResourceUtil {

    public static void replaceFrameBackground(Context context, String colorHex) {

        Drawable frameBorderDefault = context.getResources().getDrawable(R.drawable.frame_border_default);
        Drawable frameBorderSelected = context.getResources().getDrawable(R.drawable.frame_border_selected);
        Drawable frameBorderError = context.getResources().getDrawable(R.drawable.frame_border_error);

        setBackground(frameBorderDefault, colorHex);
        setBackground(frameBorderSelected, colorHex);
        setBackground(frameBorderError, colorHex);
    }

    public static void replaceFrameBorder(Context context, String colorHex) {

        Drawable frameBorderDefault = context.getResources().getDrawable(R.drawable.frame_border_default);
        int width = (int)(1.5 * context.getResources().getDisplayMetrics().density);
        setBorder(frameBorderDefault, width, colorHex);
    }

    private static void setBackground(Drawable drw, String colorHex) {
//        String optColor = FincodeViewModelHolder.getInstance().getOptViewModel().getColorBackgroundInput();
        if(!colorHex.isEmpty() && drw instanceof GradientDrawable) {
            GradientDrawable gDrw = (GradientDrawable) drw;
            gDrw.setColor(Color.parseColor(colorHex));
        }
    }

    private static void setBorder(Drawable drw, int width, String colorHex) {
//        String optColor = FincodeViewModelHolder.getInstance().getOptViewModel().getColorBorder();
        if(!colorHex.isEmpty() && drw instanceof GradientDrawable) {
            GradientDrawable gDrw = (GradientDrawable) drw;
            gDrw.setStroke(width, Color.parseColor(colorHex));
        }
    }
}
