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
        values.put("senha", aluno.getSenha());
        return banco.insert("aluno", null, values);

    }

    public boolean existeCpf(String cpf){
       ///Cursor cursor = banco.query("aluno", new String[]{"cpf"}, "cpf = ?", new String[]{cpf}, null, null, null);
        boolean resposta = false;
        String where = "SELECT cpf FROM aluno WHERE cpf = '" + cpf + "'";
        Cursor cursor = banco.rawQuery(where, null);
        if(cursor.getCount() > 0){
            resposta = true;
        }
        return resposta;
    }

    public boolean comparaSenha(String cpf, String senha){
        Aluno aluno1 = new Aluno();
        boolean resposta = false;
        String where = "SELECT * FROM aluno WHERE cpf = '" + cpf + "'";
        Cursor cursor = banco.rawQuery(where, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            aluno1.setId(cursor.getInt(0));
            aluno1.setNome(cursor.getString(1));
            aluno1.setCpf(cursor.getString(2));
            aluno1.setTelefone(cursor.getString(3));
            aluno1.setSenha(cursor.getString(4));
        }
        if(aluno1.getSenha().equals(senha)){
             resposta = true;
         }
        return resposta;
    }

    public void acabarTudo(){
        banco.delete("aluno", null, null);

    }


    public Aluno retornaAluno(String cpf){
        Aluno aluno1 = new Aluno();
        boolean resposta = false;
        String where = "SELECT * FROM aluno WHERE cpf = '" + cpf + "'";
        Cursor cursor = banco.rawQuery(where, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            aluno1.setId(cursor.getInt(0));
            aluno1.setNome(cursor.getString(1));
            aluno1.setCpf(cursor.getString(2));
            aluno1.setTelefone(cursor.getString(3));
            aluno1.setSenha(cursor.getString(4));
        }
        return aluno1;


    }



}
