package jp.gmopg.japanpost.fincodesdk.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

/**
 * Created by a.nakajima on 2022/05/23.
 */
public class DynamicCardBrandImageAdapter {

    @BindingAdapter("imageResource")
    public static void imageResource(ImageView view, int resourceId) {
        if(0 < resourceId) {
            view.setImageResource(resourceId);
        } else {
            view.setImageDrawable(null);
        }
    }
}
