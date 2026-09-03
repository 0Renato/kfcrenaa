package com.example.kfcrena;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CardapioFragment extends Fragment {

    private RecyclerView rvProducts;
    private KfcAdapter adapter;
    private List<KfcItem> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cardapio, container, false);

        // Configurar Header
        TextView tvTitle = view.findViewById(R.id.tvHeaderTitle);
        if (tvTitle != null) tvTitle.setText(getString(R.string.title_cardapio));

        ImageButton btnCart = view.findViewById(R.id.btnHeaderAction);
        if (btnCart != null) {
            btnCart.setVisibility(View.VISIBLE);
            btnCart.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).setSelectedTab(R.id.nav_carrinho);
                }
            });
        }

        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        rvProducts = view.findViewById(R.id.rvProducts);
        rvProducts.setLayoutManager(new LinearLayoutManager(getContext()));

        productList = new ArrayList<>();
        productList.add(new KfcItem(getString(R.string.item_balde_tradicional), 89.90, R.drawable.baldetrad, getString(R.string.desc_balde_tradicional)));
        productList.add(new KfcItem(getString(R.string.item_kentucky_sandwich), 22.90, R.drawable.lanche, getString(R.string.desc_kentucky_sandwich)));
        productList.add(new KfcItem(getString(R.string.item_batata_grande), 12.90, R.drawable.batata, getString(R.string.desc_batata_grande)));

        adapter = new KfcAdapter(productList, item -> {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("item", item);
            startActivity(intent);
        });

        rvProducts.setAdapter(adapter);
    }
}