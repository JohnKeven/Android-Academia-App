package projeto.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import projeto.controller.IFaixa;
import projeto.database.CriaBanco;
import projeto.object.Faixa;

public class FaixaDAO extends CriaBanco implements IFaixa {
    public FaixaDAO(Context context) {
        super(context);
    }

    @Override
    public void inserir(Faixa faixa) {
        String sql;
        sql = "INSERT INTO Faixa(descricao) VALUES( '"+faixa.getDescricao()+"')";
        getDataBase().execSQL(sql);
    }

    private Faixa montarFaixa(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }

        String descricao = cursor.getString(cursor.getColumnIndex("descricao"));

        return new Faixa(descricao);
    }

    @Override
    public List<Faixa> retornarTodas() {
        List<Faixa> lista = new ArrayList<Faixa>();
        String sql = "SELECT * FROM Faixa";
        Cursor cursor = getDataBase().rawQuery(sql, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            lista.add(montarFaixa(cursor));
            cursor.moveToNext();
        }
        return lista;
    }
}
