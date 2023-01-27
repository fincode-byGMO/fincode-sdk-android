package com.epsilon.fincode.fincodesdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import androidx.databinding.ViewDataBinding;

import com.epsilon.fincode.fincodesdk.api.FincodeCallback;
import com.epsilon.fincode.fincodesdk.config.DataHolder;
import com.epsilon.fincode.fincodesdk.config.FincodeCardRegisterConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodeCardUpdateConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodeConfiguration;
import com.epsilon.fincode.fincodesdk.config.FincodePaymentConfiguration;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardInfoListResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardRegisterResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardUpdateResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeErrorResponse;
import com.epsilon.fincode.fincodesdk.entities.api.FincodePaymentResponse;
import com.epsilon.fincode.fincodesdk.enumeration.SubmitButtonType;
import com.epsilon.fincode.fincodesdk.usecase.CardOperateUseCase;
import com.epsilon.fincode.fincodesdk.util.LayoutUtil;
import com.epsilon.fincode.fincodesdk.util.OptUtil;
import com.epsilon.fincode.fincodesdk.util.ResourceUtil;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeOptViewModel;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public abstract class FincodeCommon extends LinearLayout {

    private final Context context;
    private final AttributeSet attrs;
    private final int layoutId;

    public FincodeCommon(@NonNull Context context, @Nullable AttributeSet attrs, int layoutId) {
        super(context, attrs);

        this.context = context;
        this.attrs = attrs;
        this.layoutId = layoutId;

        FincodeViewModelHolder.getInstance().init();
        FincodeViewModelHolder.getInstance().getDataViewModel().setIsDirection(LayoutUtil.isVertical(layoutId));

        ResourceUtil.replaceFrameBackground(getContext(),OptUtil.colorBackgroundInput(context, attrs, layoutId, ""));
        ResourceUtil.replaceFrameBorder(getContext(), OptUtil.colorBorder(context, attrs, layoutId, ""));

        LayoutInflater inflater = LayoutInflater.from(context);
        initBinding(DataBindingUtil.inflate(inflater, layoutId, this, true),
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
//        DataHolder.getInstance().setOptions(opt);

        FincodeViewModelHolder.getInstance().getDataViewModel().setButtonType(config.getSubmitButtonType());
        setOpt(config.getSubmitButtonType());

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

    private void setOpt(SubmitButtonType type) {

        FincodeOptViewModel vm = FincodeViewModelHolder.getInstance().getOptViewModel();

        vm.setIsHeadingVisibility(OptUtil.headingHidden(context, attrs, layoutId, false));
        vm.setIsDynamicLogDisplayVisibility(OptUtil.dynamicLogDisplay(context, attrs, layoutId, false));
        vm.setIsHolderNameVisibility(OptUtil.holderNameHidden(context, attrs, layoutId, false));

        if(type == SubmitButtonType.PAYMENT) {
            vm.setIsPayTimesVisibility(OptUtil.payTimesHidden(context, attrs, layoutId, false));
        } else {
            vm.setIsPayTimesVisibility(true);
        }

        vm.setLabelCardNo(OptUtil.labelCardNo(context, attrs, layoutId, "カード番号"));
        vm.setLabelExpire(OptUtil.labelExpire(context, attrs, layoutId, "有効期限"));
        vm.setLabelCvc(OptUtil.labelCvc(context, attrs, layoutId, "セキュリティコード"));
        vm.setLabelHolderName(OptUtil.labelHolderName(context, attrs, layoutId, "カード名義人"));
        vm.setLabelPaymentMethod(OptUtil.labelPaymentMethod(context, attrs, layoutId, "お支払方法"));
        vm.setPlaceCardNo(OptUtil.placeCardNo(context, attrs, layoutId, "1234 5678 9012 3456"));
        vm.setPlaceExpireMonth(OptUtil.placeExpireMonth(context, attrs, layoutId, "01"));
        vm.setPlaceExpireYear(OptUtil.placeExpireYear(context, attrs, layoutId, "25"));
        vm.setPlaceCvc(OptUtil.placeCvc(context, attrs, layoutId, "001"));
        vm.setPlaceHolderName(OptUtil.placeHolderName(context, attrs, layoutId, "TARO YAMADA"));

        vm.setColorBackground(OptUtil.colorBackground(context, attrs, layoutId, ""));
        vm.setColorBackgroundInput(OptUtil.colorBackgroundInput(context, attrs, layoutId, ""));
        vm.setColorText(OptUtil.colorText(context, attrs, layoutId, ""));
        vm.setColorLabelText(OptUtil.colorLabelText(context, attrs, layoutId, ""));
        vm.setColorBorder(OptUtil.colorBorder(context, attrs, layoutId, ""));
//        vm.setFontFamily(OptUtil.fontFamily(context, attrs, layoutId, ""));
    }

    abstract void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder);

}
