package jp.gmopg.japanpost.fincodesdk.viewmodel.partdata;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;
import jp.gmopg.japanpost.fincodesdk.adapter.CardSelectionListAdapter;
import jp.gmopg.japanpost.fincodesdk.entities.CardInfoItem;

/**
 * Created by a.nakajima on 2022/05/24.
 */
public class FincodeSelectCardNoPart extends FincodeBasePart {

    public ArrayList<CardInfoItem> cardInfoItemsList;
    public List<String> cardNumberList;
    public List<String> expirList;
    public List<String> brandTypeList;

    public FincodeSelectCardNoPart(){

        cardInfoItemsList = new ArrayList<>();

        cardNumberList = CardSelectionListAdapter.getCardNumber();
        expirList = CardSelectionListAdapter.getExpir();
        brandTypeList = CardSelectionListAdapter.getBrandType();

        for (int i = 0; i < cardNumberList.size(); i++){
            CardInfoItem cardInfoItem = new CardInfoItem();
            cardInfoItem.setCardNumber(cardNumberList.get(i));
            cardInfoItem.setExpire(expirList.get(i));
            cardInfoItem.setCardBrand(brandTypeList.get(i));
            cardInfoItemsList.add(cardInfoItem);
        }
    }

    @Bindable
    public ArrayList<CardInfoItem> getCardInfoItemsList(){
        return this.cardInfoItemsList;
    }

    public void setCardInfoItemsList(ArrayList<CardInfoItem> cardInfoItemsList){
        this.cardInfoItemsList = cardInfoItemsList;
        notifyPropertyChanged(BR.cardInfoItemsList);
    }
}
