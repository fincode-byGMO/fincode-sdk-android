package views;

import android.content.Context;
import android.media.Image;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.CardNumberInputFieldVerticalBinding;

public class CardNumberInputFieldView extends LinearLayout {

    public CardNumberInputFieldVerticalBinding cardNumberBinding;
    private ImageView imageView;

    private int cardNumberOne;
    private int cardNumberTwo;
    private CardBrandType cardBrandType;
    private int sizeCount;

    public enum CardBrandType{
        VISA,
        MASTER,
        JCB,
        DINERS,
        AMEX,
        NONE
    }

    public CardNumberInputFieldView(@NonNull Context context) {
        super(context);
    }

    public CardNumberInputFieldView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardNumberInputFieldView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.card_number_input_field_layout, this, false);
        addView(view);
        cardNumberBinding = CardNumberInputFieldVerticalBinding.inflate(LayoutInflater.from(getContext()), this);

        cardNumberBinding.cardNumber.addTextChangedListener(
            new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable.length() != 0) {
                        cardNumberBinding.cardImage.setVisibility(INVISIBLE);
                    } else {
                        cardNumberOne = Integer.parseInt(editable.toString().substring(0, 1));
                        cardNumberTwo = Integer.parseInt(editable.toString().substring(1, 2));
                        cardNumberBinding.cardImage.setVisibility(VISIBLE);
                        setImageView();
                    }
                }
            }
        );
    }

    public void setImageView(){
        switch (cardNumberOne) {
            case 4:
                cardNumberBinding.cardImage.setImageResource(R.drawable.visa);
                cardBrandType = CardBrandType.VISA;
                break;
            case 5:
                if (cardNumberTwo == 1 || cardNumberTwo == 2 || cardNumberTwo == 3
                        || cardNumberTwo == 4 || cardNumberTwo == 5) {
                    cardNumberBinding.cardImage.setImageResource(R.drawable.master);
                    cardBrandType = CardBrandType.MASTER;
                }
                cardNumberBinding.cardImage.setImageResource(R.drawable.master);
                break;
            case 2:
                if (cardNumberTwo == 2 || cardNumberTwo == 3 || cardNumberTwo == 4
                        || cardNumberTwo == 5 || cardNumberTwo == 6 || cardNumberTwo == 7) {
                    cardNumberBinding.cardImage.setImageResource(R.drawable.master);
                    cardBrandType = CardBrandType.MASTER;
                }
                break;
            case 3:
                if (cardNumberTwo == 5) {
                    cardNumberBinding.cardImage.setImageResource(R.drawable.jcb);
                    cardBrandType = CardBrandType.JCB;
                } else if (cardNumberTwo == 0 || cardNumberTwo == 6 || cardNumberTwo == 8 || cardNumberTwo == 9){
                    cardNumberBinding.cardImage.setImageResource(R.drawable.diners);
                    cardBrandType = CardBrandType.DINERS;
                }
                break;
            default:
                cardNumberBinding.cardImage.setVisibility(INVISIBLE);
                cardBrandType = CardBrandType.NONE;
        }
    }

    public void count(){
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
        }
    }

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
