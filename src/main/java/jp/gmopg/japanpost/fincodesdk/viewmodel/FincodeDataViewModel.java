package jp.gmopg.japanpost.fincodesdk.viewmodel;

import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeCardNoPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeExpireMonthPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeExpireYearPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeHolderNamePart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodePayTimesPart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeSecurityCodePart;
import jp.gmopg.japanpost.fincodesdk.viewmodel.partdata.FincodeSelectCardNoPart;


/**
 * Created by a.nakajima on 2022/05/19.
 */
public class FincodeDataViewModel {

    public FincodeDataViewModel() { }

    public FincodeCardNoPart cardNoPart = new FincodeCardNoPart();
    public FincodeExpireMonthPart expireMonthPart = new FincodeExpireMonthPart();
    public FincodeExpireYearPart expireYearPart = new FincodeExpireYearPart();
    public FincodeHolderNamePart holderNamePart = new FincodeHolderNamePart();
    public FincodePayTimesPart payTimesPart = new FincodePayTimesPart();
    public FincodeSecurityCodePart securityCodePart = new FincodeSecurityCodePart();
    public FincodeSelectCardNoPart selectCardNoPart = new FincodeSelectCardNoPart();
}
