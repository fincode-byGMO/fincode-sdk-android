package jp.gmopg.japanpost.fincodesdk.enumeration;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.config.OptionData;

/**
 * Created by m.ohkawa on 2022/05/30.
 */
public enum ButtonPressType {
    PAYMENT,
    CARD_REGISTER,
    CARD_RENEWAL;

    private static ButtonPressType buttonPressType;

    public static ButtonPressType getButtonPressType() {
        return buttonPressType;
    }

    public static void setButtonPressType(ButtonPressType buttonPressType) {
        ButtonPressType.buttonPressType = buttonPressType;
    }

    public static int buttonText(){
        if(buttonPressType == null) {
            // アプリ側で指定された機能によって、ボタンのテキストを変える（今はNULLで落ちるので、お支払いになるようにしている）
//            setButtonPressType(OptionData.getInstance().isButtonPressType);
            setButtonPressType(ButtonPressType.PAYMENT);
        }
        switch (buttonPressType){
            case PAYMENT:
                return R.string.credit_payment;
            case CARD_REGISTER:
                return R.string.credit_card_registration;
            case CARD_RENEWAL:
                return R.string.credit_card_renewal;
            default:
                return 0;
        }
    }
}
