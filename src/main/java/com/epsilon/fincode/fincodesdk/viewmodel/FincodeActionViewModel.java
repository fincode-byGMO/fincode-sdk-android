package com.epsilon.fincode.fincodesdk.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;
import com.epsilon.fincode.fincodesdk.api.FincodeCallback;
import com.epsilon.fincode.fincodesdk.config.DataHolder;
import com.epsilon.fincode.fincodesdk.config.FincodeCardRegisterConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodeCardUpdateConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodePaymentConfiguration;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardRegisterRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardRegisterResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardUpdateRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardUpdateResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentRequest;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentResponse;
import com.epsilon.fincode.fincodesdk.enumeration.MethodType;
import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;
import com.epsilon.fincode.fincodesdk.usecase.CardOperateUseCase;
import com.epsilon.fincode.fincodesdk.usecase.PaymentUseCase;
import com.epsilon.fincode.fincodesdk.validatier.FincodeCardNoValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeExpireMonthValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeExpireYearValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeHolderNameValidatier;
import com.epsilon.fincode.fincodesdk.validatier.FincodeSecurityCodeValidatier;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class FincodeActionViewModel extends ViewModel {

    public void execute(SubmitButtonType type) {
        switch (type){
            case PAYMENT:
                if(!isError()) {
                    payment();
                }
                break;
            case CARD_REGISTER:
                if(!isError()) {
                    cardRegister();
                }
                break;
            case CARD_UPDATE:
                if(!isErrorForCardUpdate()) {
                    cardUpdate();
                }
                break;
        }
    }

    private boolean isError() {
        boolean result = false;

        FincodeDataViewModel vm = FincodeViewModelHolder.getInstance().getDataViewModel();
        if(vm.getRadioSelect() == false) {
            result = result | FincodeCardNoValidatier.validate(vm);
            result = result | FincodeExpireMonthValidatier.validate(vm);
            result = result | FincodeExpireYearValidatier.validate(vm);
            result = result | FincodeHolderNameValidatier.validate(vm);
            result = result | FincodeSecurityCodeValidatier.validate(vm);
        }

        return result;
    }

    private boolean isErrorForCardUpdate() {
        boolean result = false;
        FincodeDataViewModel vm = FincodeViewModelHolder.getInstance().getDataViewModel();
        result = result | FincodeExpireMonthValidatier.validate(vm);
        result = result | FincodeExpireYearValidatier.validate(vm);
        result = result | FincodeHolderNameValidatier.validate(vm);
        result = result | FincodeSecurityCodeValidatier.validate(vm);

        return result;
    }

    // ----- card register -----

    private void cardRegister() {
        FincodeCardRegisterConfiguration config = DataHolder.getInstance().getCardRegisterConfig();
        FincodeDataViewModel vm = FincodeViewModelHolder.getInstance().getDataViewModel();

        FincodeCardRegisterRequest req = new FincodeCardRegisterRequest();
        req.setDefaltFlag(config.defaultFlg.getValue());
        req.setCardNo(vm.cardNoPart.getValue().replace(" ", ""));
        req.setExpire(vm.expireYearPart.getValue() + vm.expireMonthPart.getValue());
        if(!vm.securityCodePart.getValue().isEmpty()) {
            req.setSecurityCode(vm.securityCodePart.getValue());
        }
        if(!vm.holderNamePart.getValue().isEmpty()) {
            req.setHolderName(vm.holderNamePart.getValue());
        }

        CardOperateUseCase useCase = new CardOperateUseCase();
        useCase.cardRegister(config.customerId, req, new FincodeCallback<FincodeCardRegisterResponse>() {
            @Override
            public void onResponse(FincodeCardRegisterResponse response) {
                DataHolder.getInstance().getCallbackForCardRegister().onResponse(response);
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                DataHolder.getInstance().getCallbackForCardRegister().onFailure(errorInfo);
            }
        });
    }

    // ----- card update -----

    private void cardUpdate() {
        FincodeCardUpdateConfiguration config = DataHolder.getInstance().getCardUpdateConfig();
        FincodeDataViewModel vm = FincodeViewModelHolder.getInstance().getDataViewModel();

        FincodeCardUpdateRequest req = new FincodeCardUpdateRequest();
        if(config.defaultFlg != null) {
            req.setDefaltFlag(config.defaultFlg.getValue());
        }
        if(!vm.expireYearPart.getValue().isEmpty() && !vm.expireMonthPart.getValue().isEmpty()) {
            req.setExpire(vm.expireYearPart.getValue() + vm.expireMonthPart.getValue());
        }
        if(!vm.securityCodePart.getValue().isEmpty()) {
            req.setSecurityCode(vm.securityCodePart.getValue());
        }
        if(!vm.holderNamePart.getValue().isEmpty()) {
            req.setHolderName(vm.holderNamePart.getValue());
        }

        CardOperateUseCase useCase = new CardOperateUseCase();
        useCase.cardUpdate(config.customerId, config.cardId, req, new FincodeCallback<FincodeCardUpdateResponse>() {
            @Override
            public void onResponse(FincodeCardUpdateResponse response) {
                DataHolder.getInstance().getCallbackForCardUpdate().onResponse(response);
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                DataHolder.getInstance().getCallbackForCardUpdate().onFailure(errorInfo);
            }
        });
    }

    // ----- payment -----

    private void payment() {
        FincodePaymentConfiguration config = DataHolder.getInstance().getPaymentConfig();
        FincodeDataViewModel vm = FincodeViewModelHolder.getInstance().getDataViewModel();

        FincodePaymentRequest request;
        if(vm.getRadioSelect() == false) {
            // input card info
            request = directRequest(config, vm);
        } else {
            // select card info
            request = customerIdRequest(config, vm);
        }

        PaymentUseCase paymentUseCase = new PaymentUseCase();
        paymentUseCase.payment(config.id, request, new FincodeCallback<FincodePaymentResponse>() {
            @Override
            public void onResponse(FincodePaymentResponse response) {
                DataHolder.getInstance().getCallbackForPayment().onResponse(response);
            }

            @Override
            public void onFailure(FincodeErrorResponse errorInfo) {
                DataHolder.getInstance().getCallbackForPayment().onFailure(errorInfo);
            }
        });
    }

    private FincodePaymentRequest directRequest(FincodePaymentConfiguration config, FincodeDataViewModel vm) {
        FincodePaymentRequest req = new FincodePaymentRequest();

        req.setPayType(config.payType);
        req.setAccessId(config.accessId);
        req.setOrderId(config.id);

        if(vm.getRadioSelect() == false && !vm.cardNoPart.getValue().isEmpty()) {
            req.setCardNo(vm.cardNoPart.getValue().replace(" ", ""));
        }

        req.setExpire(vm.expireYearPart.getValue() + vm.expireMonthPart.getValue());

        switch (vm.payTimesPart.getValue()){
            case "一括払い" :
                req.setMethod(MethodType.ONE_TIME.getValue());
                break;
            case "リボ払い":
                req.setMethod(MethodType.REVO.getValue());
                break;
            default:
                // 分割払い
                req.setMethod(MethodType.INSTALLMENT.getValue());
                req.setPayTimes(vm.payTimesPart.getValue());
        }
        if(!vm.securityCodePart.getValue().isEmpty()) {
            req.setSecurityCode(vm.securityCodePart.getValue());
        }
        if(!vm.holderNamePart.getValue().isEmpty()) {
            req.setHolderName(vm.holderNamePart.getValue());
        }

        return req;
    }

    private FincodePaymentRequest customerIdRequest(FincodePaymentConfiguration config, FincodeDataViewModel vm) {
        FincodePaymentRequest req = new FincodePaymentRequest();

        req.setPayType(config.payType);
        req.setAccessId(config.accessId);
        req.setOrderId(config.id);
        req.setCustomerId(config.customerId);
        req.setCardId(vm.selectCardNoPart.getValue());

        switch (vm.payTimesPart.getValue()){
            case "一括払い" :
                req.setMethod(MethodType.ONE_TIME.getValue());
                break;
            case "リボ払い":
                req.setMethod(MethodType.REVO.getValue());
                break;
            default:
                // 分割払い
                req.setMethod(MethodType.INSTALLMENT.getValue());
                req.setPayTimes(vm.payTimesPart.getValue());
        }
//        if(!vm.securityCodePart.getValue().isEmpty()) {
//            req.setSecurityCode(vm.securityCodePart.getValue());
//        }
//        if(!vm.holderNamePart.getValue().isEmpty()) {
//            req.setHolderName(vm.holderNamePart.getValue());
//        }

        return req;
    }
}
