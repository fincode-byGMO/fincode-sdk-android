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

FincodeSDKは、Android SDK 11以降/API Level 21以降が必要です。

## 導入
FincodeSDKを利用するには、FincodeSDK.aarまたはFincodeSDKプロジェクトを組み込むことが必要です。

- aarの組み込み
1. Android　StudioでSDKを使用したいプロジェクト内の任意のフォルダにFincodeSDK.aarを配置します。
2. build.gradleの設定

    2-1. build.gradleのandroid内にDataBindingを利用する定義を追加する。

        dataBinding {
            enabled = true
        }

    2-2. build.gradleのdependencies内に以下の記述を追加します。（括弧内のパスは、手順1でaarファイルを配置したファイルのパス）

        implementation files ('○○/FincodeSDK.aar')

    2-3. build.gradleのdependencies内に以下OSSの記述を追加し、右上の「Sync Now」を押下します。

        implementation 'com.squareup.okhttp3:okhttp:4.10.0'
        implementation 'com.squareup.okhttp3:logging-interceptor:4.10.0'
        implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
        implementation 'com.google.code.gson:gson:2.9.0'


3. AndroidManifest.xmlに以下の定義を追加します。
```
<uses-permission android:name="android.permission.INTERNET" />
```

4. プロジェクト内のクラスでimportすることにより、SDKを使用することができます。


- プロジェクトの組み込み
1. SDKを使用したいプロジェクトのルートフォルダと同じ階層にソースを配置してください。
2. SDKを使用したいプロジェクトのsettings.gradleに以下の記述を追加し、右上の「Sync Now」を押下します。
    ```
    includeFlat 'FincodeSDK'
    ```
3. Android Studio左上にあるAndroidビューに、プロジェクトの他にFincodeSDKが追加されます。
4. SDKを使用したいプロジェクトのbuild.gradle設定

    4-1. build.gradleのandroid内にDataBindingを利用する定義を追加する。

        dataBinding {
            enabled = true
        }

    4-2. build.gradleのdependencies内に以下の記述を追加する。

        implementation project(':FincodeSDK')

    4-3. build.gradleのdependencies内に以下OSSの記述を追加し、右上の「Sync Now」を押下します。

        implementation 'com.squareup.okhttp3:okhttp:4.10.0'
        implementation 'com.squareup.okhttp3:logging-interceptor:4.10.0'
        implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
        implementation 'com.google.code.gson:gson:2.9.0'

5. AndroidManifest.xmlに以下の定義を追加します。
```
<uses-permission android:name="android.permission.INTERNET" />
```
6. プロジェクト内のクラスでimportすることにより、SDKを使用することができます。

## コンポーネント
配置

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

    - SDKを使用するActivity内で「FincodeVerticalView」または「FincodeHorizontalView」のオブジェクトを生成します。

    例

    - Vertical Layout
    ```
    FincodeVerticalView view = new FincodeVerticalView(this, new Options(), vg);
    ```

    - Horizontal Layout
    ```
    FincodeHorizontalView view = new FincodeHorizontalView(this, new Options(), vg);
    ```

    - SDKを置き換える箇所のレイアウトを取得する以下の記述を追加。（手順：xmlに配置 で追加したレイアウトのIDで指定する）

    例

    - DataBindingを使用する場合
    ```
    ViewGroup vg = binding.replaceView;
    ```

    - findViewByIdを使用する場合
    ```
    ViewGroup vg = findViewById(R.id.replace_view);
    ```


- 初期化

    各機能に応じた初期化処理を実行します。

    - 決済の場合
    ```
    view.initForPayment(new FincodePaymentConfiguration(), this);
    ```

    - カード登録の場合
    ```
    view.initForCardRegister(new FincodeCardRegisterConfiguration(), this);
    ```

    - カード更新の場合
    ```
    view.initForCardUpdate(new FincodeCardUpdateConfiguration(), this);
    ```


- 決済実行 - 例

```
import fincodesdk;

public class MainActivity extends Activity implements FincodeCallback<FincodePaymentResponse> {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewGroup vg = binding.replaceView
        paymentVertical(vg);
    }
   
    private void paymentVertical(ViewGroup vg) {
        FincodeVerticalView view = new FincodeVerticalView(this,  new Options(), vg);

        FincodePaymentConfiguration config = new FincodePaymentConfiguration();
        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2_Sample";
        config.payType = "Card";
        config.accessId = "";
        config.id = "";

        view.initForPayment(config, this);
    }

    @Override
    public void onResponse(FincodePaymentResponse fincodePaymentResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }
}
```

処理成功時の結果は、以下のClassでキャストすることで参照することができます。

|Class|説明|
|:--|:--|
|FincodePaymentResponse|決済実行APIのResponse情報を保持|


- カード登録 - 例

