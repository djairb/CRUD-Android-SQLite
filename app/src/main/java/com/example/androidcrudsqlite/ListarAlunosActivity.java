package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListarAlunosActivity extends AppCompatActivity {

    private List<Aluno> alunosTodos;
    private List<Aluno> alunosOutros = new ArrayList<>();
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

        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Aluno alunoIr = alunosOutros.get(position);
                irPraOutroPerfil(alunoIr.getCpf());

            }
        });




    }

    public void encherLista(){

        alunosTodos = alunoDAO.obterTodos();

        for (Aluno aluno : alunosTodos){
            String cpfOutro = aluno.getCpf();
            if (!cpfOutro.equals(cpf)){
                alunosOutros.add(aluno);
                String a = "a";
            }

        }

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunosOutros);
        listaAlunos.setAdapter(adapter);

    };

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        return true;

    }

    public void perfilUser(MenuItem item){
        startActivity(new Intent(ListarAlunosActivity.this, CadastroAlunoActivity.class));
    }


    public void irPraOutroPerfil(String cpf){

        Intent intent = new Intent(new Intent(ListarAlunosActivity.this, PerfilUserActivity.class));
        intent.putExtra("cpf",cpf);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}