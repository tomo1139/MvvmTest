package develop.beta1139.mvvmtest.model;

import develop.beta1139.mvvmtest.api.EmailApi;
import develop.beta1139.mvvmtest.api.HttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tomo on 2017/04/29.
 */

public class MainModel {

    public EmailApi mEmailApi;

    public MainModel() {
        mEmailApi = initEmailApi();
    }

    private EmailApi initEmailApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(HttpClient.getHttpClient())
                .build();
        return retrofit.create(EmailApi.class);
    }
}
