package s.com.capfrontassesment.businesslogic;

import android.util.Log;

import s.com.capfrontassesment.networkcall.RetrofitHelper;
import s.com.capfrontassesment.networkcall.RetrofitNetworkCallback;


public class GetProductListBL {


    public static void getProductList(final RetrofitNetworkCallback callback) {

        new RetrofitHelper().callApiGETJSON("getProductList", String.class, new RetrofitNetworkCallback<String>() {
            @Override
            public void success(String s) {

                Log.d("_D", "success: " + s);

                callback.success(s);

            }

            @Override
            public void failure(String s) {
                Log.d("_D", "success: " + s);
                callback.failure(s);

            }
        });
    }


}
