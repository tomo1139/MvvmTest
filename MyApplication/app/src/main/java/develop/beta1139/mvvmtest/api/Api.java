package develop.beta1139.mvvmtest.api;

import develop.beta1139.mvvmtest.model.ApiData.ApiData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tomo on 2017/04/29.
 */

public interface Api {
    @GET("api")
    Call<ApiData> apiData();
}
