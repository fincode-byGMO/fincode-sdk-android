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
     * お支払い回数の表示・非表示
     * true: 表示, false: 非表示
     */
    public boolean isPayTimesVisibility;

    /**
     * ラベルテキストを設定 ( カード番号 )
     */
    public String labelCardNo;

    /**
     * ラベルテキストを設定 ( 有効期限 )
     */
    public String labelExpire;

    /**
     * ラベルテキストを設定 ( セキュリティコード )
     */
    public String labelCvc;

    /**
     * ラベルテキストを設定 ( カード名義人名 )
     */
    public String labelHolderName;

    /**
     * ラベルテキストを設定 ( お支払い方法 )
     */
    public String labelPaymentMethod;

    /**
     * プレースホルダーを設定 ( カード番号 )
     */
    public String placeCardNo;

    /**
     * プレースホルダーを設定 ( 有効期限 [月] )
     */
    public String placeExpireMonth;

    /**
     * プレースホルダーを設定 ( 有効期限 [年] )
     */
    public String placeExpireYear;

    /**
     * プレースホルダーを設定 ( セキュリティコード )
     */
    public String placeCvc;

    /**
     * プレースホルダーを設定 ( カード名義人名 )
     */
    public String placeHolderName;


}
