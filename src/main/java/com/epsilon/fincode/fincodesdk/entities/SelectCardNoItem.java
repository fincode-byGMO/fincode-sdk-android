package com.epsilon.fincode.fincodesdk.entities;

import android.media.Image;

import androidx.databinding.Bindable;
import com.epsilon.fincode.fincodesdk.enumeration.CardBrandType;
import com.epsilon.fincode.fincodesdk.viewmodel.partdata.FincodeNotifyCallbacks;

/**
 * Created by a.nakajima on 2022/06/10.
 */
public class SelectCardNoItem extends FincodeNotifyCallbacks {
    private String maskCardNo = "";
    private String cardId = "";
    private CardBrandType cardBrandType = CardBrandType.NONE;
    private String expir = "";
    private String brandName = "";

    public SelectCardNoItem() {
    }

    public SelectCardNoItem(String maskCardNo, String cardId, String brandName, String expir) {
        this.maskCardNo = maskCardNo;
        this.cardId = cardId;
        this.cardBrandType = CardBrandType.typeForName(brandName);
        this.expir = expir;
        this.brandName = brandName;
    }

    @Bindable
    public String getMaskCardNo() {
        return this.maskCardNo;
    }

    public String getCardId() {
        return this.cardId;
    }

    @Bindable
    public int getBrandImage() {
        return cardBrandType.getImage();
    }

    @Bindable
    public String getExpir() {
        return this.expir;
    }

    @Bindable
    public String getBrandName() {
        return this.brandName;
    }
}
