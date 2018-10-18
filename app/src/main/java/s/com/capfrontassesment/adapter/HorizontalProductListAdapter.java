package s.com.capfrontassesment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import s.com.capfrontassesment.R;
import s.com.capfrontassesment.model.Product;

public class HorizontalProductListAdapter extends RecyclerView.Adapter<HorizontalProductListAdapter.ViewHolder> {

    Context context;
    List<Product> products;

    public HorizontalProductListAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_prdt_rowlist_item, null));

    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.product_name_tv.setText(products.get(i).getName() + "");
        Picasso.with(context)
                .load(products.get(i).getImageURL())
                .placeholder(R.drawable.ic_shopping_cart)
                .into(viewHolder.prdtimg);
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView product_name_tv;
        ImageView prdtimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name_tv = (TextView) itemView.findViewById(R.id.id_product_name_tv);
            prdtimg = (ImageView) itemView.findViewById(R.id.id_prdtimg);
        }
    }
}
