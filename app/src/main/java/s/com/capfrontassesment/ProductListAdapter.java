package s.com.capfrontassesment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import s.com.capfrontassesment.model.Content;

class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    public static final int SECTION_VIEW = 0;
    public static final int CONTENT_VIEW = 1;
    // #1 header #2 list
    public static int VIEW_TYPE = 1;

    private final List<Content> content;
    private final Context context;
    int lastposition = 0;

    public ProductListAdapter(Context context, List<Content> content) {

        this.context = context;
        this.content = content;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {


        if (viewtype == 0) {
            return new ProductViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_productlist, null, false));

        } else if (viewtype == 1) {
            return new ProductViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.split_banner, null));
        } else if (viewtype == 2) {
            return new ProductViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.banner_view, null));
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {


        if (content.get(position).getSectionType().equalsIgnoreCase("horizontalFreeScroll")) {
            return 0;

        } else if (content.get(position).getSectionType().equalsIgnoreCase("splitBanner")) {
            return 1;
        } else if (content.get(position).getSectionType().equalsIgnoreCase("banner")) {
            return 2;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int position) {

        if (content.get(position).getSectionType().equalsIgnoreCase("horizontalFreeScroll")) {

            productViewHolder.title.setText(content.get(position).getName());


            if (content.get(position).getSectionType().equalsIgnoreCase("horizontalFreeScroll")) {
                for (int i = 0; i < content.get(position).getProducts().size(); i++) {
                    productViewHolder.product_name.setText(content.get(position).getProducts().get(i).getName());
                    Log.e("_D", "onBindViewHolder: " + content.get(position).getProducts().get(i).getName());
                }
                productViewHolder.rv_product_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                productViewHolder.rv_product_list.setAdapter(new HorizontalProductListAdapter(context, content.get(position).getProducts()));
            }
        } else if (content.get(position).getSectionType().equalsIgnoreCase("splitBanner")) {
            Picasso.with(context)
                    .load(content.get(position).getFirstImage())
                    .placeholder(R.drawable.ic_shopping_cart)
                    .into(productViewHolder.splitbanner_img1);

            Picasso.with(context)
                    .load(content.get(position).getSecondImage())
                    .placeholder(R.drawable.ic_shopping_cart)
                    .into(productViewHolder.splitbanner_img2);
        } else if (content.get(position).getSectionType().equalsIgnoreCase("banner")) {

            Picasso.with(context)
                    .load(content.get(position).getBannerImage())
                    .placeholder(R.drawable.ic_shopping_cart)
                    .into(productViewHolder.banner_img);
        }
    }

    @Override
    public int getItemCount() {

        return content.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView title, product_name;
        RecyclerView rv_product_list;
        LinearLayout split_banner_layout;
        ImageView splitbanner_img1, splitbanner_img2, banner_img;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            product_name = (TextView) itemView.findViewById(R.id.product_name);
            rv_product_list = (RecyclerView) itemView.findViewById(R.id.id_recycler_product_list);
            split_banner_layout = (LinearLayout) itemView.findViewById(R.id.id_split_banner_layout);
            splitbanner_img1 = (ImageView) itemView.findViewById(R.id.splitbanner_img1);
            splitbanner_img2 = (ImageView) itemView.findViewById(R.id.splitbanner_img2);
            banner_img = (ImageView) itemView.findViewById(R.id.banner_img);
        }
    }
}
