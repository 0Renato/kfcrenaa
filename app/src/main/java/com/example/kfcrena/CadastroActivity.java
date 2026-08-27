package com.example.kfcrena;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnFinalizar = findViewById(R.id.btnFinalizarCadastro);
        TextView tvVoltar = findViewById(R.id.tvVoltarLogin);

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
            finish(); // Volta para o login
        });

        tvVoltar.setOnClickListener(v -> finish());
    }
}