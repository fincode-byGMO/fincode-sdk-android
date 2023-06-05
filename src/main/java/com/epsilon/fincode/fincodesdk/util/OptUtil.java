package com.epsilon.fincode.fincodesdk.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.epsilon.fincode.fincodesdk.R;

/**
 * Created by a.nakajima on 2023/01/27.
 */
public class OptUtil {

    private enum Attrs {
        HEADING_HIDDEN(R.styleable.FincodeVerticalView_headingHidden, R.styleable.FincodeHorizontalView_headingHidden),
        DYNAMIC_LOG_DISPLAY(R.styleable.FincodeVerticalView_dynamicLogDisplay, R.styleable.FincodeHorizontalView_dynamicLogDisplay),
        HOLDER_NAME_HIDDEN(R.styleable.FincodeVerticalView_holderNameHidden, R.styleable.FincodeHorizontalView_holderNameHidden),
        PAY_TIMES_HIDDEN(R.styleable.FincodeVerticalView_payTimesHidden, R.styleable.FincodeHorizontalView_payTimesHidden),
        LABEL_CARD_NO(R.styleable.FincodeVerticalView_labelCardNo, R.styleable.FincodeHorizontalView_labelCardNo),
        LABEL_EXPIRE(R.styleable.FincodeVerticalView_labelExpire, R.styleable.FincodeHorizontalView_labelExpire),
        LABEL_CVC(R.styleable.FincodeVerticalView_labelCvc, R.styleable.FincodeHorizontalView_labelCvc),
        LABEL_HOLDER_NAME(R.styleable.FincodeVerticalView_labelHolderName, R.styleable.FincodeHorizontalView_labelHolderName),
        LABEL_PAYMENT_METHOD(R.styleable.FincodeVerticalView_labelPaymentMethod, R.styleable.FincodeHorizontalView_labelPaymentMethod),
        PLACE_CARD_NO(R.styleable.FincodeVerticalView_placeCardNo, R.styleable.FincodeHorizontalView_placeCardNo),
        PLACE_EXPIRE_MONTH(R.styleable.FincodeVerticalView_placeExpireMonth, R.styleable.FincodeHorizontalView_placeExpireMonth),
        PLACE_EXPIRE_YEAR(R.styleable.FincodeVerticalView_placeExpireYear, R.styleable.FincodeHorizontalView_placeExpireYear),
        PLACE_CVC(R.styleable.FincodeVerticalView_placeCvc, R.styleable.FincodeHorizontalView_placeCvc),
        PLACE_HOLDER_NAME(R.styleable.FincodeVerticalView_placeHolderName, R.styleable.FincodeHorizontalView_placeHolderName),
        COLOR_BACKGROUND(R.styleable.FincodeVerticalView_colorBackground, R.styleable.FincodeHorizontalView_colorBackground),
        COLOR_BACKGROUND_INPUT(R.styleable.FincodeVerticalView_colorBackgroundInput, R.styleable.FincodeHorizontalView_colorBackgroundInput),
        COLOR_TEXT(R.styleable.FincodeVerticalView_colorText, R.styleable.FincodeHorizontalView_colorText),
        COLOR_LABEL_TEXT(R.styleable.FincodeVerticalView_colorLabelText, R.styleable.FincodeHorizontalView_colorLabelText),
        COLOR_BORDER(R.styleable.FincodeVerticalView_colorBorder, R.styleable.FincodeHorizontalView_colorBorder);

        private int attrIdVerti;
        private int attrIdHori;

        private Attrs(int attrIdVerti, int attrIdHori) {
            this.attrIdVerti = attrIdVerti;
            this.attrIdHori = attrIdHori;
        }

        public int id(int layoutId) {
            if (layoutId == R.layout.fincode_vertical_view) {
                return this.attrIdVerti;
            } else {
                return this.attrIdHori;
            }
        }
    }

    private static int[] customAttrId(int layoutId) {
        if (LayoutUtil.isVertical(layoutId)) {
            return R.styleable.FincodeVerticalView;
        } else {
            return R.styleable.FincodeHorizontalView;
        }
    }

