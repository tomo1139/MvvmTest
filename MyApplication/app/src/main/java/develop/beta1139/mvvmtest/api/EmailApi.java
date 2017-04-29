package develop.beta1139.mvvmtest.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by tomo on 2017/04/29.
 */

public interface EmailApi {
    @GET("api")
    Observable<ApiData> apiData();

    class ApiData {
        public List<Result> results;
    }

    class Result {
        public String email;
    }
}
