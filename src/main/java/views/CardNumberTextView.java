package views;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import java.util.StringJoiner;
import java.util.regex.Pattern;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.CardNumberInputFieldVerticalBinding;

public class CardNumberTextView extends EditText {

    public CardNumberInputFieldView cardNumberInputFieldView;
    private CardNumberInputFieldView.CardBrandType cardBrandType = CardNumberInputFieldView.CardBrandType.NONE;
    private int sizeCount;
    private boolean focusInOut = true;

    public CardNumberInputFieldVerticalBinding cardNumberBinding;

    private String oneCharacters;
    private String twoCharacters;
    private String threeCharacters;
    private String fourCharacters;
    private String strarray[];

    public CardNumberTextView(Context context) {
        super(context);
    }

    public CardNumberTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardNumberTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CardNumberTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int setCardEditorActionListener(CardNumberInputFieldView.CardBrandType cardBrandType, Context context) {
        this.cardBrandType = cardBrandType;
//        if (focusInOut){
//            focusInCount();
//        } else {
//            focusOutCount();
//        }
        return sizeCount;
    }

    // 半角スペース
    public Integer getNumberWithoutSpace() throws NumberFormatException {
        String noComma = this.getText().toString().replace(" ", "");
        return Integer.parseInt(noComma);
    }

    public String getWithoutSpace() {
        return this.getText().toString().replace(" ", "");
    }

    private String getWithoutSpace(CharSequence value) {
        return value.toString().replace(" ", "");
    }

    public String getWithSpace() {
        Editable value = this.getText();

        if(value == null || value.toString().isEmpty()) { return ""; }

        String noSpaceValue = value.toString().replace(" ", "");
        // 先頭文字によって画像を変更
        setImageView(noSpaceValue);
        focusOutCount();

        if (cardBrandType == CardNumberInputFieldView.CardBrandType.DINERS){
            CardNumberDiners(noSpaceValue);
        } else if (cardBrandType == CardNumberInputFieldView.CardBrandType.AMEX){
            CardNumberAmex(noSpaceValue);
        } else {
            CardNumberOther(noSpaceValue);
        }

        StringJoiner sj = new StringJoiner(" ");

        for (String s : strarray)
        {
            sj.add(s);
        }

        try {
            // 19桁
            focusInOut = false;
            return sj.toString();
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public void onEditorAction(int actionCode) {
        // ソフトフェアキーボードで入力確定した場合に処理される
        if(actionCode == EditorInfo.IME_ACTION_NEXT) {
            this.setText(getWithSpace());
        }
        super.onEditorAction(actionCode);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if(focused && direction != 0 ) {
            // 他Viewから自身にフォーカスが移動した場合のみ処理される
            focusInCount();
            this.setText(getWithoutSpace());
        } else {
            focusOutCount();
            this.setText(getWithSpace());
        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if(!this.hasFocus()) {
            focusInOut = false;
            return;
        }

        String value = this.getWithoutSpace(text);
        if(sizeCount < value.length()) {
            StringBuilder sb = new StringBuilder(value);
            sb.delete(start, start + lengthAfter);
            setText(sb.toString());
            setSelection(start);
        }
        focusInOut = true;
    }

    private void CardNumberOther(String noSpaceValue) {
        oneCharacters = noSpaceValue.substring(0, 4);
        twoCharacters = noSpaceValue.substring(4, 8);
        threeCharacters = noSpaceValue.substring(8, 12);
        fourCharacters = noSpaceValue.substring(12, 16);

        strarray = new String[]{oneCharacters, twoCharacters, threeCharacters, fourCharacters};
    }

    private void CardNumberDiners(String noSpaceValue){
        oneCharacters = noSpaceValue.substring(0, 4);
        twoCharacters = noSpaceValue.substring(4, 10);
        threeCharacters = noSpaceValue.substring(10, 14);

        strarray = new String[]{oneCharacters, twoCharacters, threeCharacters};
    }

    private void CardNumberAmex(String noSpaceValue){
        oneCharacters = noSpaceValue.substring(0, 4);
        twoCharacters = noSpaceValue.substring(4, 10);
        threeCharacters = noSpaceValue.substring(10, 15);

        strarray = new String[]{oneCharacters, twoCharacters, threeCharacters};
    }


    /**
     * ブランドごとのカード番号文字数
     */
    public void focusInCount(){
        switch (cardBrandType) {
            case VISA:
                sizeCount = 16;
                break;
            case MASTER:
                sizeCount = 16;
                break;
            case JCB:
                sizeCount = 16;
                break;
            case DINERS:
                sizeCount = 14;
                break;
            case AMEX:
                sizeCount = 15;
                break;
            case NONE:
                sizeCount = 16;
                break;
            default:
                sizeCount = 16;
                break;
        }
    }

    /**
     * ブランドごとのカード番号文字数
     */
    public void focusOutCount(){
        switch (cardBrandType) {
            case VISA:
                sizeCount = 19;
                break;
            case MASTER:
                sizeCount = 19;
                break;
            case JCB:
                sizeCount = 19;
                break;
            case DINERS:
                sizeCount = 16;
                break;
            case AMEX:
                sizeCount = 18;
                break;
            case NONE:
                sizeCount = 19;
                break;
            default:
                sizeCount = 19;
                break;
        }
    }

    public CardNumberInputFieldView.CardBrandType setImageView(String editable){
        // 先頭文字によって画像を変更
        String[] strArray = editable.split("");
        String cardNumber = "";
        for(String s : strArray){
            cardNumber = cardNumber + s;
            setCardNumberImage(cardNumber);
        }
        return cardBrandType;
    }

    /**
     * 先頭文字によってブランド画像を変更
     * @return
     */
    public void setCardNumberImage(String number){
        if (Pattern.compile("^4[0-9]{0,16}$").matcher(number).matches()) {
            cardBrandType = CardNumberInputFieldView.CardBrandType.VISA;
        } else if (Pattern.compile("(^5[1-5][0-9]{0,15}$)|(^2[2-7][0-9]{0,15}$)").matcher(number).matches()) {
            cardBrandType = CardNumberInputFieldView.CardBrandType.MASTER;
        } else if (Pattern.compile("^35[0-9]{0,15}$").matcher(number).matches()) {
            cardBrandType = CardNumberInputFieldView.CardBrandType.JCB;
        } else if (Pattern.compile("(^30[0-9]{0,13}$)|(^36[0-9]{0,13}$)|(^38[0-9]{0,13}$)|(^39[0-9]{0,13}$)").matcher(number).matches()) {
            cardBrandType = CardNumberInputFieldView.CardBrandType.DINERS;
        } else if (Pattern.compile("(^34[0-9]{0,14}$)|(^37[0-9]{0,14}$)").matcher(number).matches()) {
            cardBrandType = CardNumberInputFieldView.CardBrandType.AMEX;
        } else {
            cardBrandType = CardNumberInputFieldView.CardBrandType.NONE;
        }
    }
}
