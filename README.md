# Fincode Android SDK

FincodeSDKを使用すると、Androidアプリで決済、カード登録・更新・一覧取得が簡単に構築できます。

目次
=================

   * [リリース](#リリース)
   * [要件](#要件)
   * [導入](#導入)
   * [コンポーネント](#コンポーネント)
   * [表示設定](#表示設定)
   * [Repository](#repository)
   * [Licenses](#licenses)
<br>

## リリース

FincodeSDを手動でリンクするには、 [リリース ※TODO タグ付けページのリンクに置き換える](https://www.google.com) ページのバージョンを使用して、aarまたはFincodeSDKプロジェクトを追加してください。

- FincodeSDK.aar

手動でリンクする方法は、こちらの[導入](#導入)を行ってください。

## 要件

FincodeSDKは、Android SDK 11以降/Swift4以降が必要です。

## 導入
FincodeSDKを利用するには、FincodeSDK.aarまたはFincodeSDKプロジェクトを組み込むことが必要です。

- aarの組み込み
    1. Android　StudioでSDKを使用したいプロジェクト内の任意のフォルダにFincodeSDK.aarを配置します。
    2. SDKを使用したいプロジェクトの「build.gradle > dependencies」に以下の記述を追加します。（○○：手順1でaarを配置したファイルのパス）
    ```
    implementation files ('○○/FincodeSDK.aar')
    ```

- プロジェクトの組み込み
    1. SDKを使用したいプロジェクトとFincodeSDKを同フォルダに配置します。
    2. SDKを使用したいプロジェクトのsettings.gradleに以下の記述を追加し、右上の「Sync Now」を押下します。
    3. Android Studio左上にあるAndroidビューに、プロジェクトの他にFincodeSDKが追加されます。
    4. SDKを使用したいプロジェクトのbuild.gradleに以下の記述を追加し、右上の「Sync Now」を押下します。
    5. プロジェクト内のクラスでimportすることにより、SDKを使用することができます。

## コンポーネント
- 配置

    - xmlに配置
    コンポーネントの配置は、ActivityのxmlにSDKを配置するレイアウト(※)を追加する。
    ※ViewGroupを継承しているレイアウト

      例
      ```
      <FrameLayout
            android:id="@+id/replace_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
        ```

    - Activityの設定
    SDKを配置するActivityは「Activity」を継承し、SDKを置き換える箇所のレイアウトを取得する。(「xmlに配置」で追加したレイアウトのIDで指定する)

      例
        ```
        public class MainActivity extends Activity

        // DataBindingを使用する場合
        ViewGroup vg = binding.replaceView;

        // findViewByIdを使用する場合
        ViewGroup vg = findViewById(R.id.replace_view);
        ```

- 初期化

- 決済実行 - 例

```
import fincodesdk;

public class MainActivity extends Activity implements FincodeCallback<FincodePaymentResponse> {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewGroup vg = binding.replaceView;

        paymentVertical(vg);
    }

    private void paymentVertical(ViewGroup vg) {
        FincodeVerticalView view = new FincodeVerticalView(this, Opt.options(), vg);
        view.initForPayment(paymentConfig(), this);
    }

    @Override
    public void onResponse(FincodePaymentResponse fincodePaymentResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }

    public static FincodePaymentConfiguration paymentConfig() {
        FincodePaymentConfiguration config = new FincodePaymentConfiguration();

        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LThSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2q_7TbLcO9y1A";
        config.payType = "Card";
        config.accessId = "a_B1egvGN_Rge19dO14Sample";
        config.id = "o_XqXw_hhlQAa7FFzCSample";

        return config;
    }
}
```

処理成功時の結果は、以下のClassでキャストすることで参照することができます。

|Class|説明|
|:--|:--|
|FincodePaymentResponse|決済実行APIのResponse情報を保持|

- カード登録 - 例

```
import fincodesdk;

public class CardRegisterView extends Activity implements FincodeCallback<FincodeCardRegisterResponse> {

    private static final String VIEW_TYPE = "viewType";

    public static Intent createIntent(Context context, ViewType viewType){
        Intent intent = new Intent(context, CardRegisterView.class);
        intent.putExtra(VIEW_TYPE, viewType);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ViewType viewType = (ViewType)getIntent().getSerializableExtra(VIEW_TYPE);
        setContentView(R.layout.activity_payment_replace);

        ViewGroup vg = findViewById(R.id.replace_view);

        switch (viewType) {
            case VERTICAL:
                cardRegisterVertical(vg);
                break;
            case HORIZONTAL:
                cardRegisterHorizontal(vg);
                break;
        }
    }

    private void cardRegisterVertical(ViewGroup vg) {
        FincodeVerticalView view = new FincodeVerticalView(this, Opt.options(), vg);
        view.initForCardRegister(Config.registerConfig(), this);
    }

    private void cardRegisterHorizontal(ViewGroup vg) {
        FincodeHorizontalView view = new FincodeHorizontalView(this, Opt.options(), vg);
        view.initForCardRegister(Config.registerConfig(), this);
    }

    @Override
    public void onResponse(FincodeCardRegisterResponse fincodePaymentResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeCardRegisterResponse fincodeErrorResponse) {
        // 異常
    }

    public static FincodeCardRegisterConfiguration registerConfig() {
        FincodeCardRegisterConfiguration config = new FincodeCardRegisterConfiguration();

        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LThSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2q_7TbLcO9y1A";
        config.defaultFlag = DefaultFlg.ON;

        return config;
    }
}
```

処理成功時の結果は、以下のClassでキャストすることで参照することができます。

|Class|説明|
|:--|:--|
|FincodeCardRegisterResponse|カード登録APIのResponse情報を保持|

- カード更新 - 例

```
import fincodesdk;

public class CardUpdateView extends Activity implements FincodeCallback<FincodeCardUpdateResponse> {

    private static final String VIEW_TYPE = "viewType";

    public static Intent createIntent(Context context, ViewType viewType){
        Intent intent = new Intent(context, CardUpdateView.class);
        intent.putExtra(VIEW_TYPE, viewType);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ViewType viewType = (ViewType)getIntent().getSerializableExtra(VIEW_TYPE);
        setContentView(R.layout.activity_payment_replace);

        ViewGroup vg = findViewById(R.id.replace_view);

        switch (viewType) {
            case VERTICAL:
                cardUpdateVertical(vg);
                break;
            case HORIZONTAL:
                cardUpdateHorizontal(vg);
                break;
        }
    }

    private void cardUpdateVertical(ViewGroup vg) {
        FincodeVerticalView view = new FincodeVerticalView(this, Opt.options(), vg);
        view.initForCardUpdate(Config.updateConfig(), this);
    }

    private void cardUpdateHorizontal(ViewGroup vg) {
        FincodeHorizontalView view = new FincodeHorizontalView(this, Opt.options(), vg);
        view.initForCardUpdate(Config.updateConfig(),this);
    }

    @Override
    public void onResponse(FincodeCardUpdateResponse fincodePaymentResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeCardUpdateResponse fincodeErrorResponse) {
        // 異常
    }

    public static FincodeCardUpdateConfiguration updateConfig() {
        FincodeCardUpdateConfiguration config = new FincodeCardUpdateConfiguration();

        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LThSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2q_7TbLcO9y1A";
        config.defaultFlag = DefaultFlg.ON;
        config.cardId = "cs_UrDeMDBlQfShg9QZsMPLE";

        return config;
    }

```

処理成功時の結果は、以下のClassでキャストすることで参照することができます。

|Class|説明|
|:--|:--|
|FincodeCardUpdateResponse|カード更新APIのResponse情報を保持|

## 表示設定
SDKのOptionsクラスの値を変更することで表示・非表示を切り替えます。

|Property|説明|
|:--|:--|
|HeadingHidden|各欄の見出しをON：表示、OFF：非表示|
|DynamicLogDisplay|ブランド画像 動的切り替えをON：表示、OFF：非表示|
|HolderNameHidden|名義人名欄をON：表示、OFF：非表示|
|PayTimesHidden|お支払い回数欄をON：表示、OFF：非表示|
|labelCardNo|ラベルテキストを設定 ( カード番号 )|
|labelExpire|ラベルテキストを設定 ( 有効期限 )|
|labelCvc|ラベルテキストを設定 ( セキュリティコード )|
|labelHolderName|ラベルテキストを設定 ( カード名義人名 )|
|labelPaymentMethod|ラベルテキストを設定 ( お支払い方法 )|
|placeCardNo|プレースホルダーを設定 ( カード番号 )|
|placeExpireMonth|プレースホルダーを設定 ( 有効期限 [月] )|
|placeExpireYear|プレースホルダーを設定 ( 有効期限 [年] )|
|placeCvc|プレースホルダーを設定 ( セキュリティコード )|
|placeHolderName|プレースホルダーを設定 ( カード名義人名 )|
|colorBackground|フォーム全体の背景色|
|colorBackgroundInput|インプットフィールドの背景色|
|colorText|インプットの文字色|
|colorLabelText|ラベルの文字色|
|colorBorder|インプットのボーダーの色|
|fontFamily|フォントの種類|


## Repository
FincodeSDKは、以下のAPIを実行するメソッドを用意しています。

|API|Class|Method|
|:--|:--|:--|
|決済実行|FincodePaymentRepository|public void payment(String orderId, FincodePaymentRequest request, FincodeCallback<FincodePaymentResponse> fincodeCallback)|
|カード_一覧取得|FincodeCardOperateRepository|public void getCardInfoList(String customerId, FincodeCallback<FincodeCardInfoListResponse> fincodeCallback)|
|カード_登録|FincodeCardOperateRepository|public void cardRegister(String customerId, FincodeCardRegisterRequest request, FincodeCallback<FincodeCardRegisterResponse> fincodeCallback)|
|カード_更新|FincodeCardOperateRepository|public void cardUpdate(String customerId, String cardId, FincodeCardUpdateRequest request, FincodeCallback<FincodeCardUpdateResponse> fincodeCallback)|

- 決済実行 - 例

```
protected HashMap<String, String> header() {
    HashMap<String, String> map = new HashMap();
    map.put("Content-Type", "application/json");
    map.put("Authorization", "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

    return map;
}


private void paymentVertical(ViewGroup vg) {
    FincodeVerticalView view = new FincodeVerticalView(this, Opt.options(), vg);
    view.initForPayment(Config.paymentConfig(), this);

    // プロパティの詳細は一覧をご参照ください
    FincodePaymentRequest request = new FincodePaymentRequest();

    request.setAccessId("Bearer");
    request.setPayType("Card");

    String orderId = "cs_sample";

    payment(orderId, request, new FincodeCallback<FincodePaymentResponse>() {
        @Override
        public void onResponse(FincodePaymentResponse response) {

        }

        @Override
        public void onFailure(FincodeErrorResponse errorInfo) {

        }
    });
}

// 引数の詳細は一覧をご参照ください
public void payment(String orderId, FincodePaymentRequest request, final FincodeCallback<FincodePaymentResponse> fincodeCallback) {
    FincodePaymentRepository.getInstance().payment(header(), orderId, request, new FincodeCallback<FincodePaymentResponse>() {
        public void onResponse(FincodePaymentResponse response) {
            // 正常
        }

        public void onFailure(FincodeErrorResponse errorInfo) {
            // 異常
        }
    });
}
```

- FincodePaymentRequest プロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|マスク対象|備考|
|:--|:--|:--|:--|:--|:--|:--|:--|
|決済種別|payType|〇|String|1|50| | |
|取引ID|accessId|〇|String|24|24| | |
|オーダーID|id|〇|String|1|30| | |
|トークン|token|△|String|1|512| |カード番号入力方式：トークン方式の場合 必須|
|カード番号|cardNo|△|String|10|16|〇|カード番号入力方式：直接方式の場合 必須|
|有効期限|expire|△|String|4|4| |カード番号入力方式：直接方式の場合 必須|
|顧客ID|customerId|△|String|1|60| |カード番号入力方式：顧客ID方式の場合 必須|
|カードID|cardId|△|String|25|25| |カード番号入力方式：顧客ID方式の場合 必須|
|支払方法|method| |String|1|1| |1：一括  2：分割|
|支払回数|payTimes| |String|1|2| |支払方法にて、分割を指定していた場合  必須|
|セキュリティコード|securityCode| |String|4|4|〇| |
|カード名義人|holderName| |String|1|50|〇|カード番号入力方式：顧客ID方式の場合 は登録時のカード名義人が優先されます|

- 引数一覧

|引数|説明|
|:--|:--|
|orderId|FincodePaymentRequestのorderIdと同値|
|request|リクエスト パラメータ|
|header|リクエスト ヘッダー|
|FincodeCallback|API実行結果を処理するインターフェース|

---

- カード_一覧取得 - 例

```
protected HashMap<String, String> header() {
    HashMap<String, String> map = new HashMap();
    map.put("Content-Type", "application/json");
    map.put("Authorization", "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

    return map;
}

private void cardListVertical(ViewGroup vg) {
    FincodeVerticalView view = new FincodeVerticalView(this, Opt.options(), vg);
    view.initForPayment(Config.paymentConfig(), this);

    String customerId = "c_HSZkCAxNS2q_sample";

    getCardInfoList(customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
        @Override
        public void onResponse(FincodeCardInfoListResponse response) {
            // 正常
        }

        @Override
        public void onFailure(FincodeErrorResponse errorInfo) {
            // 異常
        }
    });
}

// 引数の詳細は一覧をご参照ください
public void getCardInfoList(String customerId, final FincodeCallback<FincodeCardInfoListResponse> fincodeCallback) {
    FincodeCardOperateRepository.getInstance().getCardInfoList(header(), customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
        public void onResponse(FincodeCardInfoListResponse response) {
            // 正常
        }

        public void onFailure(FincodeErrorResponse errorInfo) {
            // 異常
        }
    });
}
```

- 引数一覧

|引数|説明|
|:--|:--|
|customerId|顧客ID|
|header|リクエスト ヘッダー|
|FincodeCallback|API実行結果を処理するインターフェース|

---

- カード_登録 - 例

```
protected HashMap<String, String> header() {
    HashMap<String, String> map = new HashMap();
    map.put("Content-Type", "application/json");
    map.put("Authorization", "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

    return map;
}

private void cardRegisterVertical(ViewGroup vg) {
    FincodeVerticalView view = new FincodeVerticalView(this, Opt.options(), vg);
    view.initForCardRegister(Config.registerConfig(), this);

    // プロパティの詳細は一覧をご参照ください
    FincodeCardRegisterRequest request = new FincodeCardRegisterRequest();

    request.setAccessId("Bearer");
    request.setPayType("Card");

    String customerId = "c_HSZkCAxNS2q_sample";

    cardRegister(customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
        @Override
        public void onResponse(FincodeCardInfoListResponse response) {
            // 正常
        }

        @Override
        public void onFailure(FincodeErrorResponse errorInfo) {
            // 異常
        }
    });
}

// 引数の詳細は一覧をご参照ください
public void cardRegister(String customerId, FincodeCardRegisterRequest request, FincodeCallback<FincodeCardRegisterResponse> fincodeCallback) {
    FincodeCardOperateRepository.getInstance().cardRegister(header(), customerId, request, new FincodeCallback<FincodeCardRegisterResponse>() {
        public void onResponse(FincodeCardRegisterResponse response) {
            // 正常
        }

        public void onFailure(FincodeErrorResponse errorInfo) {
            // 異常
        }
    });
}
```

- FincodeCardRegisterRequestプロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|マスク対象|備考|
|:--|:--|:--|:--|:--|:--|:--|:--|
|デフォルトフラグ|defaultFlag|〇|String|1|1| |1：ON　0：OFF|
|カード番号|cardNo|△|String|10|16|〇|トークンに入力がある場合は無視、なしの場合は必須。|
|有効期限|expire|△|String|4|4| |トークンに入力がある場合は無視、なしの場合は必須。( YYMM形式 )|
|カード名義人|holderName| |String|1|50|〇|トークンに入力がある場合は無視。|
|セキュリティコード|securityCode| |String|3|4|〇|トークンに入力がある場合は無視。|
|トークン|token| |String|1|512| | |

- 引数一覧

|引数|説明|
|:--|:--|
|customerId|顧客ID|
|request|リクエスト パラメータ|
|header|リクエスト ヘッダー|
|FincodeCallback|API実行結果を処理するインターフェース|

---

- カード_更新 - 例

```
protected HashMap<String, String> header() {
    HashMap<String, String> map = new HashMap();
    map.put("Content-Type", "application/json");
    map.put("Authorization", "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

    return map;
}

private void cardUpdateVertical(ViewGroup vg) {
    FincodeVerticalView view = new FincodeVerticalView(this, Opt.options(), vg);
    view.initForCardUpdate(Config.updateConfig(), this);

    // プロパティの詳細は一覧をご参照ください
    FincodeCardUpdateRequest request = new FincodeCardUpdateRequest();

    request.setAccessId("Bearer");
    request.setPayType("Card");

    String customerId = "c_HSZkCAxNS2q_sample";
    String cardId = "cs_UrDeMDBlQfShg9QZsMPLE";

    cardUpdate(customerId, cardId, new FincodeCallback<FincodeCardUpdateResponse>() {
        @Override
        public void onResponse(FincodeCardUpdateResponse response) {
            // 正常
        }

        @Override
        public void onFailure(FincodeErrorResponse errorInfo) {
            // 異常
        }
    });
}

// 引数の詳細は一覧をご参照ください
public void cardUpdate(String customerId, String cardId, FincodeCardUpdateRequest request, FincodeCallback<FincodeCardUpdateResponse> fincodeCallback) {
    FincodeCardOperateRepository.getInstance().cardUpdate(header(), customerId, cardId, request, new FincodeCallback<FincodeCardUpdateResponse>() {
        public void onResponse(FincodeCardUpdateResponse response) {
            // 正常
        }

        public void onFailure(FincodeErrorResponse errorInfo) {
            // 異常
        }
    });
}
```

- FincodeCardUpdateRequestプロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|マスク対象|備考|
|:--|:--|:--|:--|:--|:--|:--|:--|
|デフォルトフラグ|defaultFlag|〇|String|1|1| |パラメータありの場合のみ更新。  1：ON　（0：OFFは設定不可）|
|有効期限|expire|△|String|4|4| |トークンに入力がある場合は無視。  パラメータありの場合のみ更新。 ( YYMM形式 )|
|カード名義人|holderName| |String|1|50|〇|トークンに入力がある場合は無視。  パラメータありの場合のみ更新。|
|セキュリティコード|securityCode| |String|3|4|〇|トークンに入力がある場合は無視。|
|トークン|token| |String|1|512| | |

- 引数一覧

|引数|説明|
|:--|:--|
|customerId|顧客ID|
|cardId|カードID|
|request|リクエスト パラメータ|
|header|リクエスト ヘッダー|
|FincodeCallback|API実行結果を処理するインターフェース|

## Licenses

- [okhttp](https://github.com/square/okhttp/blob/master/LICENSE.txt)
- [retrofit](https://github.com/square/retrofit/blob/master/LICENSE.txt)
