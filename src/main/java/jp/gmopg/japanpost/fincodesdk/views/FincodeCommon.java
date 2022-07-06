package jp.gmopg.japanpost.fincodesdk.views;

import android.content.Context;
import android.view.LayoutInflater;
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
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardRegisterResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardUpdateResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentResponse;
import jp.gmopg.japanpost.fincodesdk.usecase.CardOperateUseCase;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/05/19.
 */
abstract class FincodeCommon extends LinearLayout {

    public FincodeCommon(Context context, int layoutId) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        initBinding(DataBindingUtil.inflate(inflater, layoutId, this, true),
                    FincodeViewModelHolder.getInstance());
    }

    public void initForPayment(FincodePaymentConfiguration config, Options options, FincodeCallback<FincodePaymentResponse> callback) {
        DataHolder.getInstance().setCallbackForPayment(callback);
        DataHolder.getInstance().setConfig(config);
        DataHolder.getInstance().setOptions(options);
        getCardInfoList(config);
    }

    public void initForCardRegister(FincodeCardRegisterConfiguration config, Options options, FincodeCallback<FincodeCardRegisterResponse> callback) {
        DataHolder.getInstance().setCallbackForCardRegister(callback);
        DataHolder.getInstance().setConfig(config);
        DataHolder.getInstance().setOptions(options);
    }

    public void initForCardUpdate(FincodeCardUpdateConfiguration config, Options options, FincodeCallback<FincodeCardUpdateResponse> callback) {
        DataHolder.getInstance().setCallbackForCardUpdate(callback);
        DataHolder.getInstance().setConfig(config);
        DataHolder.getInstance().setOptions(options);
    }

    private void getCardInfoList(FincodeConfiguration config) {

        // set card select list
        if(!config.customerId.isEmpty()) {
            CardOperateUseCase useCase = new CardOperateUseCase();
            useCase.getCardInfoList(config.customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
                @Override
                public void onResponse(FincodeCardInfoListResponse response) {
                    FincodeViewModelHolder.getInstance().getDataViewModel().selectCardNoPart.setSelectCardNoList(response.cardInfoList);
                }

                @Override
                public void onFailure(FincodeErrorResponse errorInfo) {
                    // do nothing
                }
            });
        } else {
            FincodeViewModelHolder.getInstance().getDataViewModel().setRadioSelect(false);
        }
    }

    abstract void initBinding(ViewDataBinding binding, FincodeViewModelHolder holder);

}
