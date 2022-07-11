package jp.gmopg.japanpost.fincodesdk.config;

import jp.gmopg.japanpost.fincodesdk.api.FincodeCallback;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardRegisterResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardUpdateResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodePaymentResponse;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/07/04.
 */
public class DataHolder {

    private static DataHolder dataHolder;

    private FincodeConfiguration config;
    private Options options;

    private FincodeCallback<FincodePaymentResponse> callbackForPayment;
    private FincodeCallback<FincodeCardRegisterResponse> callbackForCardRegister;
    private FincodeCallback<FincodeCardUpdateResponse> callbackForCardUpdate;

    private DataHolder() {
    }

    public static DataHolder getInstance() {
        if(dataHolder == null) {
            dataHolder = new DataHolder();
        }
        return dataHolder;
    }

    public FincodeConfiguration getConfig() {
        return this.config;
    }

    public void setConfig(FincodeConfiguration config) {
        this.config = config;
    }

    public Options getOptions() {
        return this.options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public FincodePaymentConfiguration getPaymentConfig() {
        if(config instanceof FincodePaymentConfiguration) {
            return (FincodePaymentConfiguration) config;
        } else {
            return null;
        }
    }

    public FincodeCardRegisterConfiguration getCardRegisterConfig() {
        if(config instanceof FincodeCardRegisterConfiguration) {
            return (FincodeCardRegisterConfiguration) config;
        } else {
            return null;
        }
    }

    public FincodeCardUpdateConfiguration getCardUpdateConfig() {
        if(config instanceof FincodeCardUpdateConfiguration) {
            return (FincodeCardUpdateConfiguration) config;
        } else {
            return null;
        }
    }

    public FincodeCallback<FincodePaymentResponse> getCallbackForPayment() {
        return callbackForPayment;
    }

    public void setCallbackForPayment(FincodeCallback<FincodePaymentResponse> callbackForPayment) {
        this.callbackForPayment = callbackForPayment;
    }

    public FincodeCallback<FincodeCardRegisterResponse> getCallbackForCardRegister() {
        return callbackForCardRegister;
    }

    public void setCallbackForCardRegister(FincodeCallback<FincodeCardRegisterResponse> callbackForCardRegister) {
        this.callbackForCardRegister = callbackForCardRegister;
    }

    public FincodeCallback<FincodeCardUpdateResponse> getCallbackForCardUpdate() {
        return callbackForCardUpdate;
    }

    public void setCallbackForCardUpdate(FincodeCallback<FincodeCardUpdateResponse> callbackForCardUpdate) {
        this.callbackForCardUpdate = callbackForCardUpdate;
    }
}
