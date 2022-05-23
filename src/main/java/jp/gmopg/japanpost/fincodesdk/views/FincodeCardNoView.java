package jp.gmopg.japanpost.fincodesdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModelProvider;
import jp.gmopg.japanpost.fincodesdk.util.CardBrandType;

/**
 * Created by a.nakajima on 2022/05/19.
 */
class FincodeCardNoView extends LinearLayout/*, ComponentImpl*/ {

    private String cardNumber;
    private int sizeCount;
    private CardBrandType cardBrandType = CardBrandType.NONE;
    private boolean focus = false;
    private String value = "";
    private int count;

    private String oneCharacters;
    private String twoCharacters;
    private String threeCharacters;
    private String fourCharacters;
    private String strarray[];

    private InputMethodManager mInputMethodManager;

    public FincodeCardNoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
