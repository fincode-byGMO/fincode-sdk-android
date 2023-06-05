package com.epsilon.fincode.fincodesdk.config;

import android.graphics.Typeface;

import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class Options {

    /**
     * 見出しの表示・非表示 <br/>
     * true: 非表示, false: 表示
     */
    public boolean headingHidden = false;

    /**
     * ブランド画像 動的切り替えの表示・非表示 <br/>
     * true: 非表示, false: 表示
     */
    public boolean dynamicLogDisplay = false;

    /**
     * 名義人名の表示・非表示 <br/>
     * true: 非表示, false: 表示
     */
    public boolean holderNameHidden = false;

    /**
     * お支払い回数の表示・非表示
     * true: 非表示, false: 表示
     */
    public boolean payTimesHidden = false;

    /**
     * ラベルテキストを設定 ( カード番号 )
     */
    public String labelCardNo = "カード番号";

    /**
     * ラベルテキストを設定 ( 有効期限 )
     */
    public String labelExpire = "有効期限";

    /**
     * ラベルテキストを設定 ( セキュリティコード )
     */
    public String labelCvc = "セキュリティコード";

    /**
     * ラベルテキストを設定 ( カード名義人名 )
     */
    public String labelHolderName = "カード名義人";

    /**
     * ラベルテキストを設定 ( お支払い方法 )
     */
    public String labelPaymentMethod = "お支払方法";

    /**
     * プレースホルダーを設定 ( カード番号 )
     */
    public String placeCardNo = "1234 5678 9012 3456";

    /**
     * プレースホルダーを設定 ( 有効期限 [月] )
     */
    public String placeExpireMonth = "01";

    /**
     * プレースホルダーを設定 ( 有効期限 [年] )
     */
    public String placeExpireYear = "25";

    /**
     * プレースホルダーを設定 ( セキュリティコード )
     */
    public String placeCvc = "001";

    /**
     * プレースホルダーを設定 ( カード名義人名 )
     */
    public String placeHolderName = "TARO YAMADA";

    /**
     * フォーム全体の背景色 <br/>
     * 16進数
     * 例 #71f5c4
     */
    public String colorBackground = "";

    /**
     * インプットフィールドの背景色 <br/>
     * 16進数
     * 例 #71f5c4
     */
    public String colorBackgroundInput = "";

    /**
     * インプットの文字色 <br/>
     * 16進数
     * 例 #71f5c4
     */
    public String colorText = "";

    /**
     * ラベルの文字色 <br/>
     * 16進数
     * 例 #71f5c4
     */
    public String colorLabelText = "";

    /**
     * インプットのボーダーの色 <br/>
     * 16進数
     * 例 #71f5c4
     */
    public String colorBorder = "";

    /**
     * フォントの種類
     */
    public Typeface fontFamily = null;
}
