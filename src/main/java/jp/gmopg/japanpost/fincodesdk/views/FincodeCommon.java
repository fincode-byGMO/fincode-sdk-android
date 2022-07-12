package jp.gmopg.japanpost.fincodesdk.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import androidx.databinding.ViewDataBinding;
import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.config.DataHolder;
import jp.gmopg.japanpost.fincodesdk.config.FincodeCardRegisterConfiguration;
import jp.gmopg.japanpost.fincodesdk.config.FincodeCardUpdateConfiguration;
import jp.gmopg.japanpost.fincodesdk.config.FincodeConfiguration;
import jp.gmopg.japanpost.fincodesdk.config.FincodePaymentConfiguration;
import jp.gmopg.japanpost.fincodesdk.config.Options;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardRegisterResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardUpdateResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentResponse;
import jp.gmopg.japanpost.fincodesdk.usecase.CardOperateUseCase;
import jp.gmopg.japanpost.fincodesdk.util.ResourceUtil;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeOptViewModel;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

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
        setOpt(opt);

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

    private void setOpt(Options opt) {

        if(opt == null) {
            return;
        }

        FincodeOptViewModel vm = FincodeViewModelHolder.getInstance().getOptViewModel();

        vm.setIsHeadingVisibility(opt.isHeadingVisibility);
        vm.setIsDynamicLogDisplayVisibility(opt.isDynamicLogDisplayVisibility);
        vm.setIsHolderNameVisibility(opt.isHolderNameVisibility);
        vm.setIsPayTimesVisibility(opt.isPayTimesVisibility);

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
