package com.epsilon.fincode.fincodesdk.util;

import com.epsilon.fincode.fincodesdk.R;

/**
 * Created by a.nakajima on 2023/01/27.
 */
public class LayoutUtil {

    public static boolean isVertical(int layoutId) {
        return layoutId == R.layout.fincode_vertical_view;
    }

    public static boolean isHorizontal(int layoutId) {
        return layoutId == R.layout.fincode_horizontal_view;
    }
}
