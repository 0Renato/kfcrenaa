package com.example.kfcrena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Locale;

public class KfcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<KfcItem> itemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(KfcItem item);
    }

    public KfcAdapter(List<KfcItem> itemList, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType().ordinal();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == KfcItem.Type.PRODUCT.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
            return new ProductViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coupon, parent, false);
            return new CouponViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        KfcItem item = itemList.get(position);
        
        if (holder instanceof ProductViewHolder) {
            ProductViewHolder vh = (ProductViewHolder) holder;
            vh.tvName.setText(item.getName());
            vh.tvPrice.setText(String.format(Locale.getDefault(), "R$ %.2f", item.getPrice()));
            vh.imgProduct.setImageResource(item.getImageRes());
            
            vh.btnQuickAdd.setOnClickListener(v -> {
                CartManager.getInstance().addProduct(new Product(item.getName(), item.getPrice(), item.getImageRes()));
                // Optional: animation or toast
            });
        } else if (holder instanceof CouponViewHolder) {
            CouponViewHolder vh = (CouponViewHolder) holder;
            vh.tvTitle.setText(item.getName());
            vh.tvDescription.setText(item.getDescription());
            vh.imgCoupon.setImageResource(item.getImageRes());
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;
        ImageView imgProduct;
        MaterialButton btnQuickAdd;

        ProductViewHolder(View v) {
            super(v);
            tvName = v.findViewById(R.id.tvProductName);
            tvPrice = v.findViewById(R.id.tvProductPrice);
            imgProduct = v.findViewById(R.id.imgProduct);
            btnQuickAdd = v.findViewById(R.id.btnQuickAdd);
        }
    }

    static class CouponViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;
        ImageView imgCoupon;

        CouponViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvCouponTitle);
            tvDescription = v.findViewById(R.id.tvCouponDescription);
            imgCoupon = v.findViewById(R.id.imgCoupon);
        }
    }
}