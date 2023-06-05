package com.epsilon.fincode.fincodesdk.config;

import com.epsilon.fincode.fincodesdk.enumeration.DefaultFlg;
import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;

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
