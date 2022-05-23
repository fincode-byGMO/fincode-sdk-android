package jp.gmopg.japanpost.fincodesdk.viewmodel;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class FincodeViewModelHolder {

    private static FincodeViewModelHolder fincodeViewModelHolder;
    private FincodeActionViewModel action = new FincodeActionViewModel();
    private FincodeDataViewModel data = new FincodeDataViewModel();

    private FincodeViewModelHolder() {
    }

    public static FincodeViewModelHolder getInstance() {
        if(fincodeViewModelHolder == null) {
            fincodeViewModelHolder = new FincodeViewModelHolder();
        }
        return fincodeViewModelHolder;
    }

    public FincodeActionViewModel getActionViewModel() {
        return action;
    }

    public FincodeDataViewModel getDataViewModel() {
        return data;
    }
}
