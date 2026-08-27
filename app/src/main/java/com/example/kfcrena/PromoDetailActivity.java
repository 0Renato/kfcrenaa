package com.example.kfcrena;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class PromoDetailActivity extends AppCompatActivity {
    private Product currentProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo_detail);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        ImageView imgPromo = findViewById(R.id.imgPromoLarge);
        TextView tvTitle = findViewById(R.id.tvPromoTitle);
        TextView tvPrice = findViewById(R.id.tvPromoPrice);
        TextView tvDescription = findViewById(R.id.tvPromoDescription);
        Button btnAdd = findViewById(R.id.btnAddToCart);

        // Get data from intent
        currentProduct = (Product) getIntent().getSerializableExtra("product");
        String description = getIntent().getStringExtra("description");

        if (currentProduct != null) {
            imgPromo.setImageResource(currentProduct.getImageRes());
            tvTitle.setText(currentProduct.getName());
            tvPrice.setText(String.format(Locale.getDefault(), "R$ %.2f", currentProduct.getPrice()));
            if (description != null) {
                tvDescription.setText(description);
            }
        }

        btnAdd.setOnClickListener(v -> {
            if (currentProduct != null) {
                CartManager.getInstance().addProduct(currentProduct);
                Toast.makeText(this, currentProduct.getName() + " adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}