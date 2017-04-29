package develop.beta1139.mvvmtest.api;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by tomo on 2017/04/29.
 */

public class HttpClient {

    private static OkHttpClient mHttpClient;

    public static OkHttpClient getHttpClient() {
        if (mHttpClient == null) {
            initHttpClient();
        }
        return mHttpClient;
    }

    private static void initHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("API LOG", message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        mHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
    }
}
