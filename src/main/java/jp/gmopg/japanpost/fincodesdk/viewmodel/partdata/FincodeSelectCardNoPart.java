package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;
import jp.gmopg.japanpost.fincodesdk.entities.SelectCardNoItem;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSelectCardNoPart extends FincodeBasePart {

    public ArrayList<SelectCardNoItem> selectCardNoList = new ArrayList<SelectCardNoItem>();

    public void setSelectCardNoList(List<FincodeCardInfo> list) {
        if(list == null) { return; }

        for(FincodeCardInfo item : list) {
            selectCardNoList.add(new SelectCardNoItem(item.getCardNo(), item.getCardId(), item.getCardBrand(), item.getExpire()));
        }
    }

    // TODO 動作確認後に削除する
    public FincodeSelectCardNoPart(){
        selectCardNoList.add(new SelectCardNoItem("************3456", "7777", "VISA", "9999"));
    }

}
