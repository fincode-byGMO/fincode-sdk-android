package jp.gmopg.japanpost.fincodesdk.util;

import android.os.Build;

import java.util.StringJoiner;
import java.util.regex.Pattern;

import androidx.annotation.RequiresApi;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.CardNumberInputFieldVerticalBinding;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class CardNumber extends BaseObservable {

    public CardNumberInputFieldVerticalBinding cardNumberBinding;
    private String cardNumber;
    private String oneCharacters;
    private String twoCharacters;
    private String threeCharacters;
    private String fourCharacters;
    private String strarray[];
    private String noSpaceValue;

    private int sizeCount;

    private CardBrandType cardBrandType = CardBrandType.NONE;

    public CardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        cardNumberSpase();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String cardNumberSpase(){

        noSpaceValue = getCardNumber().replace(" ", "");

        // 先頭文字によって画像を変更
        String[] strArray = noSpaceValue.split("");
        cardNumber = "";
        for(String s : strArray){
            cardNumberBinding.cardImage.setVisibility(VISIBLE);
            cardNumber = cardNumber + s;
            setCardNumberImage(cardNumber);
        }
        focusOutCount();

        if (0 == noSpaceValue.length()){
            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field_error);
            cardNumberBinding.cardNumberError.setVisibility(VISIBLE);
            cardNumberBinding.cardNumberFormatError.setVisibility(GONE);
            return noSpaceValue;
        } else if (sizeCount != noSpaceValue.length()){
            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field_error);
            cardNumberBinding.cardNumberError.setVisibility(GONE);
            cardNumberBinding.cardNumberFormatError.setVisibility(VISIBLE);
            return noSpaceValue;
        } else {
            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field);
            cardNumberBinding.cardNumberError.setVisibility(GONE);
            cardNumberBinding.cardNumberFormatError.setVisibility(GONE);
        }

        brandSpace();

        StringJoiner sj = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            sj = new StringJoiner(" ");
        }

        for (String s : strarray)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                sj.add(s);
            }
        }
        return sj.toString();
    }

    public void brandSpace(){
        if (cardBrandType == CardBrandType.DINERS){
            CardNumberDiners(noSpaceValue);
        } else if (cardBrandType == CardBrandType.AMEX){
            CardNumberAmex(noSpaceValue);
        } else {
            CardNumberOther(noSpaceValue);
        }
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
     * 先頭文字によってブランド画像を変更
     * @return
     */
    public void setCardNumberImage(String number){
        if (Pattern.compile("^4[0-9]{0,16}$").matcher(number).matches()) {
            cardNumberBinding.cardImage.setImageResource(R.drawable.visa);
            cardBrandType = CardBrandType.VISA;
        } else if (Pattern.compile("(^5[1-5][0-9]{0,15}$)|(^2[2-7][0-9]{0,15}$)").matcher(number).matches()) {
            cardNumberBinding.cardImage.setImageResource(R.drawable.master);
            cardBrandType = CardBrandType.MASTER;
        } else if (Pattern.compile("^35[0-9]{0,15}$").matcher(number).matches()) {
            cardNumberBinding.cardImage.setImageResource(R.drawable.jcb);
            cardBrandType = CardBrandType.JCB;
        } else if (Pattern.compile("(^30[0-9]{0,13}$)|(^36[0-9]{0,13}$)|(^38[0-9]{0,13}$)|(^39[0-9]{0,13}$)").matcher(number).matches()) {
            cardNumberBinding.cardImage.setImageResource(R.drawable.diners);
            cardBrandType = CardBrandType.DINERS;
        } else if (Pattern.compile("(^34[0-9]{0,14}$)|(^37[0-9]{0,14}$)").matcher(number).matches()) {
            cardNumberBinding.cardImage.setImageResource(R.drawable.amex);
            cardBrandType = CardBrandType.AMEX;
        } else {
            cardNumberBinding.cardImage.setVisibility(INVISIBLE);
            cardBrandType = CardBrandType.NONE;
        }
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


}
