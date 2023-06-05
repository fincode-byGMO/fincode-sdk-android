package com.epsilon.fincode.fincodesdk.viewmodel.partdata;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;
import com.epsilon.fincode.fincodesdk.entities.SelectCardNoItem;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardInfo;
import com.epsilon.fincode.fincodesdk.entities.api.FincodeCardInfoListResponse;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSelectCardNoPart extends FincodeBasePart {

    public ArrayList<SelectCardNoItem> selectCardNoList = new ArrayList<SelectCardNoItem>();

    public void setSelectCardNoList(List<FincodeCardInfo> list) {
        if(list == null) { return; }

        selectCardNoList.clear();
        for(FincodeCardInfo item : list) {
            selectCardNoList.add(new SelectCardNoItem(item.getCardNo(), item.getCardId(), item.getCardBrand(), item.getExpire()));
        }
    }

    public FincodeSelectCardNoPart(){
        selectCardNoList.add(new SelectCardNoItem("", "", "",""));
    }

}
