package jp.gmopg.japanpost.fincodesdk.enumeration;

/**
 * Created by a.nakajima on 2022/07/04.
 */
public enum DefaultFlg {
    OFF("0"),
    ON("1");

    private String value;

    private DefaultFlg(String value) {
        this.value = value;
    }

    public static DefaultFlg of(String value) {
        switch (value) {
            case "0":
                return DefaultFlg.OFF;
            case "1":
                return DefaultFlg.ON;
            default:
                return DefaultFlg.OFF;
        }
    }

    public String getValue() {
        return this.value;
    }
}
