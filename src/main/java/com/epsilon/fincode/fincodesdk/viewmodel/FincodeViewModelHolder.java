package com.epsilon.fincode.fincodesdk.viewmodel;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class FincodeViewModelHolder {

    private static FincodeViewModelHolder fincodeViewModelHolder;

    private FincodeActionViewModel action;
    private FincodeDataViewModel data;
    private FincodeOptViewModel opt;

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

    public FincodeOptViewModel getOptViewModel() {
        return opt;
    }

    public void init() {
        action = new FincodeActionViewModel();
        data = new FincodeDataViewModel();
        opt = new FincodeOptViewModel();
    }
}
