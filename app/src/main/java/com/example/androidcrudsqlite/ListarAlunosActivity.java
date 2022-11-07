package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListarAlunosActivity extends AppCompatActivity {

    private List<Aluno> alunosTodos;
    private List<Aluno> alunosFiltrados = new ArrayList<>();
    private String cpf;
    private AlunoDAO alunoDAO;
    private Aluno aluno;
    private ListView listaAlunos;
    private TextView alunoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);


        listaAlunos = findViewById(R.id.listaAlunosId);
        alunoNome = findViewById(R.id.nomeAlunoId);
        Bundle extras = getIntent().getExtras();
        cpf = extras.get("cpf").toString();
        alunoDAO = new AlunoDAO(this);
        aluno = alunoDAO.retornaAluno(cpf);
        alunoNome.setText("Bem-vindo(a) ao sistema, " + aluno.getNome());
        encherLista();


    }

    public void encherLista(){

        alunosTodos = alunoDAO.obterTodos();
        alunosFiltrados.addAll(alunosTodos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunosTodos);
        listaAlunos.setAdapter(adapter);

    };

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        return true;


    }



}