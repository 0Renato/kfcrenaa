package com.example.kfcrena;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

public class CarrinhoFragment extends Fragment {

    private RecyclerView rvCart;
    private CartAdapter adapter;
    private TextView tvTotal;
    private CartManager cartManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        // Configurar Header
        TextView tvTitle = view.findViewById(R.id.tvHeaderTitle);
        if (tvTitle != null) tvTitle.setText("Meu Carrinho");

        cartManager = CartManager.getInstance();
        tvTotal = view.findViewById(R.id.tvTotal);
        rvCart = view.findViewById(R.id.rvCart);
        rvCart.setLayoutManager(new LinearLayoutManager(getContext()));

        setupAdapter();
        updateTotal();

        Button btnCheckout = view.findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(v -> {
            if (cartManager.getCartItems().isEmpty()) {
                Toast.makeText(getContext(), "Seu carrinho está vazio!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Pedido finalizado com sucesso!", Toast.LENGTH_LONG).show();
                cartManager.clearCart();
                updateTotal();
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    private void setupAdapter() {
        adapter = new CartAdapter(cartManager.getCartItems(), product -> {
            cartManager.removeProduct(product);
            adapter.notifyDataSetChanged();
            updateTotal();
            Toast.makeText(getContext(), product.getName() + " removido", Toast.LENGTH_SHORT).show();
        });
        rvCart.setAdapter(adapter);
    }

    private void updateTotal() {
        double total = cartManager.getTotalPrice();
        tvTotal.setText(String.format(Locale.getDefault(), "R$ %.2f", total));
    }
}