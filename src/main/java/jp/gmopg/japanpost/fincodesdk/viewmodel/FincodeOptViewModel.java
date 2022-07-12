package jp.gmopg.japanpost.fincodesdk.viewmodel;

import android.graphics.Typeface;

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
public class FincodeOptViewModel extends FincodeNotifyCallbacks {

    private boolean isHeadingVisibility = true;
    private boolean isDynamicLogDisplayVisibility = true;
    private boolean isHolderNameVisibility = true;
    private boolean isPayTimesVisibility = true;

    private String labelCardNo = "カード番号";
    private String labelExpire = "有効期限";
    private String labelCvc = "セキュリティコード";
    private String labelHolderName = "カード名義人";
    private String labelPaymentMethod = "お支払方法";

    private String placeCardNo = "1234 5678 9012 3456";
    private String placeExpireMonth = "01";
    private String placeExpireYear = "25";
    private String placeCvc = "001";
    private String placeHolderName = "TARO YAMADA";

    private String colorBackground = "";
    private String colorBackgroundInput = "";
    private String colorText = "";
    private String colorLabelText = "";
    private String colorBorder = "";
    private Typeface fontFamily = null;

    @Bindable
    public boolean getIsHeadingVisibility() {
        return this.isHeadingVisibility;
    }

    public void setIsHeadingVisibility(boolean headingVisibility) {
        this.isHeadingVisibility = headingVisibility;
        notifyPropertyChanged(BR.isHeadingVisibility);
    }

    @Bindable
    public boolean getIsDynamicLogDisplayVisibility() {
        return isDynamicLogDisplayVisibility;
    }

    public void setIsDynamicLogDisplayVisibility(boolean dynamicLogDisplayVisibility) {
        isDynamicLogDisplayVisibility = dynamicLogDisplayVisibility;
        notifyPropertyChanged(BR.isDynamicLogDisplayVisibility);
    }

    @Bindable
    public boolean getIsHolderNameVisibility() {
        return isHolderNameVisibility;
    }

    public void setIsHolderNameVisibility(boolean holderNameVisibility) {
        isHolderNameVisibility = holderNameVisibility;
        notifyPropertyChanged(BR.isHolderNameVisibility);
    }

    @Bindable
    public boolean getIsPayTimesVisibility() {
        return isPayTimesVisibility;
    }

    public void setIsPayTimesVisibility(boolean payTimesVisibility) {
        isPayTimesVisibility = payTimesVisibility;
        notifyPropertyChanged(BR.isPayTimesVisibility);
    }

    @Bindable
    public String getLabelCardNo() {
        return labelCardNo;
    }

    public void setLabelCardNo(String labelCardNo) {
        this.labelCardNo = labelCardNo;
        notifyPropertyChanged(BR.labelCardNo);
    }

    @Bindable
    public String getLabelExpire() {
        return labelExpire;
    }

    public void setLabelExpire(String labelExpire) {
        this.labelExpire = labelExpire;
        notifyPropertyChanged(BR.labelExpire);
    }

    @Bindable
    public String getLabelCvc() {
        return labelCvc;
    }

    public void setLabelCvc(String labelCvc) {
        this.labelCvc = labelCvc;
        notifyPropertyChanged(BR.labelCvc);
    }

    @Bindable
    public String getLabelHolderName() {
        return labelHolderName;
    }

    public void setLabelHolderName(String labelHolderName) {
        this.labelHolderName = labelHolderName;
        notifyPropertyChanged(BR.labelHolderName);
    }

    @Bindable
    public String getLabelPaymentMethod() {
        return labelPaymentMethod;
    }

    public void setLabelPaymentMethod(String labelPaymentMethod) {
        this.labelPaymentMethod = labelPaymentMethod;
        notifyPropertyChanged(BR.labelPaymentMethod);
    }

    @Bindable
    public String getPlaceCardNo() {
        return placeCardNo;
    }

    public void setPlaceCardNo(String placeCardNo) {
        this.placeCardNo = placeCardNo;
        notifyPropertyChanged(BR.placeCardNo);
    }

    @Bindable
    public String getPlaceExpireMonth() {
        return placeExpireMonth;
    }

    public void setPlaceExpireMonth(String placeExpireMonth) {
        this.placeExpireMonth = placeExpireMonth;
        notifyPropertyChanged(BR.placeExpireMonth);
    }

    @Bindable
    public String getPlaceExpireYear() {
        return placeExpireYear;
    }

    public void setPlaceExpireYear(String placeExpireYear) {
        this.placeExpireYear = placeExpireYear;
        notifyPropertyChanged(BR.placeExpireYear);
    }

    @Bindable
    public String getPlaceCvc() {
        return placeCvc;
    }

    public void setPlaceCvc(String placeCvc) {
        this.placeCvc = placeCvc;
        notifyPropertyChanged(BR.placeCvc);
    }

    @Bindable
    public String getPlaceHolderName() {
        return placeHolderName;
    }

    public void setPlaceHolderName(String placeHolderName) {
        this.placeHolderName = placeHolderName;
        notifyPropertyChanged(BR.placeHolderName);
    }

    @Bindable
    public String getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(String colorBackground) {
        this.colorBackground = colorBackground;
        notifyPropertyChanged(BR.colorBackground);
    }

    @Bindable
    public String getColorBackgroundInput() {
        return colorBackgroundInput;
    }

    public void setColorBackgroundInput(String colorBackgroundInput) {
        this.colorBackgroundInput = colorBackgroundInput;
        notifyPropertyChanged(BR.colorBackgroundInput);
    }

    @Bindable
    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
        notifyPropertyChanged(BR.colorText);
    }

    @Bindable
    public String getColorLabelText() {
        return colorLabelText;
    }

    public void setColorLabelText(String colorLabelText) {
        this.colorLabelText = colorLabelText;
        notifyPropertyChanged(BR.colorLabelText);
    }

    @Bindable
    public String getColorBorder() {
        return colorBorder;
    }

    public void setColorBorder(String colorBorder) {
        this.colorBorder = colorBorder;
        notifyPropertyChanged(BR.colorBorder);
    }

    @Bindable
    public Typeface getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(Typeface fontFamily) {
        this.fontFamily = fontFamily;
        notifyPropertyChanged(BR.fontFamily);
    }
}
