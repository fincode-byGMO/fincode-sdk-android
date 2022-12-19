package com.epsilon.fincode.fincodesdk.config;

import com.epsilon.fincode.fincodesdk.enumeration.Authorization;
import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;

/**
 * Created by a.nakajima on 2022/07/04.
 */
public class FincodeConfiguration {

    /**
     * 利用目的を選択 <br/>
     * ・PAYMENT : 決済 <br/>
     * ・CARD_REGISTER : カード登録 <br/>
     * ・CARD_UPDATE : カード更新
     */
    private SubmitButtonType submitButtonType = SubmitButtonType.NONE;

    /**
     * 認証方式 <br/>
     * ・BASIC : Basic認証 <br/>
     * ・BEARER : Bearer認証
     */
    public Authorization authorization = Authorization.NONE;

    /**
     * パブリックキー <br/>
     * ※ Basic認証の場合は、Base64でエンコードしてください。
     */
    public String apiKey = "";

    /**
     * APIバージョン
     */
    public String apiVersion = "";

    /**
     * 顧客ID
     */
    public String customerId = "";

    public SubmitButtonType getSubmitButtonType() {
        return this.submitButtonType;
    }

    protected FincodeConfiguration(SubmitButtonType submitButtonType) {
        this.submitButtonType = submitButtonType;
    }
}
