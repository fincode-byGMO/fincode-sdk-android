package jp.gmopg.japanpost.fincodesdk.util;

import com.google.gson.Gson;

import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorInfo;
import jp.gmopg.japanpost.fincodesdk.entities.api.FincodeErrorResponse;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by a.nakajima on 2022/06/15.
 */
public class HttpUtil {

    private static Gson gson = new Gson();

    public static <T> FincodeErrorResponse getErrorInfo(Response<T> response) {

        FincodeErrorInfo errorInfo = null;
        try {
            ResponseBody b = response.errorBody();
            if (b != null) {

                errorInfo = gson.fromJson(b.toString(), FincodeErrorInfo.class);
            }
        } catch (Exception ex) {
            // do nothing
        }

        return new FincodeErrorResponse(response.code(), errorInfo);
    }

}
