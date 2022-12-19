package com.epsilon.fincode.fincodesdk.config;

import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;

/**
 * Created by a.nakajima on 2022/07/04.
 */
public class FincodePaymentConfiguration extends FincodeConfiguration {

    /**
     * 決済種別
     */
    public String payType = "";

    /**
     * 取引ID
     */
    public String accessId = "";

    /**
     * オーダーID
     */
    public String id = "";

    public FincodePaymentConfiguration() {
        super(SubmitButtonType.PAYMENT);
    }
}
