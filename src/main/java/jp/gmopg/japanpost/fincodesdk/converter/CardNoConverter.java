package jp.gmopg.japanpost.fincodesdk.converter;

import androidx.databinding.InverseMethod;
import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class CardNoConverter {
//    @InverseMethod("withOutSpace")
    public static String withSpace(String brandName, String maskCardNo) {
        return CardBrandType.typeForName(brandName).delimit(maskCardNo);
    }

//    public static String withOutSpace(String value) {
//        return  value.replace(" ", "");
//    }
}
