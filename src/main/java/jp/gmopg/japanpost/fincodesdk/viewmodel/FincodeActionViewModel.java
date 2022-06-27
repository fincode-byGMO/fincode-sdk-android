package jp.gmopg.japanpost.fincodesdk.viewmodel;

import android.view.View;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoRequest;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentRequest;
import jp.gmopg.japanpost.fincodesdk.enumeration.ButtonPressType;
import jp.gmopg.japanpost.fincodesdk.usecase.CardOperateUseCase;
import jp.gmopg.japanpost.fincodesdk.usecase.PaymentUseCase;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class FincodeActionViewModel {

    public void execute(View view) {

        FincodeCardInfoRequest cardInfoRequest = new FincodeCardInfoRequest();
        CardOperateUseCase useCase = new CardOperateUseCase();

        switch (ButtonPressType.getButtonPressType()){
            case PAYMENT:
                FincodePaymentRequest paymentRequest = new FincodePaymentRequest();
                PaymentUseCase paymentUseCase = new PaymentUseCase();
                paymentUseCase.payment("o_nJMBJ6wIQji5bOW7n43jBw", paymentRequest);
                break;
            case CARD_REGISTER:
                useCase.cardRegister("c_HSZkCAxNS2q_7TbLcO9y1A", cardInfoRequest);
                break;
            case CARD_RENEWAL:
                useCase.cardUpdate("c_HSZkCAxNS2q_7TbLcO9y1A", "cs_-d_wxGfqR0itVEh4IPHpOw", cardInfoRequest);
                break;
        }

    }
}
