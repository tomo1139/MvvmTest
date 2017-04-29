package develop.beta1139.mvvmtest.model;

import android.util.Log;

import develop.beta1139.mvvmtest.api.Api;
import develop.beta1139.mvvmtest.api.HttpClient;
import develop.beta1139.mvvmtest.model.ApiData.ApiData;
import develop.beta1139.mvvmtest.model.ApiData.Result;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tomo on 2017/04/29.
 */

public class MainModel {

    public MainModel() {

    }

    public void fetchApi() {
        OkHttpClient httpClient = HttpClient.getHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        Api api = retrofit.create(Api.class);

        api.apiData().enqueue(new Callback<ApiData>() {
            @Override
            public void onResponse(Call<ApiData> call, retrofit2.Response<ApiData> response) {
                if (response.isSuccessful()) {
                    ApiData data = response.body();
                    for (Result result : data.results) {
                        Log.e("dbg", "email: " + result.email);
                    }
                } else {
                    Log.e("dbg", "error_code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ApiData> call, Throwable t) {
                Log.e("dbg", "error t: " + t.toString());
            }
        });
    }
}
