package jp.gmopg.japanpost.fincodesdk.converter;

import jp.gmopg.japanpost.fincodesdk.enumeration.CardBrandType;
import jp.gmopg.japanpost.fincodesdk.util.StringUtil;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class SelectCardNoConverter {

    public static String withSpace(String brandName, String maskCardNo) {
        return CardBrandType.typeForName(brandName).delimit(maskCardNo);
    }

    public static String withSlash(String expir){
        return StringUtil.setSlash(expir);
    }
}
