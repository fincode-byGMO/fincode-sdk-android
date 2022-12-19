package com.epsilon.fincode.fincodesdk.usecase;

import java.util.HashMap;

import com.epsilon.fincode.fincodesdk.config.DataHolder;
import com.epsilon.fincode.fincodesdk.config.FincodeConfiguration;
import com.epsilon.fincode.fincodesdk.enumeration.Authorization;
import com.epsilon.fincode.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class BaseUseCase {

    protected HashMap<String, String> getHeader() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", authStr(DataHolder.getInstance().getConfig()));

        String apiVer = DataHolder.getInstance().getConfig().apiVersion;
        if(apiVer != null && !apiVer.isEmpty()) {
            map.put("Api-Version", apiVer);
        }

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
                return Authorization.BASIC.getValue() + " " + config.apiKey;
            case BEARER:
                return Authorization.BEARER.getValue() + " " + config.apiKey;
            default:
                return "";
        }
    }
}
