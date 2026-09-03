package com.example.kfcrena;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private KfcItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        currentItem = (KfcItem) getIntent().getSerializableExtra("item");

        if (currentItem != null) {
            setupUI();
        }
    }

    private void setupUI() {
        ImageView imgHero = findViewById(R.id.imgDetailHero);
        TextView tvTitle = findViewById(R.id.tvDetailTitle);
        TextView tvSubtitle = findViewById(R.id.tvDetailSubtitle);
        TextView tvDescription = findViewById(R.id.tvDetailDescription);
        MaterialButton btnAction = findViewById(R.id.btnDetailAction);
        LinearLayout layoutCoupon = findViewById(R.id.layoutCouponCode);
        TextView tvCode = findViewById(R.id.tvDetailCode);

        imgHero.setImageResource(currentItem.getImageRes());
        tvTitle.setText(currentItem.getName());
        tvDescription.setText(currentItem.getDescription());

        if (currentItem.getType() == KfcItem.Type.PRODUCT) {
            tvSubtitle.setText(String.format(Locale.getDefault(), "R$ %.2f", currentItem.getPrice()));
            btnAction.setText("ADICIONAR AO CARRINHO");
            layoutCoupon.setVisibility(View.GONE);
            
            btnAction.setOnClickListener(v -> {
                CartManager.getInstance().addProduct(new Product(currentItem.getName(), currentItem.getPrice(), currentItem.getImageRes()));
                Toast.makeText(this, "Adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
            });
        } else {
            tvSubtitle.setText("Cupom Exclusivo");
            btnAction.setText("COPIAR CÓDIGO");
            layoutCoupon.setVisibility(View.VISIBLE);
            tvCode.setText(currentItem.getCode());

            btnAction.setOnClickListener(v -> {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("KFC Coupon", currentItem.getCode());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Código copiado!", Toast.LENGTH_SHORT).show();
            });
        }
    }
}