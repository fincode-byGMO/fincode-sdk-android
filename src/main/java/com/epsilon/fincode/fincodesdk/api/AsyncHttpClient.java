package com.epsilon.fincode.fincodesdk.api;

import java.util.concurrent.TimeUnit;
import com.epsilon.fincode.fincodesdk.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by a.nakajima on 2022/06/13.
 */
public class AsyncHttpClient {

    private static AsyncHttpClient instance;
    private OkHttpClient client;

    private final long CONNECT_TIMEOUT = 10;
    private final long WRITE_TIMEOUT = 10;
    private final long READ_TIMEOUT = 30;

    public static AsyncHttpClient getInstance() {
        if(instance == null) {
            instance = new AsyncHttpClient();
        }
        return instance;
    }

    private AsyncHttpClient() {
        // TODO ログ出力しないように修正する
        client = getHttpClientWithLogging();
        //client = getHttpClientWithoutLogging();
    }

    public <T> T getAsyncHttpClient(Class<T> type) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(type);
    }

    private OkHttpClient getHttpClientWithoutLogging() {
        return  new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    private OkHttpClient getHttpClientWithLogging() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
}
