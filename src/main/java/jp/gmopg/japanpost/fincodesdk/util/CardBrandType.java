package jp.gmopg.japanpost.fincodesdk.util;

import java.util.StringJoiner;
import java.util.regex.Pattern;

import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModel;
import jp.gmopg.japanpost.fincodesdk.R;

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
        if (Pattern.compile(VISA.regex).matcher(number).matches()) {
            return VISA;
        }
        if (Pattern.compile(MASTER.regex).matcher(number).matches()) {
            return MASTER;
        }
        if (Pattern.compile(JCB.regex).matcher(number).matches()) {
            return JCB;
        }
        if (Pattern.compile(DINERS.regex).matcher(number).matches()) {
            return DINERS;
        }
        if (Pattern.compile(AMEX.regex).matcher(number).matches()) {
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

    public int digits() {
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

}
