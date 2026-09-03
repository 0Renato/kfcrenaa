package com.example.kfcrena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Product> cartItems;
    private OnItemRemovedListener listener;

    public interface OnItemRemovedListener {
        void onItemRemoved(Product product);
    }

    public CartAdapter(List<Product> cartItems, OnItemRemovedListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrinho, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Product product = cartItems.get(position);
        holder.tvNome.setText(product.getName());
        holder.tvPreco.setText(String.format(Locale.getDefault(), "R$ %.2f", product.getPrice()));
        holder.imgItem.setImageResource(product.getImageRes());

        holder.btnRemove.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemRemoved(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvPreco;
        ImageView imgItem;
        ImageButton btnRemove;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tvNomeItem);
            tvPreco = itemView.findViewById(R.id.tvPrecoItem);
            imgItem = itemView.findViewById(R.id.imgItem);
            btnRemove = itemView.findViewById(R.id.btnRemoveItem);
        }
    }
}