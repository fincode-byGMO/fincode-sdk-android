package jp.gmopg.japanpost.fincodesdk.config;

import jp.gmopg.japanpost.fincodesdk.enumeration.DefaultFlg;
import jp.gmopg.japanpost.fincodesdk.enumeration.SubmitButtonType;

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
    public DefaultFlg defaultFlg = DefaultFlg.OFF;

    public FincodeCardUpdateConfiguration() {
        super(SubmitButtonType.CARD_UPDATE);
    }
}
