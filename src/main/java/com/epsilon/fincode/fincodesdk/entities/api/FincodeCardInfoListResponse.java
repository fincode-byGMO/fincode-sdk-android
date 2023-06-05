package com.epsilon.fincode.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fincode on 2022/06/13.
 */
public class FincodeCardInfoListResponse {

    @SerializedName("list")
    public List<FincodeCardInfo> cardInfoList;

}
