package views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.StringJoiner;
import java.util.regex.Pattern;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.CardNumberInputFieldVerticalBinding;

public class CardNumberInputFieldView extends LinearLayout {

//    public CardNumberInputFieldVerticalBinding cardNumberBinding;
    private CardNumberTextView cardNumberTextView;

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

    public enum CardBrandType{
        VISA,
        MASTER,
        JCB,
        DINERS,
        AMEX,
        NONE
    }

    public CardNumberInputFieldView(Context context) {
        super(context);
    }

    public CardNumberInputFieldView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardNumberInputFieldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        cardNumberTextView = new CardNumberTextView(getContext());

        View view = LayoutInflater.from(getContext()).inflate(R.layout.card_number_input_field_layout, this, false);
        addView(view);
//        cardNumberBinding = CardNumberInputFieldVerticalBinding.inflate(LayoutInflater.from(getContext()), this);

//        cardNumberBinding.cardNumber.addTextChangedListener(
//            new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                }
//
//                @TargetApi(Build.VERSION_CODES.N)
//                @Override
//                public void afterTextChanged(Editable editable) {
//                    // 未入力時
//                    if (editable.length() == 0) {
//                        cardNumberBinding.cardImage.setVisibility(INVISIBLE);
//                        return;
//                    }
//
//                    value = editable.toString();
//                    count = value.length();
//
//                    String noSpaceValue = value.replace(" ", "");
//
//                    // 先頭文字によって画像を変更
//                    String[] strArray = noSpaceValue.split("");
//                    cardNumber = "";
//                    for(String s : strArray){
//                        cardNumberBinding.cardImage.setVisibility(VISIBLE);
//                        cardNumber = cardNumber + s;
//                        setCardNumberImage(cardNumber);
//                    }
//
//                    String noSpaceValue = value.toString().replace(" ", "");
//                    focusOutCount();
//
//                    if (cardBrandType == CardNumberInputFieldView.CardBrandType.DINERS){
//                        CardNumberDiners(noSpaceValue);
//                    } else if (cardBrandType == CardNumberInputFieldView.CardBrandType.AMEX){
//                        CardNumberAmex(noSpaceValue);
//                    } else {
//                        CardNumberOther(noSpaceValue);
//                    }
//
//                    StringJoiner sj = new StringJoiner(" ");
//
//                    for (String s : strarray)
//                    {
//                        sj.add(s);
//                    }
//                    focusInCount();
//                    if (sizeCount == count - 1){
//                        focusOutCount();
//                    }
//                    InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(sizeCount);
//                    cardNumberBinding.cardNumber.setFilters(new InputFilter[]{lengthFilter});
//                }
//            }
//        );

//        cardNumberBinding.cardNumber.setOnFocusChangeListener(
//            new OnFocusChangeListener() {
//                @SuppressLint("NewApi")
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) {
//                    if(hasFocus){
//                        //受け取った時
//                        cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field_onfocus);
//                        value = getWithoutSpace(value);
//                        focusInCount();
//                        // 文字数制限
//                        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(sizeCount);
//                        cardNumberBinding.cardNumber.setFilters(new InputFilter[]{lengthFilter});
//                    }else{
//                        //離れた時
//
//                        String noSpaceValue = value.replace(" ", "");
//                        focusOutCount();
//                        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(sizeCount);
//                        cardNumberBinding.cardNumber.setFilters(new InputFilter[]{lengthFilter});
//
//                        if (0 == noSpaceValue.length()){
//                            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field_error);
//                            cardNumberBinding.cardNumberError.setVisibility(VISIBLE);
//                            cardNumberBinding.cardNumberFormatError.setVisibility(GONE);
//                            return;
//                        } else if (sizeCount != noSpaceValue.length()){
//                            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field_error);
//                            cardNumberBinding.cardNumberError.setVisibility(GONE);
//                            cardNumberBinding.cardNumberFormatError.setVisibility(VISIBLE);
//                            return;
//                        } else {
//                            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field);
//                            cardNumberBinding.cardNumberError.setVisibility(GONE);
//                            cardNumberBinding.cardNumberFormatError.setVisibility(GONE);
//                        }
//
//                        if (cardBrandType == CardNumberInputFieldView.CardBrandType.DINERS){
//                            CardNumberDiners(noSpaceValue);
//                        } else if (cardBrandType == CardNumberInputFieldView.CardBrandType.AMEX){
//                            CardNumberAmex(noSpaceValue);
//                        } else {
//                            CardNumberOther(noSpaceValue);
//                        }
//
//                        StringJoiner sj = new StringJoiner(" ");
//
//                        for (String s : strarray)
//                        {
//                            sj.add(s);
//                        }
//                        cardNumberBinding.cardNumber.setText(sj.toString());
//
//                    }
//                }
//            }
//        );
    }

    public void CardNumberInputView() {
        this.cardNumber = cardNumber;
    }

    private String getWithoutSpace(CharSequence value) {
        return value.toString().replace(" ", "");
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if(focused && direction != 0 ) {
            // 他Viewから自身にフォーカスが移動した場合のみ処理される
            focusInCount();
        } else {
            focusOutCount();
        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
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

    public CardBrandType setImageView(Editable editable){
        // 先頭文字によって画像を変更
        String[] strArray = editable.toString().split("");
        cardNumber = "";
        for(String s : strArray){
//            cardNumberBinding.cardImage.setVisibility(VISIBLE);
            cardNumber = cardNumber + s;
//            setCardNumberImage(cardNumber);
        }
        return cardBrandType;
    }

    /**
     * 先頭文字によってブランド画像を変更
     * @return
     */
//    public void setCardNumberImage(String number){
//        if (Pattern.compile("^4[0-9]{0,16}$").matcher(number).matches()) {
//            cardNumberBinding.cardImage.setImageResource(R.drawable.visa);
//            cardBrandType = CardBrandType.VISA;
//        } else if (Pattern.compile("(^5[1-5][0-9]{0,15}$)|(^2[2-7][0-9]{0,15}$)").matcher(number).matches()) {
//            cardNumberBinding.cardImage.setImageResource(R.drawable.master);
//            cardBrandType = CardBrandType.MASTER;
//        } else if (Pattern.compile("^35[0-9]{0,15}$").matcher(number).matches()) {
//            cardNumberBinding.cardImage.setImageResource(R.drawable.jcb);
//            cardBrandType = CardBrandType.JCB;
//        } else if (Pattern.compile("(^30[0-9]{0,13}$)|(^36[0-9]{0,13}$)|(^38[0-9]{0,13}$)|(^39[0-9]{0,13}$)").matcher(number).matches()) {
//            cardNumberBinding.cardImage.setImageResource(R.drawable.diners);
//            cardBrandType = CardBrandType.DINERS;
//        } else if (Pattern.compile("(^34[0-9]{0,14}$)|(^37[0-9]{0,14}$)").matcher(number).matches()) {
//            cardNumberBinding.cardImage.setImageResource(R.drawable.amex);
//            cardBrandType = CardBrandType.AMEX;
//        } else {
//            cardNumberBinding.cardImage.setVisibility(INVISIBLE);
//            cardBrandType = CardBrandType.NONE;
//        }
//    }

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
                sizeCount = 17;
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

//    public void focusMainLayout() {
//        vMainLayout.requestFocus();
//    }

//    public void OnClickCardNumber(){
//        if (cardNumberBinding.cardNumber.getText().length() == 0) {
//            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field_error);
//            cardNumberBinding.cardNumberError.setVisibility(VISIBLE);
//        } else {
//            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field);
//            cardNumberBinding.cardNumberError.setVisibility(INVISIBLE);
//        }
//    }
}
