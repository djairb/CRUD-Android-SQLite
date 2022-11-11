package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeuPerfilActivity extends AppCompatActivity {

    private TextView seuPerfilNome;
    private TextView seuPerfilId;
    private TextView seuPerfilTelefone;
    private Button botaoEditar;
    private Button botaoDeletar;
    private AlunoDAO alunoDAO;
    private Aluno aluno;
    private String cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seu_perfil);

        seuPerfilNome = findViewById(R.id.seuPerfilNomeId);
        seuPerfilId = findViewById(R.id.seuPerfilIdid);
        seuPerfilTelefone = findViewById(R.id.seuPerfilTelefoneID);
        botaoDeletar = findViewById(R.id.botaoDeletarId);
        botaoEditar = findViewById(R.id.botaoEditarId);
        Bundle extras = getIntent().getExtras();
        cpf = extras.get("cpf").toString();
        setarInfo(cpf);

        botaoEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(SeuPerfilActivity.this, EditarPerfilActivity.class));
                intent.putExtra("cpf",cpf);
                startActivity(intent);
            }
        });


    }

    public void setarInfo(String cpf){

        alunoDAO = new AlunoDAO(this);
        aluno = alunoDAO.retornaAluno(cpf);
        seuPerfilNome.setText("Nome:\n" + aluno.getNome());
        seuPerfilId.setText("Id:\n" + aluno.getId().toString()) ;
        seuPerfilTelefone.setText("Telefone:\n" + aluno.getTelefone());


    }


}