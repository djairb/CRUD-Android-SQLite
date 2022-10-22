package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroAlunoActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        nome = findViewById(R.id.editNomeCampo);
        cpf = findViewById(R.id.editCpfCampo);
        telefone = findViewById(R.id.editTelefoneCampo);
        salvar = findViewById(R.id.botaoSalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno aluno = new Aluno();
                aluno.setCpf(cpf.getText().toString());
                aluno.setNome(nome.getText().toString());
                aluno.setTelefone(telefone.getText().toString());

            }
        });

    }
}