package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditarPerfilActivity extends AppCompatActivity {


    private EditText nomeEditar;
    private EditText telefoneEditar;
    private EditText cpfEditar;
    private EditText senhaEditar;
    private EditText confirmaSenhaEditar;
    private Button botaoAtualizar;
    private Aluno aluno;
    private AlunoDAO alunoDAO;
    private String cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        nomeEditar= findViewById(R.id.nomeEditarId);
        telefoneEditar = findViewById(R.id.telefoneEditarId);
        cpfEditar = findViewById(R.id.cpfEditarId);
        senhaEditar = findViewById(R.id.senhaEditarId);
        confirmaSenhaEditar = findViewById(R.id.confirmaSenhaEditarId);
        botaoAtualizar = findViewById(R.id.botaoAtualizarId);
        Bundle extras = getIntent().getExtras();
        cpf = extras.get("cpf").toString();
        setarInfo(cpf);



    }

    public void setarInfo(String cpf){

        alunoDAO = new AlunoDAO(this);

        aluno = alunoDAO.retornaAluno(cpf);

        nomeEditar.setText(aluno.getId().toString());
        telefoneEditar.setText(aluno.getTelefone().toString());
        cpfEditar.setText(aluno.getCpf().toString());
        senhaEditar.setText(aluno.getSenha().toString());
        confirmaSenhaEditar.setText(aluno.getSenha().toString());



    }


}