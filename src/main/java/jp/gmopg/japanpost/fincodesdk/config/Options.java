package jp.gmopg.japanpost.fincodesdk.config;

import jp.gmopg.japanpost.fincodesdk.enumeration.SubmitButtonType;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class Options {

    /**
     * 見出しの表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isHeadingVisibility;

    /**
     * ブランド画像 動的切り替えの表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isDynamicLogDisplayVisibility;

    /**
     * 名義人名の表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isHolderNameVisibility;

    /**
     * お支払い回数の表示・非表示 <br/>
     * true: 表示, false: 非表示
     */
    public boolean isPayTimesVisibility;

//    /**
//     * submitボタンの指定 <br/>
//     * PAYMENT: お支払い, CARD_REGISTER: カード登録, CARD_RENEWAL:カード更新
//     */
//    public SubmitButtonType isSubmitButtonType;
}
