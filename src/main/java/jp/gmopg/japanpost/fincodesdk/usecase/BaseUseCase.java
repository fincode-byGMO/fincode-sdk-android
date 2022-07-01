package jp.gmopg.japanpost.fincodesdk.usecase;

import java.util.HashMap;

import jp.gmopg.japanpost.fincodesdk.viewmodel.FincodeViewModelHolder;

/**
 * Created by fincode on 2022/06/13.
 */
public class BaseUseCase {

    protected HashMap<String, String> getHeader() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        // TODO SDKを組み込むアプリ側から貰うように修正する
        map.put("Authorization", "Bearer p_prod_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        return map;
    }

    public boolean showProgress(){
        return FincodeViewModelHolder.getInstance().getDataViewModel().isProgressBar = true;
    }
    public boolean hideProgress(){
        return FincodeViewModelHolder.getInstance().getDataViewModel().isProgressBar = false;
    }
}
