package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m.sakaida on 2022/10/27.
 */
public class FincodeGetResultResponse {

    @SerializedName("tds2_trans_result")
    private String tdsTransResult;

    @SerializedName("tds2_trans_result_reason")
    private String tdsTransResultReason;

}