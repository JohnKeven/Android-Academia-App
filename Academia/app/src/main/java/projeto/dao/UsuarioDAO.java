package projeto.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import projeto.controller.IUsuario;
import projeto.database.CriaBanco;
import projeto.object.Usuario;

public class UsuarioDAO extends CriaBanco implements IUsuario{
    public UsuarioDAO(Context context) {
        super(context);
    }

    /** Insere os usuarios no banco de dados*/
    @Override
    public void inserir(Usuario user) {
        String sql;
        sql = "INSERT INTO Usuario(nome, email, senha) " +
                "VALUES ('" + user.getNome() +"', '" + user.getEmail() +"', '" + user.getSenha() + "')";
        super.getDataBase().execSQL(sql);
    }

    /** Pesquisa e verifica se o usuário está cadastrado*/
    @Override
    public boolean pesquisarPorLogin(String email, String senha) {
        String[] colunas = {"email", "senha"};
        String selecao = "email = ? AND senha = ?";
        String[] selecaoArgs = {email, senha};
        Cursor cursor = getDataBase().query("Usuario", colunas, selecao, selecaoArgs, null, null, null);
        int cursorCount = cursor.getCount();

        if (cursorCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Retorna uma lista com todas as cidades*/
    @Override
    public List<Usuario> retornarTodos() {
        List<Usuario> list = new ArrayList<Usuario>();
        String sql = "SELECT * FROM Usuario";
        Cursor cursor = getDataBase().rawQuery(sql, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            list.add(montarUsuario(cursor));
            cursor.moveToNext();
        }

        return list;
    }

    /** Retorna a cidade que o cursor está apontando*/
    private Usuario montarUsuario(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }

        String nome = cursor.getString(cursor.getColumnIndex("nome"));
        String email = cursor.getString(cursor.getColumnIndex("email"));
        String senha = cursor.getString(cursor.getColumnIndex("senha"));

        return new Usuario(nome, email, senha);
    }
}
