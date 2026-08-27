package com.example.kfcrena;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CouponDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_detail);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        ImageView imgCoupon = findViewById(R.id.imgCouponLarge);
        TextView tvTitle = findViewById(R.id.tvCouponTitle);
        TextView tvExpiry = findViewById(R.id.tvCouponExpiry);
        TextView tvRules = findViewById(R.id.tvCouponRules);
        TextView tvCode = findViewById(R.id.tvCouponCode);
        Button btnCopy = findViewById(R.id.btnCopyCode);

        // Get data from intent
        String title = getIntent().getStringExtra("title");
        int imageRes = getIntent().getIntExtra("imageRes", R.drawable.cupbalde);
        String code = getIntent().getStringExtra("code");
        String rules = getIntent().getStringExtra("rules");

        if (title != null) {
            tvTitle.setText(title);
            imgCoupon.setImageResource(imageRes);
            tvCode.setText(code);
            if (rules != null) {
                tvRules.setText(rules);
            }
        }

        btnCopy.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("KFC Coupon", tvCode.getText().toString());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Código copiado: " + tvCode.getText().toString(), Toast.LENGTH_SHORT).show();
        });
    }
}