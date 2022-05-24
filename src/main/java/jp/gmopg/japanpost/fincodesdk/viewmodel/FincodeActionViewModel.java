package jp.gmopg.japanpost.fincodesdk.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

/**
 * Created by a.nakajima on 2022/05/22.
 */
public class FincodeActionViewModel {

    public void execute(View view) {
        //FincodeViewModelHolder.getInstance().getDataViewModel().setCardNumber("★");
    }

    public void onTextChangedForCardNo(CharSequence s, int start, int before, int count) {

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
}
