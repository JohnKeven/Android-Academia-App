package projeto.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import projeto.controller.ICidade;
import projeto.database.CriaBanco;
import projeto.object.Cidade;

public class CidadeDAO extends CriaBanco implements ICidade {

    public CidadeDAO(Context context) {
        super(context);
    }

    /** Insere as cidades no banco de dados*/
    @Override
    public void inserir(Cidade cidade) {
        String sql;
        sql = "INSERT INTO Cidade(descricao) VALUES ('" + cidade.getDescricao() +"')";
        getDataBase().execSQL(sql);
    }

    /** Retorna uma lista com todas as cidades*/
    @Override
    public List<Cidade> retornarTodos() {
        List<Cidade> list = new ArrayList<Cidade>();
        String sql = "SELECT * FROM Cidade";
        Cursor cursor = getDataBase().rawQuery(sql, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            list.add(montarCidade(cursor));
            cursor.moveToNext();
        }

        return list;
    }

    /** Retorna a cidade que o cursor está apontando*/
    private Cidade montarCidade(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }

        String descricao = cursor.getString(cursor.getColumnIndex("descricao"));

        return new Cidade(descricao);
    }
}
