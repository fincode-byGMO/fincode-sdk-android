package jp.gmopg.japanpost.fincodesdk.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.Log;
import android.widget.TextView;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/07/10.
 */
public class ResourceUtil {

    public static void replaceFrameBorder(Context context) {

        Drawable frameBorderDefault = context.getResources().getDrawable(R.drawable.frame_border_default);
        Drawable frameBorderSelected = context.getResources().getDrawable(R.drawable.frame_border_selected);
        Drawable frameBorderError = context.getResources().getDrawable(R.drawable.frame_border_error);

        setBackground(frameBorderDefault);
        setBackground(frameBorderSelected);
        setBackground(frameBorderError);
    }

    private static void setBackground(Drawable drw) {
        String optColor = FincodeViewModelHolder.getInstance().getOptViewModel().getColorBackgroundInput();
        if(!optColor.isEmpty() && drw instanceof GradientDrawable) {
            GradientDrawable gDrw = (GradientDrawable) drw;
            gDrw.setColor(Color.parseColor(optColor));
        }
    }
}
