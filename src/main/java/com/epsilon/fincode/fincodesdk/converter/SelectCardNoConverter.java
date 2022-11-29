package com.epsilon.fincode.fincodesdk.converter;

import com.epsilon.fincode.fincodesdk.enumeration.CardBrandType;
import com.epsilon.fincode.fincodesdk.util.StringUtil;

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
