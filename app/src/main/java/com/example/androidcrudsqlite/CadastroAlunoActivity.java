package com.example.androidcrudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class CadastroAlunoActivity extends AppCompatActivity implements Serializable {

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
                if(validarCampos()){
                    montarAluno();

                }

            }
        });

    }
    public void montarAluno(){
        Aluno aluno = new Aluno();
        aluno.setCpf(cpf.getText().toString());
        aluno.setNome(nome.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        Toast.makeText(this, "Suscesso ao criar a classe aluno.", Toast.LENGTH_LONG).show();
    }


    private boolean validarCampos(){

        boolean erro = true;
        if (validarCpf()){
            erro = false;
        }
        if (validarNome()){
            erro = false;
        }
        if(validarTelefone()){
            erro = false;
        }
        return erro;




    }

    private boolean validarCpf(){

        boolean erro = false;
        String cpfString = cpf.getText().toString().trim();
        if(cpfString.isEmpty()){
            erro = true;
            cpf.setError("Campo em branco");
        }else if(cpfString.length() != 11){
            erro = true;
            cpf.setError("Cpf não em 11 dígitos");
        }else if(!cpfString.matches("[0-9]+")){
            erro = true;
            cpf.setError("Cpf não contem apenas numeros");
        }
        return erro;

    }

    private boolean validarNome(){

        boolean erro = false;
        String nomeString = nome.getText().toString().trim();
        if(nomeString.isEmpty()){
            erro = true;
            nome.setError("Campo em braco");
        }
        return erro;

    }

    private boolean validarTelefone(){

        boolean erro = false;
        String telefoneString = telefone.getText().toString().trim();
        if (telefoneString.isEmpty()){
            erro = true;
            telefone.setError("Campo em branco");
        } else if(!telefoneString.matches("[0-9]+")){
            erro = true;
            telefone.setError("Telefone não contem apenas numeros");
        }
        return erro;

    }

}