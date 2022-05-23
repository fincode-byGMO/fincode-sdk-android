package jp.gmopg.japanpost.fincodesdk.config;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class OptionData {

    /**
     * 見出しの表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isHeadingVisibility;

    /**
     * ブランド画像 動的切り替えの表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isDynamicLogDisplayVisibility;

    /**
     * 名義人名の表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isHolderNameVisibility;

    /**
     * お支払い回数の表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isPayTimesVisibility;

    private static OptionData optionData;

    private OptionData() {
    }

    public static OptionData getInstance() {
        if(optionData == null) {
            optionData = new OptionData();
        }
        return  optionData;
    }

    // カスタム属性を利用する場合は以下を活かす
//    public OptionData(Context context, AttributeSet attrs){
//        isHeadingVisibility = getAttrsBoolean(context, attrs, R.styleable.FincodeSetting_fincodeHeadingVisibility, true);
//        isDynamicLogDisplayVisibility = getAttrsBoolean(context, attrs, R.styleable.FincodeSetting_fincodeDynamicLogDisplayVisibility, true);
//        isHolderNameVisibility = getAttrsBoolean(context, attrs, R.styleable.FincodeSetting_fincodeHolderNameVisibility, true);
//        isPayTimesVisibility = getAttrsBoolean(context, attrs, R.styleable.FincodeSetting_fincodePayTimesVisibility, true);
//    }
//
//    private boolean getAttrsBoolean(Context context, AttributeSet attrs, int index, boolean defValue) {
//        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FincodeSetting, 0, 0);
//        try {
//            return typedArray.getBoolean(index, defValue);
//        } catch (Exception exc) {
//            return defValue;
//        }
//        finally {
//            typedArray.recycle();
//        }
//    }
}
