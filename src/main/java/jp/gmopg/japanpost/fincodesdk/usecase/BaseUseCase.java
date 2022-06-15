package jp.gmopg.japanpost.fincodesdk.usecase;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jp.gmopg.japanpost.fincodesdk.R;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeCardInfoListResponse;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorInfo;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class BaseUseCase {

    protected HashMap<String, String> getHeader() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        // TODO SDKを組み込むアプリ側から貰うように修正する
        map.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LThjNTUtMDE3YzhjNzk0MmIxZmEzOWM3ZDktZmQ4MS00OTUwLWFiOWYtYmViZDZjMTc0Y2E3c18yMTEyMjc0MjU4NQ");

        return map;
    }
}
