package com.example.androidcrudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AlunoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }
    public long inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("telefone", aluno.getTelefone());
        return banco.insert("aluno", null, values);

    }

    public boolean existeCpf(String cpf){
        Cursor cursor = banco.query("aluno", new String[]{"cpf"}, "cpf = ?", new String[]{cpf}, null, null, null);
        boolean resposta = false;
        if(cursor.getCount() > 0){
            resposta = true;
        }
        return resposta;
    }




}
