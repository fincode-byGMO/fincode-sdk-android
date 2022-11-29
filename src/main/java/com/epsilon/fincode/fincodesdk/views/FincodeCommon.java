package com.epsilon.fincode.fincodesdk.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import androidx.databinding.ViewDataBinding;
import com.epsilon.fincode.fincodesdk.api.FincodeCallback;
import com.epsilon.fincode.fincodesdk.config.DataHolder;
import com.epsilon.fincode.fincodesdk.config.FincodeCardRegisterConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodeCardUpdateConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodeConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodePaymentConfiguration;
import com.epsilon.fincode.fincodesdk.config.Options;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardInfoListResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardRegisterResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardUpdateResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentResponse;
import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;
import com.epsilon.fincode.fincodesdk.usecase.CardOperateUseCase;
import com.epsilon.fincode.fincodesdk.util.ResourceUtil;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeOptViewModel;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
abstract class FincodeCommon extends LinearLayout {

    private final Options opt;

    protected FincodeCommon(Activity context, int layoutId, ViewGroup replace, Options options, boolean isVertical) {
        super((Context)context);

        opt = options;

        FincodeViewModelHolder.getInstance().init();

        FincodeViewModelHolder.getInstance().getDataViewModel().setIsDirection(isVertical);

        if(opt != null) {
            ResourceUtil.replaceFrameBackground(getContext(), opt.colorBackgroundInput);
            ResourceUtil.replaceFrameBorder(getContext(), opt.colorBorder);
        }

        LayoutInflater inflater = LayoutInflater.from(context);
        initBinding(DataBindingUtil.inflate(inflater, layoutId, replace, true),
                FincodeViewModelHolder.getInstance());
    }

    public void initForPayment(FincodePaymentConfiguration config, FincodeCallback<FincodePaymentResponse> callback) {
        DataHolder.getInstance().setCallbackForPayment(callback);

        initCommon(config);

        getCardInfoList(config);
    }

    public void initForCardRegister(FincodeCardRegisterConfiguration config, FincodeCallback<FincodeCardRegisterResponse> callback) {
        DataHolder.getInstance().setCallbackForCardRegister(callback);

        initCommon(config);
    }

    public void initForCardUpdate(FincodeCardUpdateConfiguration config, FincodeCallback<FincodeCardUpdateResponse> callback) {
        DataHolder.getInstance().setCallbackForCardUpdate(callback);

        initCommon(config);
    }

    private void initCommon(FincodeConfiguration config) {
        DataHolder.getInstance().setConfig(config);
        DataHolder.getInstance().setOptions(opt);

        FincodeViewModelHolder.getInstance().getDataViewModel().setButtonType(config.getSubmitButtonType());
        setOpt(opt, config.getSubmitButtonType());

        FincodeViewModelHolder.getInstance().getDataViewModel().setIsCardListField(false);
        FincodeViewModelHolder.getInstance().getDataViewModel().setRadioSelect(false);
    }

    private void getCardInfoList(FincodeConfiguration config) {

        // set card select list
        if(!config.customerId.isEmpty()) {
            CardOperateUseCase useCase = new CardOperateUseCase();
            useCase.getCardInfoList(config.customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
                @Override
                public void onResponse(FincodeCardInfoListResponse response) {
                    if(response.cardInfoList != null && response.cardInfoList.size() <= 0) {
                        return;
                    }

                    FincodeViewModelHolder.getInstance().getDataViewModel().selectCardNoPart.setSelectCardNoList(response.cardInfoList);
                    FincodeViewModelHolder.getInstance().getDataViewModel().setIsCardListField(true);
                    FincodeViewModelHolder.getInstance().getDataViewModel().setRadioSelect(true);
                }

                @Override
                public void onFailure(FincodeErrorResponse errorInfo) {
                    // do nothing
                }
            });
        }
    }

    private void setOpt(Options opt, SubmitButtonType type) {

        if(opt == null) {
            return;
        }

        FincodeOptViewModel vm = FincodeViewModelHolder.getInstance().getOptViewModel();

        vm.setIsHeadingVisibility(opt.headingHidden);
        vm.setIsDynamicLogDisplayVisibility(opt.dynamicLogDisplay);
        vm.setIsHolderNameVisibility(opt.holderNameHidden);

        if(type == SubmitButtonType.PAYMENT) {
            vm.setIsPayTimesVisibility(opt.payTimesHidden);
        } else {
            vm.setIsPayTimesVisibility(true);
        }

        vm.setLabelCardNo(opt.labelCardNo);
        vm.setLabelExpire(opt.labelExpire);
        vm.setLabelCvc(opt.labelCvc);
        vm.setLabelHolderName(opt.labelHolderName);
        vm.setLabelPaymentMethod(opt.labelPaymentMethod);
        vm.setPlaceCardNo(opt.placeCardNo);
        vm.setPlaceExpireMonth(opt.placeExpireMonth);
        vm.setPlaceExpireYear(opt.placeExpireYear);
        vm.setPlaceCvc(opt.placeCvc);
        vm.setPlaceHolderName(opt.placeHolderName);

        vm.setColorBackground(opt.colorBackground);
        vm.setColorBackgroundInput(opt.colorBackgroundInput);
        vm.setColorText(opt.colorText);
        vm.setColorLabelText(opt.colorLabelText);
        vm.setColorBorder(opt.colorBorder);
        vm.setFontFamily(opt.fontFamily);
    }

    abstract void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder);

}
