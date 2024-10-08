package com.epsilon.fincode.fincodesdk.enumeration;

import java.util.regex.Pattern;
import com.epsilon.fincode.fincodesdk.R;
import com.epsilon.fincode.fincodesdk.util.StringUtil;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public enum CardBrandType{

    NONE("", ""),
    VISA("VISA", "^4[0-9]{0,15}$"),
    MASTER("MASTER", "^[25][0-9]{0,15}$"),
    JCB("JCB", "^35[0-9]{0,14}$"),
    DINERS("DINERS", "^3[0689][0-9]{0,12}$"),
    AMEX("AMEX", "^3[47][0-9]{0,13}$"),
    DISCOVER("DISCOVER", "^6[045][0-9]{0,14}$");
    private String brandChar;
    private String regex;

    CardBrandType(String brandChar, String regex) {
        this.brandChar = brandChar;
        this.regex = regex;
    }

    public static CardBrandType typeForNumber(String number){
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
        if (Pattern.compile(DISCOVER.regex).matcher(withOutSpace).matches()) {
            return DISCOVER;
        }
        return NONE;
    }

    public static CardBrandType typeForName(String name){
        if(name == null || name.isEmpty()) { return NONE; }

        for (CardBrandType i : CardBrandType.values()) {
            if(i.getBrandChar().equals(name)) {
                return i;
            }
        }

        return NONE;
    }

    public int getImage(){

        switch (this) {
            case VISA:
                return R.drawable.ic_visa;
            case MASTER:
                return R.drawable.ic_master;
            case JCB:
                return R.drawable.ic_jcb;
            case DINERS:
                return R.drawable.ic_diners;
            case AMEX:
                return R.drawable.ic_amex;
            case DISCOVER:
                return R.drawable.ic_discover;
            case NONE:
            default:
                return -1;
        }
    }

    public static int getImage(String brandName){

        switch (brandName) {
            case "VISA":
                return R.drawable.ic_visa;
            case "MASTER":
                return R.drawable.ic_master;
            case "JCB":
                return R.drawable.ic_jcb;
            case "DINERS":
                return R.drawable.ic_diners;
            case "AMEX":
                return R.drawable.ic_amex;
            case "DISCOVER":
                return R.drawable.ic_discover;
            case "NONE":
            default:
                return -1;
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
            case DISCOVER:
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
            case DISCOVER:
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
            case DISCOVER:
            case NONE:
            default:
                return StringUtil.allFourDelimit(value);
        }
    }

    public static boolean cardNumberLength(String value) {

        if (value.matches("^[0-9]{10,16}$")) {
            return false;
        }
        return true;
    }

    public static boolean securityCodeLength(String value) {

        if (value.matches("^[0-9]{3,4}$")) {
            return false;
        }
        return true;
    }

    public String getBrandChar() {
        return this.brandChar;
    }
}