    private static TypedArray attrs(Context context, AttributeSet attrs, int layoutId) {
        return context.getTheme().obtainStyledAttributes(attrs, customAttrId(layoutId), 0, 0);
    }

    /**
     * 見出しの表示・非表示
     * @return true: 非表示, false: 表示
     */
    public static boolean headingHidden(Context context, AttributeSet attrs, int layoutId, boolean defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            return typedArray.getBoolean(Attrs.HEADING_HIDDEN.id(layoutId), defValue);
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * ブランド画像 動的切り替えの表示・非表示
     * @return true: 非表示, false: 表示
     */
    public static boolean dynamicLogDisplay(Context context, AttributeSet attrs, int layoutId, boolean defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            return typedArray.getBoolean(Attrs.DYNAMIC_LOG_DISPLAY.id(layoutId), defValue);
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * 名義人名の表示・非表示
     * @return true: 非表示, false: 表示
     */
    public static boolean holderNameHidden(Context context, AttributeSet attrs, int layoutId, boolean defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            return typedArray.getBoolean(Attrs.HOLDER_NAME_HIDDEN.id(layoutId), defValue);
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * お支払い回数の表示・非表示
     * @return true: 非表示, false: 表示
     */
    public static boolean payTimesHidden(Context context, AttributeSet attrs, int layoutId, boolean defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            return typedArray.getBoolean(Attrs.PAY_TIMES_HIDDEN.id(layoutId), defValue);
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * ラベルテキストを設定 ( カード番号 )
     * @return
     */
    public static String labelCardNo(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.LABEL_CARD_NO.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * ラベルテキストを設定 ( 有効期限 )
     * @return
     */
    public static String labelExpire(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.LABEL_EXPIRE.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * ラベルテキストを設定 ( セキュリティコード )
     * @return
     */
    public static String labelCvc(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.LABEL_CVC.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * ラベルテキストを設定 ( カード名義人名 )
     * @return
     */
    public static String labelHolderName(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.LABEL_HOLDER_NAME.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * ラベルテキストを設定 ( お支払い方法 )
     * @return
     */
    public static String labelPaymentMethod(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.LABEL_PAYMENT_METHOD.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * プレースホルダーを設定 ( カード番号 )
     * @return
     */
    public static String placeCardNo(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.PLACE_CARD_NO.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * プレースホルダーを設定 ( 有効期限 [月] )
     * @return
     */
    public static String placeExpireMonth(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.PLACE_EXPIRE_MONTH.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * プレースホルダーを設定 ( 有効期限 [年] )
     * @return
     */
    public static String placeExpireYear(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.PLACE_EXPIRE_YEAR.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * プレースホルダーを設定 ( セキュリティコード )
     * @return
     */
    public static String placeCvc(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.PLACE_CVC.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * プレースホルダーを設定 ( カード名義人名 )
     * @return
     */
    public static String placeHolderName(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.PLACE_HOLDER_NAME.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * フォーム全体の背景色 <br/>
     * 16進数
     * 例 #71f5c4
     * @return
     */
    public static String colorBackground(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.COLOR_BACKGROUND.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * インプットフィールドの背景色 <br/>
     * 16進数
     * 例 #71f5c4
     * @return
     */
    public static String colorBackgroundInput(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.COLOR_BACKGROUND_INPUT.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * インプットの文字色 <br/>
     * 16進数
     * 例 #71f5c4
     * @return
     */
    public static String colorText(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.COLOR_TEXT.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * ラベルの文字色 <br/>
     * 16進数
     * 例 #71f5c4
     * @return
     */
    public static String colorLabelText(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.COLOR_LABEL_TEXT.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * インプットのボーダーの色 <br/>
     * 16進数
     * 例 #71f5c4
     * @return
     */
    public static String colorBorder(Context context, AttributeSet attrs, int layoutId, String defValue) {
        if(attrs == null) { return defValue; }

        TypedArray typedArray = attrs(context, attrs, layoutId);
        try {
            String result = typedArray.getString(Attrs.COLOR_BORDER.id(layoutId));
            return result != null ? result : defValue;
        } finally {
            typedArray.recycle();
        }
    }
}
