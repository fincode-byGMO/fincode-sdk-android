package jp.gmopg.japanpost.fincodesdk.config;

import jp.gmopg.japanpost.fincodesdk.enumeration.DefaultFlg;
import jp.gmopg.japanpost.fincodesdk.enumeration.SubmitButtonType;

/**
 * Created by a.nakajima on 2022/07/04.
 */
public class FincodeCardRegisterConfiguration extends FincodeConfiguration {

    /**
     * デフォルトフラグ
     */
    public DefaultFlg defaultFlg = DefaultFlg.OFF;

    public FincodeCardRegisterConfiguration() {
        super(SubmitButtonType.CARD_REGISTER);
    }
}
