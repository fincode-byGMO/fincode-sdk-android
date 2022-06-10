package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;
import jp.gmopg.japanpost.fincodesdk.adapter.CardSelectionListAdapter;
import jp.gmopg.japanpost.fincodesdk.entities.CardInfoItem;
import jp.gmopg.japanpost.fincodesdk.entities.SelectCardNoItem;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSelectCardNoPart extends FincodeBasePart {

    public ArrayList<SelectCardNoItem> selectCardNoList = new ArrayList<SelectCardNoItem>();

    // TODO 動作確認後に削除する
    public FincodeSelectCardNoPart(){
        selectCardNoList.add(new SelectCardNoItem("************3456", "7777", "VISA", "2512"));
        selectCardNoList.add(new SelectCardNoItem("***********2345", "8888", "AMEX", "3012"));
    }

}
