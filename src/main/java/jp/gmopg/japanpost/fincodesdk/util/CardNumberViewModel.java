package jp.gmopg.japanpost.fincodesdk.util;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.InverseMethod;
import jp.gmopg.japanpost.fincodesdk.BR;


public class CardNumberViewModel extends BaseObservable {
    // 代入せずにnullでも良いが今回は "" を初期値とする。
    public String formText = "39";

    // フォーム（EditText）の入力値の getter
    @Bindable
    public String getFormText() {
        return formText;
    }

    // フォーム（EditText）の入力値の setter
    public String setFormText(String formText) {
        this.formText = formText;
        // この記述でisButtonEnable()が呼ばれる
//        notifyPropertyChanged(BR.buttonEnable);
        return formText;
    }

    // フォーム（EditText）へのテキスト入力有無で、ボタン活性・非活性を制御するフラグの getter
//    @Bindable
//    public boolean isButtonEnable() {
//        // 入力あり:true  入力なし：false
//        return !TextUtils.isEmpty(formText);
//    }

    @InverseMethod("stringToDate")
    public String dateToString(String value) {
        // Converts long to String.
        String cardNumber = value + "☆";
        return cardNumber;
    }

    public String stringToDate(String value) {
        // Converts 半角スペース区切り追加
        return setFormText(value.replace("☆", ""));
    }
}