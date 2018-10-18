package s.com.capfrontassesment.networkcall;

import android.util.Log;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RetrofitHelper {
    Retrofit retrofit;
    String baseurl = "https://api.myjson.com/";


    public <E> void callApiGETJSON(String function, Class<String> stringClass, final RetrofitNetworkCallback<String> retrofitNetworkCallback) {

        ApiEndPoints apiEndPoints = RetrofitObject.getRetrofitObj(baseurl).create(ApiEndPoints.class);
        try {
            Method methodname = apiEndPoints.getClass().getDeclaredMethod(function);
            Call<E> mycall = (Call<E>) methodname.invoke(apiEndPoints);
            mycall.enqueue(new Callback<E>() {
                @Override
                public void onResponse(Call<E> call, Response<E> response) {

                    ResponseBody responseBody = (ResponseBody) response.body();

                    try {
                        retrofitNetworkCallback.success(responseBody.string());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<E> call, Throwable t) {

                    retrofitNetworkCallback.failure(t.getMessage());
                }
            });


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
