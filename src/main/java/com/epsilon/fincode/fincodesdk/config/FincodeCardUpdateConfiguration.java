package com.epsilon.fincode.fincodesdk.config;

import com.epsilon.fincode.fincodesdk.enumeration.DefaultFlg;
import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;

/**
 * Created by a.nakajima on 2022/07/04.
 */
public class FincodeCardUpdateConfiguration extends FincodeConfiguration {

    /**
     * カードID
     */
    public String cardId = "";

    /**
     * デフォルトフラグ
     */
    public DefaultFlg defaultFlg = null;

    public FincodeCardUpdateConfiguration() {
        super(SubmitButtonType.CARD_UPDATE);
    }
}
