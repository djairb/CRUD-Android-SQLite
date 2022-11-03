package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ListarAlunosActivity extends AppCompatActivity {

    private TextView nomeTemp;
    private String cpf;
    private AlunoDAO alunoDAO;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        nomeTemp = findViewById(R.id.editNomeTemp);

        Bundle extras = getIntent().getExtras();
        cpf = extras.get("cpf").toString();
        alunoDAO = new AlunoDAO(this);
        aluno = alunoDAO.retornaAluno(cpf);
        nomeTemp.setText("Bem-vindo a tela de login, " + aluno.getNome());


    }



}