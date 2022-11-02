package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText cpfLogin;
    private EditText senhaLogin;
    private Button botaoLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cpfLogin = findViewById(R.id.editTextLoginCpf);
        senhaLogin = findViewById(R.id.editTextLoginSenha);
        botaoLogar = findViewById(R.id.botaoLogin);


    }
}