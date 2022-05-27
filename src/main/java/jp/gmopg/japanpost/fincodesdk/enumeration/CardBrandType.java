package jp.gmopg.japanpost.fincodesdk.enumeration;

import java.util.regex.Pattern;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.util.StringUtil;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public enum CardBrandType{

    NONE("", ""),
    VISA("VISA", "^4[0-9]{0,16}$"),
    MASTER("MASTER", "(^5[1-5][0-9]{0,15}$)|(^2[2-7][0-9]{0,15}$)"),
    JCB("JCB", "^35[0-9]{0,15}$"),
    DINERS("DINERS", "(^30[0-9]{0,13}$)|(^36[0-9]{0,13}$)|(^38[0-9]{0,13}$)|(^39[0-9]{0,13}$)"),
    AMEX("AMEX", "(^34[0-9]{0,14}$)|(^37[0-9]{0,14}$)");

    private String brandChar;
    private String regex;

    CardBrandType(String brandChar, String regex) {
        this.brandChar = brandChar;
        this.regex = regex;
    }

    public static CardBrandType type(String number){
        if(number == null) { return NONE; }

        String withOutSpace = number.replace(" ", "");
        if (Pattern.compile(VISA.regex).matcher(withOutSpace).matches()) {
            return VISA;
        }
        if (Pattern.compile(MASTER.regex).matcher(withOutSpace).matches()) {
            return MASTER;
        }
        if (Pattern.compile(JCB.regex).matcher(withOutSpace).matches()) {
            return JCB;
        }
        if (Pattern.compile(DINERS.regex).matcher(withOutSpace).matches()) {
            return DINERS;
        }
        if (Pattern.compile(AMEX.regex).matcher(withOutSpace).matches()) {
            return AMEX;
        }
        return NONE;
    }

    public int getImage(){

        switch (this) {
            case VISA:
                return R.drawable.visa;
            case MASTER:
                return R.drawable.master;
            case JCB:
                return R.drawable.jcb;
            case DINERS:
                return R.drawable.diners;
            case AMEX:
                return R.drawable.amex;
            case NONE:
            default:
                return -1; // TODO 該当なしの場合-1を返却でいいか検討する
        }
    }

    public int digitsWithOutSpace() {
        switch (this) {
            case DINERS:
                return 14;
            case AMEX:
                return 15;
            case VISA:
            case MASTER:
            case JCB:
            case NONE:
            default:
                return 16;
        }
    }

    public int digitsWithSpace() {
        switch (this) {
            case DINERS:
                return 16;
            case AMEX:
                return 17;
            case VISA:
            case MASTER:
            case JCB:
            case NONE:
            default:
                return 19;
        }
    }

    public String delimit(String value) {
        switch (this) {
            case DINERS:
                return StringUtil.fourSixFourDelimit(value);
            case AMEX:
                return StringUtil.fourSixFiveDelimit(value);
            case VISA:
            case MASTER:
            case JCB:
            case NONE:
            default:
                return StringUtil.allFourDelimit(value);
        }
    }

    public static boolean securityCodeLength(String value) {

        if (value.matches("^[0-9]{3,4}$")) {
            return false;
        }
        return true;
    }
}
