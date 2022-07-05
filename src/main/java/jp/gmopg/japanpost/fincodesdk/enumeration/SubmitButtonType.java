package jp.gmopg.japanpost.fincodesdk.enumeration;

import jp.gmopg.japanpost.fincodesdk.R;

/**
 * Created by m.ohkawa on 2022/05/30.
 */
public enum SubmitButtonType {
    NONE,
    PAYMENT,
    CARD_REGISTER,
    CARD_UPDATE;

    private static SubmitButtonType submitButtonType;

    public static SubmitButtonType getButtonPressType() {
        return submitButtonType;
    }

    public static void setButtonPressType(SubmitButtonType submitButtonType) {
        SubmitButtonType.submitButtonType = submitButtonType;
    }

    public static int buttonText(){
        if(submitButtonType == null) {
            // アプリ側で指定された機能によって、ボタンのテキストを変える（今はNULLで落ちるので、お支払いになるようにしている）
//            setButtonPressType(OptionData.getInstance().isButtonPressType);
            setButtonPressType(SubmitButtonType.PAYMENT);
        }
        switch (submitButtonType){
            case PAYMENT:
                return R.string.credit_payment;
            case CARD_REGISTER:
                return R.string.credit_card_registration;
            case CARD_UPDATE:
                return R.string.credit_card_renewal;
            default:
                return 0;
        }
    }
}
