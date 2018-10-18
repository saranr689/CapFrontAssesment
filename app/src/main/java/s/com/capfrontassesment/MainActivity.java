package s.com.capfrontassesment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import s.com.capfrontassesment.businesslogic.GetProductListBL;
import s.com.capfrontassesment.model.Content;
import s.com.capfrontassesment.model.GetProductList;
import s.com.capfrontassesment.networkcall.RetrofitNetworkCallback;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_productlistrecyclerview)
    RecyclerView productlistrecyclerview;
    private ProductListAdapter productlistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        productlistrecyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        calltoGetProductList();
    }

    private void calltoGetProductList() {

        GetProductListBL.getProductList(new RetrofitNetworkCallback() {
            @Override
            public void success(Object s) {

                GetProductList getProductList = new Gson().fromJson(s.toString(), GetProductList.class);

                List<Content> content = getProductList.getContent();
                productlistAdapter = new ProductListAdapter(MainActivity.this, content);
                productlistrecyclerview.setAdapter(productlistAdapter);


            }

            @Override
            public void failure(String s) {

            }
        });
    }
}
