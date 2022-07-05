package jp.gmopg.japanpost.fincodesdk.usecase;

import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.config.DataHolder;
import jp.gmopg.japanpost.fincodesdk.config.FincodeConfiguration;
import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class BaseUseCase {

    protected HashMap<String, String> getHeader() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", authStr(DataHolder.getInstance().getConfig()));

        return map;
    }

    protected void showProgress(){
        FincodeViewModelHolder.getInstance().getDataViewModel().setIsProgressBar(true);
    }
    protected void hideProgress(){
        FincodeViewModelHolder.getInstance().getDataViewModel().setIsProgressBar(false);
    }

    private String authStr(FincodeConfiguration config) {
        switch (config.authorization) {
            case BASIC:
                return "Basic " + config.publicKey;
            case BEARER:
                return "Bearer " + config.publicKey;
            default:
                return "";
        }
    }
}
