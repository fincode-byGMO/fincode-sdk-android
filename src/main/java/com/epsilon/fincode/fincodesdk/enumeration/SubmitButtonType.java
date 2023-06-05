package com.epsilon.fincode.fincodesdk.enumeration;

import com.epsilon.fincode.fincodesdk.R;

/**
 * Created by m.ohkawa on 2022/05/30.
 */
public enum SubmitButtonType {
    NONE,
    PAYMENT,
    CARD_REGISTER,
    CARD_UPDATE;

    public static String getTitle(SubmitButtonType type){
        switch (type){
            case PAYMENT:
                return "お支払い";
            case CARD_REGISTER:
                return "クレジットカードを登録";
            case CARD_UPDATE:
                return "クレジットカードを更新";
            default:
                return "";
        }
    }
}