```
import fincodesdk;

public class CardRegisterView extends Activity implements FincodeCallback<FincodeCardRegisterResponse> {

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

        cardRegisterVertical(vg);
    }
    
    private void cardRegisterVertical(ViewGroup vg) {
        FincodeVerticalView view = new FincodeVerticalView(this, new Options(), vg);

        FincodeCardRegisterConfiguration config = new FincodeCardRegisterConfiguration();
        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2_Sample";
        config.defaultFlg = DefaultFlg.ON;

        view.initForCardRegister(config, this);
    }


    @Override
    public void onResponse(FincodeCardRegisterResponse fincodePaymentResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }
}
```

処理成功時の結果は、以下のClassでキャストすることで参照することができます。

|Class|説明|
|:--|:--|
|FincodeCardRegisterResponse|カード登録APIのResponse情報を保持|

- カード更新 - 例

```
import fincodesdk;

public class CardUpdateView extends Activity implements FincodeCallback<FincodeCardUpdateResponse> {

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

        cardUpdateVertical(vg);
    }

    private void cardUpdateVertical(ViewGroup vg) {
        FincodeVerticalView view = new FincodeVerticalView(this,  new Options(), vg);

        FincodeCardUpdateConfiguration config = new FincodeCardUpdateConfiguration();

        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2_Sample";
        config.defaultFlg = DefaultFlg.ON;
        config.cardId = "cs_UrDeMDBlQ_Sample"

        view.initForCardUpdate(config, this);
    }

    @Override
    public void onResponse(FincodeCardUpdateResponse fincodePaymentResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }
}
```

処理成功時の結果は、以下のClassでキャストすることで参照することができます。

|Class|説明|
|:--|:--|
|FincodeCardUpdateResponse|カード更新APIのResponse情報を保持


## 表示設定
SDKのOptionsクラスの値を変更することで表示・非表示を切り替えます。

|Property|説明|
|:--|:--|
|HeadingHidden|各欄の見出しをtrue：非表示、false：表示|
|DynamicLogDisplay|ブランド画像 動的切り替えをtrue：非表示、false：表示|
|HolderNameHidden|名義人名欄をtrue：非表示、false：表示|
|PayTimesHidden|お支払い回数欄をtrue：非表示、false：表示|
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
|決済実行|FincodePaymentRepository|public void payment(HashMap<String, String> header, String orderId, FincodePaymentRequest request, FincodeCallback<FincodePaymentResponse> fincodeCallback)|
|カード_一覧取得|FincodeCardOperateRepository|public void getCardInfoList(HashMap<String, String> header, String customerId, FincodeCallback<FincodeCardInfoListResponse> fincodeCallback)|
|カード_登録|FincodeCardOperateRepository|public void cardRegister(HashMap<String, String> header, String customerId, FincodeCardRegisterRequest cardInfoRequest, FincodeCallback<FincodeCardRegisterResponse> fincodeCallback)|
|カード_更新|FincodeCardOperateRepository|public void cardUpdate(HashMap<String, String> header, String customerId, String cardId, FincodeCardUpdateRequest cardInfoRequest, FincodeCallback<FincodeCardUpdateResponse> fincodeCallback)|


---

- 決済実行 - 例

```
HashMap<String, String> header = new HashMap<String, String>();
header.put("Content-Type", "application/json");
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

FincodePaymentRequest req = new FincodePaymentRequest();
req.setPayType("Card");
req.setAccessId("a_D21rkF_CTxyrxwju-rSample");
req.setOrderId("o_20adN6n-SpSO78oz5Sample");
req.setCardNo("1234567890123456");
req.setExpire("2501");
req.setMethod(MethodType.ONE_TIME.getValue());

String orderId = "o_20adN6n-SpSO78oz5Sample";

FincodePaymentRepository.getInstance().payment(header, orderId, req, new FincodeCallback<FincodePaymentResponse>() {
    @Override
    public void onResponse(FincodePaymentResponse fincodePaymentResponse) {
        Log.d("Success", "");
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        Log.d("Failure", "");
    }
});
```

- FincodePaymentRequest プロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|マスク対象|備考|
|:--|:--|:--|:--|:--|:--|:--|:--|
|決済種別|payType|〇|String|1|50| | |
|取引ID|accessId|〇|String|24|24| | |
|オーダーID|id|〇|String|1|30| | |
|トークン|token|△|String|1|512| |カード番号入力方式：トークン方式の場合 必須|
|カード番号|cardNo|△|String|10|16|〇|カード番号入力方式：直接方式の場合 必須|
|有効期限|expire|△|String|4|4| |カード番号入力方式：直接方式の場合 必須|
|顧客ID|customerId|△|String|1|60| |カード番号入力方式：顧客ID方式の場合 必須|
|カードID|cardId|△|String|25|25| |カード番号入力方式：顧客ID方式の場合 必須|
|支払方法|method| |String|1|1| |1：一括  2：分割|
|支払回数|payTimes| |String|1|2| |支払方法にて、分割を指定していた場合  必須|
|セキュリティコード|securityCode| |String|4|4|〇| |
|カード名義人|holderName| |String|1|50|〇|カード番号入力方式：顧客ID方式の場合 は登録時のカード名義人が優先されます|

