package projeto.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import projeto.controller.IPagamento;
import projeto.database.CriaBanco;
import projeto.object.Pagamento;
import projeto.object.ViewPagamento;

public class PagamentoDAO extends CriaBanco implements IPagamento {
    public PagamentoDAO(Context context) {
        super(context);
    }

    @Override
    public void inserir(Pagamento p) {
        String sql;
        sql = "INSERT INTO Pagamento(id_aluno, data, valor) " +
                "VALUES (" + p.getIdAluno() + ", '" + p.getData() + "', " + p.getValor() + ")";
        getDataBase().execSQL(sql);
    }

    @Override
    public List<ViewPagamento> retornarTodos() {
        List<ViewPagamento> lista = new ArrayList<ViewPagamento>();
        String sql = "SELECT a.nome, p.valor, p.data, s.descricao FROM Pagamento AS p " +
                "     JOIN Aluno AS a ON a.id_aluno = p.id_aluno ";
        Cursor cursor = getDataBase().rawQuery(sql, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            lista.add(montarPagamento(cursor));
            cursor.moveToNext();
        }
        return lista;
    }

    private ViewPagamento montarPagamento(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }

        String aluno = cursor.getString(cursor.getColumnIndex("nome"));
        String data = cursor.getString(cursor.getColumnIndex("data"));
        double valor = cursor.getDouble(cursor.getColumnIndex("valor"));

        return new ViewPagamento(aluno, data, valor);
    }


}
