package com.example.kfcrena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditText etNome = findViewById(R.id.etNomeCadastro);
        EditText etEmail = findViewById(R.id.etEmailCadastro);
        EditText etSenha = findViewById(R.id.etSenhaCadastro);
        Button btnFinalizar = findViewById(R.id.btnFinalizarCadastro);
        TextView tvVoltar = findViewById(R.id.tvVoltarLogin);

        btnFinalizar.setOnClickListener(v -> {
            String nome = etNome.getText().toString();
            String email = etEmail.getText().toString();
            String senha = etSenha.getText().toString();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                
                // Navegar para o MainActivity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvVoltar.setOnClickListener(v -> finish());
    }
}