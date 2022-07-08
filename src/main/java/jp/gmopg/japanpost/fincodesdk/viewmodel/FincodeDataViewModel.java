package jp.gmopg.japanpost.fincodesdk.viewmodel;

import androidx.databinding.Bindable;
import jp.gmopg.japanpost.fincodesdk.BR;
import jp.gmopg.japanpost.fincodesdk.enumeration.SubmitButtonType;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeCardNoPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeExpireMonthPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeExpireYearPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeHolderNamePart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeNotifyCallbacks;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodePayTimesPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeSecurityCodePart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeSelectCardNoPart;


/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeDataViewModel extends FincodeNotifyCallbacks {

    // false: new card, true: registered card
    private boolean radioSelect = true;
    private boolean isCardListField = false;
    private boolean isProgressBar = false;
    private boolean isDirection = true;
    private SubmitButtonType buttonType = SubmitButtonType.NONE;

    public FincodeCardNoPart cardNoPart = new FincodeCardNoPart();
    public FincodeExpireMonthPart expireMonthPart = new FincodeExpireMonthPart();
    public FincodeExpireYearPart expireYearPart = new FincodeExpireYearPart();
    public FincodeHolderNamePart holderNamePart = new FincodeHolderNamePart();
    public FincodePayTimesPart payTimesPart = new FincodePayTimesPart();
    public FincodeSecurityCodePart securityCodePart = new FincodeSecurityCodePart();
    public FincodeSelectCardNoPart selectCardNoPart = new FincodeSelectCardNoPart();

    private void clearValid() {
        cardNoPart.setIsError(false);
        expireMonthPart.setIsError(false);
        expireYearPart.setIsError(false);
    }

    @Bindable
    public boolean getRadioSelect() {
        return this.radioSelect;
    }

    public void setRadioSelect(boolean radioSelect) {
        this.radioSelect = radioSelect;
        notifyPropertyChanged(BR.radioSelect);

        clearValid();
    }

    @Bindable
    public boolean getIsDirection() {
        return isDirection;
    }

    public void setIsDirection(boolean direction) {
        this.isDirection = direction;
    }

    @Bindable
    public boolean getIsProgressBar() {
        return isProgressBar;
    }

    public void setIsProgressBar(boolean isProgressBar) {
        this.isProgressBar = isProgressBar;
        notifyPropertyChanged(BR.isProgressBar);
    }

    @Bindable
    public SubmitButtonType getButtonType() {
        return buttonType;
    }

    public void setButtonType(SubmitButtonType buttonType) {
        this.buttonType = buttonType;
        notifyPropertyChanged(BR.buttonType);
    }

    @Bindable
    public boolean getIsCardListField() {
        return isCardListField;
    }

    public void setIsCardListField(boolean cardListField) {
        isCardListField = cardListField;
        notifyPropertyChanged(BR.isCardListField);
    }
}
