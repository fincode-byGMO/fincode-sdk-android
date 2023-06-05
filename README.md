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

FincodeSDKを手動でリンクするには、 [リリース ※TODO タグ付けページのリンクに置き換える](https://www.google.com) ページのバージョンを使用して、aarまたはFincodeSDKプロジェクトを追加してください。

- FincodeSDK.aar

手動でリンクする方法は、こちらの[導入](#導入)を行ってください。

## 要件

FincodeSDKは、Android OS 5.0以降/API Level 21以降が必要です。

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

        implementation files ('libs/FincodeSDK.aar')

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

<br/>

- プロジェクトの組み込み
1. SDKを使用したいプロジェクトのルートフォルダと同じ階層にソースを配置してください。
2. SDKを使用したいプロジェクトのsettings.gradleに以下の記述を追加し、右上の「Sync Now」を押下します。
    ```
    includeFlat 'FincodeSDK'
    ```
3. Android Studio左上にあるAndroidビューに、FincodeSDKのプロジェクトが追加されます。
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
コンポーネントの配置および初期化

1. ActivityのxmlにSDKを配置するレイアウト(※)を追加する。

    ※ViewGroupを継承しているレイアウト

    例
    ```
    <FrameLayout
        android:id="@+id/replace_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
    ```

2. SDKを使用するActivity内で「FincodeVerticalView」または「FincodeHorizontalView」のオブジェクトを生成します。

    例

    - Vertical Layout
    ```
    ・Java
    　　FincodeVerticalView view = new FincodeVerticalView(this, new Options(), vg);
    ```
    ```
    ・Kotlin
    　　val view = FincodeVerticalView(this, Options(), vg)
    ```

    - Horizontal Layout
    ```
    ・Java
    　　FincodeHorizontalView view = new FincodeHorizontalView(this, new Options(), vg);
    ```
    ```
    ・Kotlin
    　　val view = FincodeHorizontalView(this, Options(), vg)
    ```

    第1引数

    |Class|
    |----|
    |Activity|

    第2引数
    
    |Class|
    |----|
    |Options|

    |変数名|型|説明|デフォルト値|備考|
    |----|----|----|----|----|
    |headingHidden|boolean|見出しの表示・非表示|false|true: 非表示, false: 表示|
    |dynamicLogDisplay|boolean|カードブランド画像 動的切り替えの表示・非表示|false|true: 非表示, false: 表示|
    |holderNameHidden|boolean|名義人名の表示・非表示|false|true: 非表示, false: 表示|
    |payTimesHidden|boolean|お支払い回数の表示・非表示|false|true: 非表示, false: 表示|
    |labelCardNo|String|ラベルテキストを設定 (カード番号)|カード番号| |
    |labelExpire|String|ラベルテキストを設定 (有効期限)|有効期限| |
    |labelCvc|String|ラベルテキストを設定 (セキュリティコード)|セキュリティコード| |
    |labelHolderName|String|ラベルテキストを設定 (カード名義人名)|カード名義人| |
    |labelPaymentMethod|String|ラベルテキストを設定 (お支払い方法)|お支払い方法| |
    |placeCardNo|String|プレースホルダーの設定 (カード番号)|1234 5678 9012 3456| |
    |placeExpireMonth|String|プレースホルダーの設定 (有効期限 [月])|01| |
    |placeExpireYear|String|プレースホルダーの設定 (有効期限 [年])|25| |
    |placeCvc|String|プレースホルダーの設定 (セキュリティコード)|001| |
    |placeHolderName|String|プレースホルダーの設定 (カード名義人名)|TARO YAMADA| |
    |colorBackground|String|フォーム全体の背景色|""|16進数 (例: #0125af)|
    |colorBackgroundInput|String|インプットフィールドの背景色|""|16進数 (例: #0125af)|
    |colorText|String|インプットの文字色|""|16進数 (例: #0125af)|
    |colorLabelText|String|ラベルの文字色|""|16進数 (例: #0125af)|
    |colorBorder|String|インプットのボーダーの色|""|16進数 (例: #0125af)|
    |fontFamily|Typeface|フォントの種類|null| |

    第3引数

    |Class|
    |----|
    |ViewGroup|

    SDKを置き換える箇所のレイアウトのオブジェクトを指定します。


    例

    - DataBindingを使用する場合
    ```
    ViewGroup vg = binding.replaceView;
    ```

    - findViewByIdを使用する場合
    ```
    ViewGroup vg = findViewById(R.id.replace_view);
    ```

3. 初期化

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

4. アプリを起動することで、設定に応じたLayoutが表示されます。

## 初期化 詳細

### 決済実行

#### 定義
|Method|説明|
|----|----|
|public void initForPayment(FincodePaymentConfiguration config, FincodeCallback\<FincodePaymentResponse> callback)|コンポーネントの初期化を行い、決済実行APIを実行します|

#### 第1引数
|Class|説明|
|----|----|
|FincodePaymentConfiguration|初期化情報|

|変数名|必須|説明|備考|
|----|:--:|----|----|
|authorization|〇|認証方式|BASIC: Basic認証、BEARER: Bearer認証|
|apiKey|〇|パブリックキー|Basic認証の場合は、Base64でエンコード|
|apiVersion| |マイナーバージョン|書式: YYYYMMDD (例) 20211001|
|customerId| |顧客ID| |
|payType|〇|決済種別| |
|accessId|〇|取引ID| |
|id|〇|オーダーID| |

#### 第2引数
|Interface|説明|
|----|----|
|FincodeCallback\<FincodePaymentResponse>|決済の実行結果を返すコールバック|

|Method|説明|
|----|----|
|onResponse|決済実行APIの正常Response|
|onFailure|決済実行APIの異常Response|

#### 実装例 (Java)

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
        config.accessId = "qazWSXedcSample";
        config.id = "12345Sample";

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

#### 実装例 (Kotlin)

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vg = findViewById<ViewGroup>(R.id.replace_view)

        val fin = FincodeVerticalView(this, vg)

        val config = FincodePaymentConfiguration()

        config.authorization = Authorization.BEARER
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample"
        config.apiVersion = "20211001"
        config.customerId = "c_HSZkCAxNS2_Sample"
        config.payType = "Card"
        config.accessId = "qazWSXedcSample"
        config.id = "12345Sample"

        fin.initForPayment(config, object : FincodeCallback<FincodePaymentResponse?> {
            override fun onResponse(fincodePaymentResponse: FincodePaymentResponse?) {
                // 正常
            }

            override fun onFailure(fincodeErrorResponse: FincodeErrorResponse) {
                // 異常
            }
        })
    }
```


### カード登録

#### 定義
|Method|説明|
|----|----|
|public void initForCardRegister(FincodeCardRegisterConfiguration config, FincodeCallback\<FincodeCardRegisterResponse> callback)|コンポーネントの初期化を行い、カード登録APIを実行します|

#### 第1引数
|Class|説明|
|----|----|
|FincodeCardRegisterResponse|初期化情報|

|変数名|必須|説明|備考|
|----|:--:|----|----|
|authorization|〇|認証方式|BASIC: Basic認証、BEARER: Bearer認証|
|apiKey|〇|パブリックキー|Basic認証の場合は、Base64でエンコード|
|apiVersion| |マイナーバージョン|書式: YYYYMMDD (例) 20211001|
|customerId|〇|顧客ID| |
|defaultFlg|〇|デフォルトフラグ|ONまたはOFF|

#### 第2引数
|Interface|説明|
|----|----|
|FincodeCallback\<FincodeCardRegisterResponse>|カード登録の実行結果を返すコールバック|

|Method|説明|
|----|----|
|onResponse|カード登録APIの正常Response|
|onFailure|カード登録APIの異常Response|

#### 実装例 (Java)

```
import fincodesdk;

public class CardRegisterView extends Activity implements FincodeCallback<FincodeCardRegisterResponse> {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

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
    public void onResponse(FincodeCardRegisterResponse fincodeCardRegisterResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }
}
```

#### 実装例 (Kotlin)

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vg = findViewById<ViewGroup>(R.id.replace_view)

        val fin = FincodeVerticalView(this, vg)

        val config = FincodeCardRegisterConfiguration()
        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2_Sample";
        config.defaultFlg = DefaultFlg.ON;

        fin.initForCardRegister(config, object : FincodeCallback<FincodeCardRegisterResponse?> {
            override fun onResponse(fincodeCardRegisterResponse: FincodeCardRegisterResponse?) {
                // 正常
            }

            override fun onFailure(fincodeErrorResponse: FincodeErrorResponse) {
                // 異常
            }
        })
    }
```

### カード更新

#### 定義
|Method|説明|
|----|----|
|public void initForCardUpdate(FincodeCardUpdateConfiguration config, FincodeCallback\<FincodeCardUpdateResponse> callback)|コンポーネントの初期化を行い、カード更新APIを実行します|

#### 第1引数
|Class|説明|
|----|----|
|FincodeCardUpdateConfiguration|初期化情報|

|変数名|必須|説明|備考|
|----|:--:|----|----|
|authorization|〇|認証方式|BASIC: Basic認証、BEARER: Bearer認証|
|apiKey|〇|パブリックキー|Basic認証の場合は、Base64でエンコード|
|apiVersion| |マイナーバージョン|書式: YYYYMMDD (例) 20211001|
|customerId|〇|顧客ID| |
|defaultFlg|〇|デフォルトフラグ|ONまたはOFF|
|cardId|〇|カードID| |

#### 第2引数
|Interface|説明|
|----|----|
|FincodeCallback\<FincodeCardUpdateResponse>|カード更新の実行結果を返すコールバック|

|Method|説明|
|----|----|
|onResponse|カード更新APIの正常Response|
|onFailure|カード更新APIの異常Response|

#### 実装例 (Java)

```
import fincodesdk;

public class CardUpdateView extends Activity implements FincodeCallback<FincodeCardUpdateResponse> {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

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

#### 実装例 (Kotlin)

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vg = findViewById<ViewGroup>(R.id.replace_view)

        val fin = FincodeVerticalView(this, vg)

        val config = FincodeCardUpdateConfiguration()
        config.authorization = Authorization.BEARER;
        config.apiKey = "p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample";
        config.apiVersion = "20211001";
        config.customerId = "c_HSZkCAxNS2_Sample";
        config.defaultFlg = DefaultFlg.ON;
        config.cardId = "cs_UrDeMDBlQ_Sample"

        fin.initForCardUpdate(config, object : FincodeCallback<FincodeCardUpdateResponse?> {
            override fun onResponse(fincodeCardUpdateResponse: FincodeCardUpdateResponse?) {
                // 正常
            }

            override fun onFailure(fincodeErrorResponse: FincodeErrorResponse) {
                // 異常
            }
        })
    }
```

## Repository
FincodeSDKは、以下のAPIを実行するメソッドを用意しています。

|API|Class|Method|
|:--|:--|:--|
|決済実行|FincodePaymentRepository|public void payment(HashMap\<String, String> header, String orderId, FincodePaymentRequest request, FincodeCallback\<FincodePaymentResponse> fincodeCallback)|
|認証後決済|FincodePaymentRepository|public void paymentSecure(HashMap<String, String> header, String id, FincodePaymentSecureRequest request, FincodeCallback<FincodePaymentSecureResponse> fincodeCallback)|
|3DS2.0認証実行|FincodeAuthRepository|public void authentication(HashMap<String, String> header, String id, FincodeAuthRequest request, FincodeCallback<FincodeAuthResponse> fincodeCallback)|
|3DS2.0認証結果取得|FincodeAuthRepository|public void getResult(HashMap<String, String> header, String id, FincodeCallback<FincodeGetResultResponse> fincodeCallback)|
|カード_一覧取得|FincodeCardOperateRepository|public void getCardInfoList(HashMap\<String, String> header, String customerId, FincodeCallback\<FincodeCardInfoListResponse> fincodeCallback)|
|カード_登録|FincodeCardOperateRepository|public void cardRegister(HashMap\<String, String> header, String customerId, FincodeCardRegisterRequest cardInfoRequest, FincodeCallback\<FincodeCardRegisterResponse> fincodeCallback)|
|カード_更新|FincodeCardOperateRepository|public void cardUpdate(HashMap\<String, String> header, String customerId, String cardId, FincodeCardUpdateRequest cardInfoRequest, FincodeCallback\<FincodeCardUpdateResponse> fincodeCallback)|


---

### 決済実行

#### 実装例 (Java)

```
HashMap<String, String> header = new HashMap<String, String>();
    header.put("Content-Type", "application/json");
    header.put("Authorization", "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA");

    FincodePaymentRequest req = new FincodePaymentRequest();
    req.setPayType("Card");
    req.setAccessId("a_Ck1ASkYXRimtmgla4YIHgg");
    req.setOrderId("o_u1xu3m6VREu3CJsF7Csoxg");
    req.setHolderName("Test Card");
    req.setMethod("1");
    req.setSecurityCode("123");
    req.setTds2RetUrl("https://pt01.mul-pay.jp/st/payment/test/postReceiver.jsp");
    req.setCardNo("4100000000005000");
    req.setExpire("2508");

    FincodePaymentRepository.getInstance().payment(header, "o_u1xu3m6VREu3CJsF7Csoxg", req, new FincodeCallback<FincodePaymentResponse>() {
        @Override
        public void onResponse(FincodePaymentResponse fincodePaymentResponse) {
            Log.d("Success", "");
        }

        @Override
        public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
            Log.d("Failure", "");
        }
});
```

#### 実装例 (Kotlin)

```
var header = HashMap<String, String>()
    header.put("Content-Type", "application/json")
    header.put(
        "Authorization",
        "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA"
    )

    var req = FincodePaymentRequest()
    req.payType = "Card"
    req.accessId = "a_Ck1ASkYXRimtmgla4YIHgg"
    req.orderId = "o_u1xu3m6VREu3CJsF7Csoxg"
    req.holderName = "Test Card"
    req.method = "1"
    req.securityCode = "123"
    req.tds2RetUrl = "https://pt01.mul-pay.jp/st/payment/test/postReceiver.jsp"
    req.cardNo = "4100000000005000"
    req.expire = "2508"

    FincodePaymentRepository.getInstance().payment(header, "o_9nLaTocJRUeC9Fp8gpUZ-A", req, object : FincodeCallback<FincodePaymentResponse?> {
        override fun onResponse(p0: FincodePaymentResponse?) {
            Log.d("Success", "")
        }

        override fun onFailure(p0: FincodeErrorResponse?) {
            Log.d("Failure", "")
        }
})
```

#### FincodePaymentRequest プロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|備考|
|:--|:--|:--|:--|:--|:--|:--|
|決済種別|payType|〇|String|1|50| |
|取引ID|accessId|〇|String|24|24| |
|オーダーID|id|〇|String|1|30| |
|トークン|token|△|String|1|512|カード番号入力方式：トークン方式の場合 必須|
|カード番号|cardNo|△|String|10|16|ード番号入力方式：直接方式の場合 必須|
|有効期限|expire|△|String|4|4|カード番号入力方式：直接方式の場合 必須|
|顧客ID|customerId|△|String|1|60|カード番号入力方式：顧客ID方式の場合 必須|
|カードID|cardId|△|String|25|25|カード番号入力方式：顧客ID方式の場合 必須|
|支払方法|method| |String|1|1|1：一括  2：分割|
|支払回数|payTimes| |String|1|2|支払方法にて、分割を指定していた場合  必須|
|セキュリティコード|securityCode| |String|4|4| |
|カード名義人|holderName| |String|1|50|カード番号入力方式：顧客ID方式の場合 は登録時のカード名義人が優先されます|
|加盟店戻りURL|tds2RetUrl| |String|1|256|"ここから、3DS2.0の項目<br>tds_type が 2 ：行う（3DS2.0を利用）の場合のみ入力チェックを行う"|
|3DSリクエスター アカウント最終更新日|tds2ChAccChange| |String|8|8|yyyyMMdd形式|
|3DSリクエスター アカウント開設日|tds2ChAccDate| |String|8|8|yyyyMMdd形式|
|3DSリクエスター アカウントパスワード変更日|tds2ChAccPwChange| |String|8|8|yyyyMMdd形式|
|過去6ヶ月間の購入回数|tds2NbPurchaseAccount| |String|1|4| |
|カード登録日|tds2PaymentAccAge| |String|8|8|yyyyMMdd形式|
|過去24時間のカード追加の試行回数|tds2ProvisionAttemptsDay| |String|1|3| |
|出荷先住所の最初の使用日|tds2ShipAddressUsage| |String|8|8|yyyyMMdd形式|
|カード顧客名と出荷先名の一致/不一致情報|tds2ShipNameInd| |String|2|2|"カード顧客の顧客名と取引に使用される配送先名の一致/不一致を設定<br>01 = カード顧客名と配送先名が一致<br>02 = カード顧客名と配送先名が不一致"|
|アカウントの不審行為情報|tds2SuspiciousAccActivity| |String|2|2|"カード顧客で、不審な行動（過去の不正行為を含む）を加盟店様が発見したかどうかを設定<br>01 = 不審な行動は見られなかった<br>02 = 不審な行動が見られた"|
|過去24時間の取引回数|tds2TxnActivityDay| |String|1|3| |
|前年の取引回数|tds2TxnActivityYear| |String|1|3| |
|ログイン証跡|tds2ThreeDsReqAuthData|△|String|1|2048|"ログイン証跡を設定した場合<br><br>ログイン方法/ログイン日時の設定が必要"|
|ログイン方法|tds2ThreeDsReqAuthMethod|△|String|2|2|"ログイン方法を設定した場合<br><br>ログイン証跡/ログイン日時の設定が必要<br><br>01 = 認証なし（ゲストとしてログイン）<br>02 = 加盟店様自身の認証情報<br>03 = SSO(シングルサインオン)<br>04 = イシュアーの認証情報<br>05 = サードパーティ認証<br>06 = FIDO認証"|
|ログイン日時|tds2ThreeDsReqAuthTimestamp|△|String|12|12|"ログイン日時を設定した場合<br>ログイン証跡/ログイン方法の設定が必要<br><br>YYYYMMDDHHMM形式"|
|請求先住所と配送先住所の一致/不一致情報|tds2AddrMatch| |String|1|1|"カード顧客の配送先住所とカード顧客の請求先住所の一致/不一致の設定が必要<br>Y=一致<br>N=不一致"|
|カード顧客の請求先住所の都市|tds2BillAddrCity| |String|1|50| |
|カード顧客の請求先住所の国コード|tds2BillAddrCountry| |String|1|3| |
|カード顧客の請求先住所の区域部分の１行目|tds2BillAddrLine1| |String|1|50| |
|カード顧客の請求先住所の区域部分の２行目|tds2BillAddrLine2| |String|1|50| |
|カード顧客の請求先住所の区域部分の３行目|tds2BillAddrLine3| |String|1|50| |
|カード顧客の請求先住所の郵便番号|tds2BillAddrPostCode| |String|1|16| |
|カード顧客の請求先住所の州または都道府県コード|tds2BillAddrState| |String|1|3| |
|カード顧客のメールアドレス|tds2Email| |String|1|254| |
|自宅電話の国コード|tds2HomePhoneCc|△|String|1|3|"自宅電話の国コードを設定した場合<br>自宅電話番号の設定が必要"|
|自宅電話番号|tds2HomePhoneNo|△|String|1|15|"自宅電話番号を設定した場合<br><br>自宅電話の国コードの設定が必要<br><br>ハイフン（-）なし、数字のみ"|
|携帯電話の国コード|tds2MobilePhoneCc|△|String|1|3|"携帯電話の国コードを設定した場合<br><br>携帯電話番号の設定が必要"|
|携帯電話番号|tds2MobilePhoneNo|△|String|1|15|"携帯電話番号の国コードを設定した場合<br><br>携帯電話の国コードの設定が必要<br><br>ハイフン（-）なし、数字のみ"|
|職場電話の国コード|tds2WorkPhoneCc|△|String|1|3|"職場電話の国コードを設定した場合<br><br>職場電話番号の設定が必要"|
|職場電話番号|tds2WorkPhoneNo|△|String|1|15|"職場電話番号を設定した場合<br><br>職場電話の国コードの設定が必要<br><br>ハイフン（-）なし、数字のみ"|
|出荷先住所の都市|tds2ShipAddrCity| |String|1|50| |
|出荷先住所の国コード|tds2ShipAddrCountry| |String|1|3| |
|出荷先住所の区域部分の１行目|tds2ShipAddrLine1| |String|1|50| |
|出荷先住所の区域部分の２行目|tds2ShipAddrLine2| |String|1|50| |
|出荷先住所の区域部分の３行目|tds2ShipAddrLine3| |String|1|50| |
|出荷先住所の郵便番号|tds2ShipAddrPostCode| |String|1|16| |
|出荷先住所の州または都道府県コード|tds2ShipAddrState| |String|1|3| |
|納品先電子メールアドレス|tds2DeliveryEmailAddress| |String|1|254| |
|商品納品時間枠|tds2DeliveryTimeframe| |String|2|2|"01 = 電子デリバリー<br>02 = 当日出荷<br>03 = 翌日出荷<br>04 = 2日目以降の出荷"|
|プリペイドカードまたはギフトカードの総購入金額|tds2GiftCardAmount| |String|1|15| |
|購入されたプリペイドカードまたはギフトカード / コードの総数|tds2GiftCardCount| |String|2|2|0埋め2桁の数字|
|通貨コード|tds2GiftCardCurr| |String|3|3|"※以下のコードは対象外<br>955, 956, 957, 958, 959, 960, 961, 962,<br>963, 964, 999"|
|商品の発売予定日|tds2PreOrderDate| |String|8|8|YYYYMMDD形式|
|商品の販売時期情報|tds2PreOrderPurchaseInd| |String|2|2|"01 = 発売済み商品<br>02 = 先行予約商品"|
|商品の注文情報|tds2ReorderItemsInd| |String|2|2|"01 = 初回注文<br>02 = 再注文"|
|取引の出荷方法|tds2ShipInd| |String|2|2|"01 = カード顧客の請求先住所に配送する<br>02 = 加盟店様が保持している別の、確認済み住所に配送する<br>03 = カード顧客の請求先住所と異なる住所に配送する<br>04 = 店舗へ配送 / 近所の店舗での受け取り（店舗の住所は配送先住所で指定する）<br>05 = デジタル商品（オンラインサービス、電子ギフトカードおよび償還コードを含む）<br>06 = 配送なし（旅行およびイベントのチケット）<br>07 = その他（ゲーム、配送されないデジタルサービス、電子メディアの購読料など）"|
|継続課金の期限|tds2RecurringExpiry| |String|8|8|YYYYMMDD形式|
|継続課金の課金最小間隔日数|tds2RecurringFrequency| |String|1|4| |

#### 引数一覧

|引数|説明|
|:--|:--|
|HashMap\<String, String> header|リクエスト ヘッダー|
|String orderId|FincodePaymentRequestのorderIdと同値|
|FincodePaymentRequest request|リクエスト パラメータ|
|FincodeCallback\<FincodePaymentResponse>|API実行結果を処理するインターフェース|

---

### 3DS2.0認証実行

#### 実装例 (Java)

```
HashMap<String, String> header = new HashMap<String, String>();
    header.put("Content-Type", "application/json");
    header.put("Authorization", "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA");

    FincodeAuthRequest req = new FincodeAuthRequest();
    req.setParam("p");
    req.setOrderId("a_ZhohAxsTSQG_TPT3agWNlA");

    FincodeAuthRepository.getInstance().authentication(header, "a_ZhohAxsTSQG_TPT3agWNlA", req, new FincodeCallback<FincodeAuthResponse>() {
        @Override
        public void onResponse(FincodeAuthResponse fincodeAuthResponse) {
            Log.d("Success", "");
        }

        @Override
        public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
            Log.d("Failure", "");
        }
});
```

#### 実装例 (Kotlin)

```
var header = HashMap<String, String>()
    header.put("Content-Type", "application/json")
    header.put(
        "Authorization",
        "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA"
    )

    var req = FincodeAuthRequest()
    req.setParam("p")
    req.setOrderId("a_p7cRDyDkRxuyG-1fHReFVg")

    FincodeAuthRepository.getInstance().authentication(header, "a_p7cRDyDkRxuyG-1fHReFVg", req, object : FincodeCallback<FincodeAuthResponse?> {
            override fun onResponse(p0: FincodeAuthResponse?) {
                Log.d("Success", "")
            }

            override fun onFailure(p0: FincodeErrorResponse?) {
                Log.d("Failure", "")
            }
})
```

#### FincodeAuthRequest プロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|備考|
|:--|:--|:--|:--|:--|:--|:--|
|取引ID|id|〇|String|24|24| |
|ブラウザ情報|param|〇|String|1|2000| |

#### 引数一覧

|引数|説明|
|:--|:--|
|HashMap\<String, String> header|リクエスト ヘッダー|
|String id|FincodeAuthRequestのidと同値|
|FincodeAuthRequest request|リクエスト パラメータ|
|FincodeCallback\<FincodeAuthResponse>|API実行結果を処理するインターフェース|

---

### 3DS2.0認証結果取得

#### 実装例 (Java)

```
HashMap<String, String> header = new HashMap<String, String>();
    header.put("Content-Type", "application/json");
    header.put("Authorization", "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA");

    FincodeAuthRepository.getInstance().getResult(header, "a_ahJ8Cda8TRuUwV1v0zFFTg", new FincodeCallback<FincodeGetResultResponse>() {
        @Override
        public void onResponse(FincodeGetResultResponse fincodeGetResultResponse) {
            Log.d("Success", "");
        }

        @Override
        public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
            Log.d("Failure", "");
        }
});
```

#### 実装例 (Kotlin)

```
var header = HashMap<String, String>()
    header.put("Content-Type", "application/json")
    header.put(
        "Authorization",
        "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA"
    )

    FincodeAuthRepository.getInstance().getResult(header, "a_ahJ8Cda8TRuUwV1v0zFFTg-A", object : FincodeCallback<FincodeGetResultResponse?> {
            override fun onResponse(p0: FincodeGetResultResponse?) {
                Log.d("Success", "")
            }

            override fun onFailure(p0: FincodeErrorResponse?) {
                Log.d("Failure", "")
            }
})
```

#### 引数一覧

|引数|説明|
|:--|:--|
|HashMap\<String, String> header|リクエスト ヘッダー|
|String id|FincodeAuthRequestのidと同値|
|FincodeCallback\<FincodeGetResultResponse>|API実行結果を処理するインターフェース|

---

### 認証後決済

#### 実装例 (Java)

```
HashMap<String, String> header = new HashMap<String, String>();
    header.put("Content-Type", "application/json");
    header.put("Authorization", "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA");

    FincodePaymentSecureRequest req = new FincodePaymentSecureRequest();
    req.setPayType("Card");
    req.setId("o_u1xu3m6VREu3CJsF7Csoxg");
    req.setAccessId("a_Ck1ASkYXRimtmgla4YIHgg");

    FincodePaymentRepository.getInstance().paymentSecure(header, "o_u1xu3m6VREu3CJsF7Csoxg", req, new FincodeCallback<FincodePaymentSecureResponse>() {
        @Override
        public void onResponse(FincodePaymentSecureResponse fincodePaymentSecureResponse) {
            Log.d("Success", "");
        }

        @Override
        public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
            Log.d("Failure", "");
        }
});
```

#### 実装例 (Kotlin)

```
var header = HashMap<String, String>()
    header.put("Content-Type", "application/json")
    header.put(
        "Authorization",
        "Bearer m_test_MDZjMmQ0MTUtZmQ5Ni00YTg5LWIxMWQtYmRmZDIxNzllMjZiODg1N2FhOWEtYzIwOS00ZTUwLTk0OTEtMTNmZmEzMmJjMDFkc18yMjAzMDg5MzA5MA"
    )

    val req = FincodePaymentSecureRequest()
    req.setPayType("Card")
    req.setId("o_u1xu3m6VREu3CJsF7Csoxg")
    req.setAccessId("a_Ck1ASkYXRimtmgla4YIHgg")

        FincodePaymentRepository.getInstance().paymentSecure(header, "o_u1xu3m6VREu3CJsF7Csoxg", req, object : FincodeCallback<FincodePaymentSecureResponse?> {
            override fun onResponse(p0: FincodePaymentSecureResponse?) {
                Log.d("Success", "")
            }

            override fun onFailure(p0: FincodeErrorResponse?) {
                Log.d("Failure", "")
            }
})
```

#### FincodePaymentSecureRequest プロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|備考|
|:--|:--|:--|:--|:--|:--|:--|
|決済種別|payType|〇|String|1|50| |
|取引ID|accessId|〇|String|24|24| |
|オーダーID|id|〇|String|1|30| |

#### 引数一覧

|引数|説明|
|:--|:--|
|HashMap\<String, String> header|リクエスト ヘッダー|
|String id|FincodePaymentSecureRequestのidと同値|
|FincodePaymentSecureRequest request|リクエスト パラメータ|
|FincodeCallback\<FincodePaymentSecureResponse>|API実行結果を処理するインターフェース|

---
### カード_一覧取得

#### 実装例 (Java)

```
HashMap<String, String> header = new HashMap<String, String>();
header.put("Content-Type", "application/json");
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample");

String customerId = "Sample1";

FincodeCardOperateRepository.getInstance().getCardInfoList(header, customerId, new FincodeCallback<FincodeCardInfoListResponse>() {
    @Override
    public void onResponse(FincodeCardInfoListResponse fincodeCardInfoListResponse) {
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }
});
```

#### 実装例 (Kotlin)

```
var header = HashMap<String, String>()
header.put("Content-Type", "application/json")
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample")

FincodeCardOperateRepository.getInstance().getCardInfoList(header, "Sample1", object : FincodeCallback<FincodeCardInfoListResponse?> {
    override fun onResponse(response: FincodeCardInfoListResponse?) {
        // 正常
    }

    override fun onFailure(errorInfo: FincodeErrorResponse) {
        // 異常
    }
})
```

- 引数一覧

|引数|説明|
|:--|:--|
|HashMap\<String, String>|リクエスト ヘッダー|
|String customerId|顧客ID|
|FincodeCallback\<FincodeCardInfoListResponse>|API実行結果を処理するインターフェース|

---

### カード_登録

#### 実装例 (Java)

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
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }
});
```

#### 実装例 (Kotlin)

```
var header = HashMap<String, String>()
header.put("Content-Type", "application/json")
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample")

var req = FincodeCardRegisterRequest()
req.cardNo = "1234567890123456"
req.expire = "2510"
req.defaltFlag = "1"

FincodeCardOperateRepository.getInstance().cardRegister(header, "Sample1", req, object : FincodeCallback<FincodeCardRegisterResponse?> {
        override fun onResponse(response: FincodeCardRegisterResponse?) {
            // 正常
        }

        override fun onFailure(errorInfo: FincodeErrorResponse) {
            // 異常
        }
})
```

- FincodeCardRegisterRequestプロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|備考|
|:--|:--|:--|:--|:--|:--|:--|
|デフォルトフラグ|defaultFlag|〇|String|1|1|1：ON　0：OFF|
|カード番号|cardNo|△|String|10|16|トークンに入力がある場合は無視、なしの場合は必須。|
|有効期限|expire|△|String|4|4|トークンに入力がある場合は無視、なしの場合は必須。( YYMM形式 )|
|カード名義人|holderName| |String|1|50|トークンに入力がある場合は無視。|
|セキュリティコード|securityCode| |String|3|4|トークンに入力がある場合は無視。|
|トークン|token| |String|1|512| |

- 引数一覧

|引数|説明|
|:--|:--|
|HashMap\<String, String> header|リクエスト ヘッダー|
|String customerId|顧客ID|
|FincodeCardRegisterRequest cardInfoRequest|リクエスト パラメータ|
|FincodeCallback\<FincodeCardRegisterResponse>|API実行結果を処理するインターフェース|

---

### カード_更新

#### 実装例 (Java)

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
        // 正常
    }

    @Override
    public void onFailure(FincodeErrorResponse fincodeErrorResponse) {
        // 異常
    }
});
```

#### 実装例 (Kotlin)

```
var header = HashMap<String, String>()
header.put("Content-Type", "application/json")
header.put("Authorization", "Bearer p_prod_ZTlkN2JkMzctZDY4Ni00ZDE4LTSample")

val req = FincodeCardUpdateRequest()
req.expire = "2501"

FincodeCardOperateRepository.getInstance().cardUpdate(header, "Sample1", "cs_1a4TiE_eT0GQ2QB7Sample", req, object : FincodeCallback<FincodeCardUpdateResponse?> {
    override fun onResponse(response: FincodeCardUpdateResponse?) {
        // 正常
    }

    override fun onFailure(errorInfo: FincodeErrorResponse) {
        // 異常
    }
})
```

- FincodeCardUpdateRequestプロパティ一覧

|項目名|プロパティ名|必須|型|最小桁数|最大桁数|備考|
|:--|:--|:--|:--|:--|:--|:--|
|デフォルトフラグ|defaultFlag|〇|String|1|1|パラメータありの場合のみ更新。  1：ON　（0：OFFは設定不可）|
|有効期限|expire|△|String|4|4|トークンに入力がある場合は無視。  パラメータありの場合のみ更新。 ( YYMM形式 )|
|カード名義人|holderName| |String|1|50|トークンに入力がある場合は無視。  パラメータありの場合のみ更新。|
|セキュリティコード|securityCode| |String|3|4|トークンに入力がある場合は無視。|
|トークン|token| |String|1|512| |

- 引数一覧

|引数|説明|
|:--|:--|
|HashMap\<String, String> header|リクエスト ヘッダー|
|String customerId|顧客ID|
|String cardId|カードID|
|FincodeCardUpdateRequest cardInfoRequest|リクエスト パラメータ|
|FincodeCallback\<FincodeCardUpdateResponse> fincodeCallback|API実行結果を処理するインターフェース|

## Licenses

- [okhttp](https://github.com/square/okhttp/blob/master/LICENSE.txt)
- [retrofit](https://github.com/square/retrofit/blob/master/LICENSE.txt)
- [gson](https://github.com/google/gson/blob/master/LICENSE)