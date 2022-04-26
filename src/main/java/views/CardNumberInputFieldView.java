package views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.databinding.CardNumberInputFieldVerticalBinding;

public class CardNumberInputFieldView extends ConstraintLayout {

    public CardNumberInputFieldVerticalBinding cardNumberBinding;

    public CardNumberInputFieldView(@NonNull Context context) {
        super(context);
    }

    public CardNumberInputFieldView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardNumberInputFieldView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(getContext(), R.layout.card_number_input_field_vertical, this);
        LayoutInflater inflater = LayoutInflater.from(view.getContext());
        cardNumberBinding = CardNumberInputFieldVerticalBinding.inflate(inflater);
        OnClickCardNumber();
    }

    public void OnClickCardNumber(){
        if (cardNumberBinding.cardNumber.getText().length() == 0)
            cardNumberBinding.cardNumber.setBackgroundResource(R.drawable.shape_input_field_error);
            cardNumberBinding.cardNumberError.setVisibility(VISIBLE);
    }
}
