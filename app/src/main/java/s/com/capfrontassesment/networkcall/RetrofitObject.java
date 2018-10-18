package s.com.capfrontassesment.networkcall;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    private static Retrofit retrofit;

    private RetrofitObject() {

    }



    public static Retrofit getRetrofitObj(String baseurl) {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseurl)
                    .client(okHttpClient)
                    .build();
            return retrofit;
        } else {

            return retrofit;
        }
    }
}