- 引数一覧

|引数|説明|
|:--|:--|
|header|リクエスト ヘッダー|
|orderId|FincodePaymentRequestのorderIdと同値|
|req|リクエスト パラメータ|
|FincodeCallback|API実行結果を処理するインターフェース|


---

- カード_一覧取得 - 例

```
HashMap<String, String> header = new HashMap<String, String>();
header.put("Content-Type", "application/json");
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

String customerId = "Sample1";

FincodeCardOperateRepository.getInstance().getCardInfoList(header, customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
    @Override
    public void onResponse(FincodeCardInfoListResponse fincodeCardInfoListResponse) {
        Log.d("Success", "");
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        Log.d("Failure", "");
    }
});
```

- 引数一覧

|引数|説明|
|:--|:--|
|header|リクエスト ヘッダー|
|customerId|顧客ID|
|FincodeCallback|API実行結果を処理するインターフェース|

---

- カード_登録 - 例

```
HashMap<String, String> header = new HashMap<String, String>();
header.put("Content-Type", "application/json");
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

FincodeCardRegisterRequest req = new FincodeCardRegisterRequest();
req.setCardNo("1234567890123456");
req.setExpire("2501");
req.setDefaltFlag("1");

String customerId = "Sample1";

FincodeCardOperateRepository.getInstance().cardRegister(header, customerId, req, new FincodeCallback<FincodeCardRegisterResponse>() {
    @Override
    public void onResponse(FincodeCardRegisterResponse fincodeCardRegisterResponse) {
        Log.d("Success", "");
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        Log.d("Failure", "");
    }
});
```

- FincodeCardRegisterRequestプロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|マスク対象|備考|
|:--|:--|:--|:--|:--|:--|:--|:--|
|デフォルトフラグ|defaultFlag|〇|String|1|1| |1：ON　0：OFF|
|カード番号|cardNo|△|String|10|16|〇|トークンに入力がある場合は無視、なしの場合は必須。|
|有効期限|expire|△|String|4|4| |トークンに入力がある場合は無視、なしの場合は必須。( YYMM形式 )|
|カード名義人|holderName| |String|1|50|〇|トークンに入力がある場合は無視。|
|セキュリティコード|securityCode| |String|3|4|〇|トークンに入力がある場合は無視。|
|トークン|token| |String|1|512| | |

- 引数一覧

|引数|説明|
|:--|:--|
|header|リクエスト ヘッダー|
|customerId|顧客ID|
|req|リクエスト パラメータ|
|FincodeCallback|API実行結果を処理するインターフェース|

---

- カード_更新 - 例

```
HashMap<String, String> header = new HashMap<String, String>();
header.put("Content-Type", "application/json");
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

FincodeCardUpdateRequest req = new FincodeCardUpdateRequest();
req.setExpire("2501");

String customerId = "Sample1";
String cardId = "cs_1a4TiE_eT0GQ2QB7Sample";

FincodeCardOperateRepository.getInstance().cardUpdate(header, customerId, cardId, req, new FincodeCallback<FincodeCardUpdateResponse>() {
    @Override
    public void onResponse(FincodeCardUpdateResponse fincodeCardUpdateResponse) {
        Log.d("Success", "");
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        Log.d("Failure", "");
    }
});
```

- FincodeCardUpdateRequestプロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|マスク対象|備考|
|:--|:--|:--|:--|:--|:--|:--|:--|
|デフォルトフラグ|defaultFlag|〇|String|1|1| |パラメータありの場合のみ更新。  1：ON　（0：OFFは設定不可）|
|有効期限|expire|△|String|4|4| |トークンに入力がある場合は無視。  パラメータありの場合のみ更新。 ( YYMM形式 )|
|カード名義人|holderName| |String|1|50|〇|トークンに入力がある場合は無視。  パラメータありの場合のみ更新。|
|セキュリティコード|securityCode| |String|3|4|〇|トークンに入力がある場合は無視。|
|トークン|token| |String|1|512| | |

- 引数一覧

|引数|説明|
|:--|:--|
|header|リクエスト ヘッダー|
|customerId|顧客ID|
|cardId|カードID|
|req|リクエスト パラメータ|
|FincodeCallback|API実行結果を処理するインターフェース|

## Licenses

- [okhttp](https://github.com/square/okhttp/blob/master/LICENSE.txt)
- [retrofit](https://github.com/square/retrofit/blob/master/LICENSE.txt)
- [gson](https://github.com/google/gson/blob/master/LICENSE)