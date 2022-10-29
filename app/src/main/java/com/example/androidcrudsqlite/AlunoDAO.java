package com.example.androidcrudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AlunoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }

    
}
