package s.com.capfrontassesment.networkcall;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiEndPoints {
    @GET("bins/chou4")
    Call<ResponseBody> getProductList();
}