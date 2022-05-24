package jp.gmopg.japanpost.fincodesdk.converter;

import androidx.databinding.InverseMethod;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;

// TODO Delete

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class CardNoConverter {
    @InverseMethod("withOutSpace")
    public static String withSpace(String value) {
        return CardBrandType.type(value).delimit(value);
    }

    public static String withOutSpace(String value) {
        return  value.replace(" ", "");
    }
}
