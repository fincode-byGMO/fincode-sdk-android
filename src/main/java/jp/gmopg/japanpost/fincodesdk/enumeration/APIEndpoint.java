package jp.gmopg.japanpost.fincodesdk.enumeration;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public enum APIEndpoint {

    /** 決済登録 */
    REGISTER(HttpMethod.POST,"/payments"),
    /** 決済実行 */
    PAYMENT(HttpMethod.POST,"/payments/[id]"),
    /** カード登録 */
    CARD_REGISTER(HttpMethod.POST,"/customers/[customer_id]/cards"),
    /** カード更新 */
    CARD_UPDATE(HttpMethod.POST,"/customers/[customer_id]/cards/[cardId]"),
    /** カード一覧取得 */
    CARD_INFO_LIST(HttpMethod.POST,"/customers/[customer_id]/cards");

    private HttpMethod method;
    private String endpoint;

    APIEndpoint(HttpMethod method, String endpoint) {
        this.method = method;
        this.endpoint = endpoint;
    }

    public  HttpMethod getHttpMethod() {
        return this.method;
    }

    public String getEndPoint() {
        // TODO ホストを設定ファイル（Gradle？）から読み込むように実装する
        String baseUrl = "https://api.dev.fincode.jp";
        // TODO APIMajorVersionを設定ファイル（Gradle？）から読み込むように実装する
        String majorVersion = "/v1";

        return baseUrl + majorVersion + this.endpoint;
    }

    public enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    }
}
