package develop.beta1139.mvvmtest.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by tomo on 2017/04/29.
 */

public interface Api {
    @GET("api")
    Observable<ApiData> apiData();

    public static class ApiData {
        public List<Result> results;
    }

    public static class Result {
        public String email;
    }
}
