package jp.gmopg.japanpost.fincodesdk.entities.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by a.nakajima on 2022/07/14.
 */
public class FincodeErrorInfoList {

    @SerializedName("errors")
    private List<FincodeErrorInfo> list;

    public List<FincodeErrorInfo> getList() {
        return list;
    }

    public void setList(List<FincodeErrorInfo> list) {
        this.list = list;
    }
}
