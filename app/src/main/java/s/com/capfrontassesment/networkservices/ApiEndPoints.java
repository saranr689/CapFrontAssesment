package s.com.capfrontassesment.networkservices;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {
    @GET("bins/chou4")
    Call<ResponseBody> getProductList();
}