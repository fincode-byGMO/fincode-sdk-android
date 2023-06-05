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

    private final boolean headingHidden;
    private final boolean dynamicLogDisplay;
    private final boolean holderNameHidden;
    private final boolean payTimesHidden;
    private final String labelCardNo;
    private final String labelExpire;
    private final String labelCvc;
    private final String labelHolderName;
    private final String labelPaymentMethod;
    private final String placeCardNo;
    private final String placeExpireMonth;
    private final String placeExpireYear;
    private final String placeCvc;
    private final String placeHolderName;
    private final String colorBackground;
    private final String colorBackgroundInput;
    private final String colorText;
    private final String colorLabelText;
    private final String colorBorder;


    public FincodeCommon(@NonNull Context context, @Nullable AttributeSet attrs, int layoutId) {
        super(context, attrs);

        this.context = context;
        this.attrs = attrs;
        this.layoutId = layoutId;

        FincodeViewModelHolder.getInstance().init();
        FincodeViewModelHolder.getInstance().getDataViewModel().setIsDirection(LayoutUtil.isVertical(layoutId));

        ResourceUtil.replaceFrameBackground(getContext(),OptUtil.colorBackgroundInput(context, attrs, layoutId, ""));
        ResourceUtil.replaceFrameBorder(getContext(), OptUtil.colorBorder(context, attrs, layoutId, ""));

        headingHidden = OptUtil.headingHidden(context, attrs, layoutId, false);
        dynamicLogDisplay = OptUtil.dynamicLogDisplay(context, attrs, layoutId, false);
        holderNameHidden = OptUtil.holderNameHidden(context, attrs, layoutId, false);
        payTimesHidden = OptUtil.payTimesHidden(context, attrs, layoutId, false);
        labelCardNo = OptUtil.labelCardNo(context, attrs, layoutId, "カード番号");
        labelExpire = OptUtil.labelExpire(context, attrs, layoutId, "有効期限");
        labelCvc = OptUtil.labelCvc(context, attrs, layoutId, "セキュリティコード");
        labelHolderName = OptUtil.labelHolderName(context, attrs, layoutId, "カード名義人");
        labelPaymentMethod = OptUtil.labelPaymentMethod(context, attrs, layoutId, "お支払方法");
        placeCardNo = OptUtil.placeCardNo(context, attrs, layoutId, "1234 5678 9012 3456");
        placeExpireMonth = OptUtil.placeExpireMonth(context, attrs, layoutId, "01");
        placeExpireYear = OptUtil.placeExpireYear(context, attrs, layoutId, "25");
        placeCvc = OptUtil.placeCvc(context, attrs, layoutId, "001");
        placeHolderName = OptUtil.placeHolderName(context, attrs, layoutId, "TARO YAMADA");
        colorBackground = OptUtil.colorBackground(context, attrs, layoutId, "");
        colorBackgroundInput = OptUtil.colorBackgroundInput(context, attrs, layoutId, "");
        colorText = OptUtil.colorText(context, attrs, layoutId, "");
        colorLabelText = OptUtil.colorLabelText(context, attrs, layoutId, "");
        colorBorder = OptUtil.colorBorder(context, attrs, layoutId, "");

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

        vm.setIsHeadingVisibility(headingHidden);
        vm.setIsDynamicLogDisplayVisibility(dynamicLogDisplay);
        vm.setIsHolderNameVisibility(holderNameHidden);

        if(type == SubmitButtonType.PAYMENT) {
            vm.setIsPayTimesVisibility(payTimesHidden);
        } else {
            vm.setIsPayTimesVisibility(true);
        }

        vm.setLabelCardNo(labelCardNo);
        vm.setLabelExpire(labelExpire);
        vm.setLabelCvc(labelCvc);
        vm.setLabelHolderName(labelHolderName);
        vm.setLabelPaymentMethod(labelPaymentMethod);
        vm.setPlaceCardNo(placeCardNo);
        vm.setPlaceExpireMonth(placeExpireMonth);
        vm.setPlaceExpireYear(placeExpireYear);
        vm.setPlaceCvc(placeCvc);
        vm.setPlaceHolderName(placeHolderName);

        vm.setColorBackground(colorBackground);
        vm.setColorBackgroundInput(colorBackgroundInput);
        vm.setColorText(colorText);
        vm.setColorLabelText(colorLabelText);
        vm.setColorBorder(colorBorder);
//        vm.setFontFamily(OptUtil.fontFamily(context, attrs, layoutId, ""));
    }

    abstract void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder);

    /** 見出しの表示・非表示を設定 */
    public void headingHidden(boolean value) {
        FincodeViewModelHolder.getInstance().getOptViewModel().setIsHeadingVisibility(value);
    }

    /** ブランド画像 動的切り替えの表示・非表示を設定 */
    public void dynamicLogDisplay(boolean value) {
        FincodeViewModelHolder.getInstance().getOptViewModel().setIsDynamicLogDisplayVisibility(value);
    }

    /** 名義人名の表示・非表示を設定 */
    public void holderNameHidden(boolean value) {
        FincodeViewModelHolder.getInstance().getOptViewModel().setIsHolderNameVisibility(value);
    }

    /** お支払い回数の表示・非表示を設定 */
    public void payTimesHidden(boolean value, SubmitButtonType type) {
        if(type == SubmitButtonType.PAYMENT) {
            FincodeViewModelHolder.getInstance().getOptViewModel().setIsPayTimesVisibility(value);
        } else {
            FincodeViewModelHolder.getInstance().getOptViewModel().setIsPayTimesVisibility(true);
        }
    }
}
