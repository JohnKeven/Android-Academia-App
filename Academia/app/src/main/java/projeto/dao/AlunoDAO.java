package projeto.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import projeto.controller.IAluno;
import projeto.database.CriaBanco;
import projeto.object.Aluno;
import projeto.object.ViewAluno;
import projeto.object.ViewTodosDadosAluno;

public class AlunoDAO extends CriaBanco implements IAluno {
    public AlunoDAO(Context context) {
        super(context);
    }

    /** Insere os alunos no banco de dados*/
    @Override
    public void inserir(Aluno a) {
        String sql;
        sql = "INSERT INTO Aluno(nome, contato, cpf, idade, id_cidade, bairro, logadouro, data_cadastro, id_faixa) " +
                "VALUES('" + a.getNome()            + "', '" +
                             a.getContato()         + "', '" +
                             a.getCpf()             + "',  " +
                             a.getIdade()           + " ,  " +
                             a.getIdCidade()        + " , '" +
                             a.getBairro()          + "', '" +
                             a.getLogadouro()       + "', '" +
                             a.getDataCadastro()    + "',  " +
                             a.getFaixa()           + "   )";

        getDataBase().execSQL(sql);
    }

    /**=====================================================================================================================*/
    /** Edita os alunos do banco de dados*/
    @Override
    public void editar(Aluno a, int id) {
        String sql;

        sql = "UPDATE Aluno " +
                "SET      nome          = '" + a.getNome()         + "', " +
                "         contato       = '" + a.getContato()      + "', " +
                "         cpf           = '" + a.getCpf()          + "', " +
                "         idade         =  " + a.getIdade()        + " , " +
                "         id_cidade     =  " + a.getIdCidade()     + " , " +
                "         bairro        = '" + a.getBairro()       + "', " +
                "         logadouro     = '" + a.getLogadouro()    + "', " +
                "         data_cadastro = '" + a.getDataCadastro() + "', " +
                "         id_faixa      =  " + a.getFaixa()        + "   " +
                "WHERE    id_aluno      =  " + id;

        getDataBase().execSQL(sql);
    }

    /**=====================================================================================================================*/
    /** Remove os alunos do banco de dados*/
    @Override
    public void remover(int id) {
        String sql;
        sql = "DELETE FROM Aluno " +
                "WHERE id_aluno = " + id;

        getDataBase().execSQL(sql);
    }

    /**=====================================================================================================================*/
    /** Retorna uma lista com todos os Alunos com os dados resumidos*/
    @Override
    public List<ViewAluno> retornarTodos() {
        List<ViewAluno> list = new ArrayList<ViewAluno>();
        String sql = "SELECT id_aluno, nome, cpf FROM Aluno";
        Cursor cursor = getDataBase().rawQuery(sql, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            list.add(montarViewAluno(cursor));
            cursor.moveToNext();
        }

        return list;
    }

    /** Retorna o Aluno que o cursor está apontando*/
    private ViewAluno montarViewAluno(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }

        int id = cursor.getInt(cursor.getColumnIndex("id_aluno"));
        String nome = cursor.getString(cursor.getColumnIndex("nome"));
        String cpf = cursor.getString(cursor.getColumnIndex("cpf"));

        return new ViewAluno(id, nome, cpf);
    }

    /**=====================================================================================================================*/
    /** Retorna um Aluno com todos os dados*/
    @Override
    public List<ViewTodosDadosAluno> retornarDados(int id) {
        List<ViewTodosDadosAluno> list = new ArrayList<ViewTodosDadosAluno>();
        String sql = "SELECT     a.id_aluno         AS [Matricula],              " +
                     "           a.nome             AS [Nome],                   " +
                     "           a.cpf              AS [CPF],                    " +
                     "           a.idade            AS [Idade],                  " +
                     "           a.contato          AS [Contato],                " +
                     "           c.descricao        AS [Cidade],                 " +
                     "           a.bairro           AS [Bairro],                 " +
                     "           a.logadouro        AS [Logadouro],              " +
                     "           a.data_cadastro    AS [Data de Cadastro],       " +
                     "           f.descricao        AS [Faixa]                   " +
                     "FROM Aluno    AS     a                                     " +
                     "JOIN Cidade   AS     c        ON c.id_cidade = a.id_cidade " +
                     "JOIN Faixa    AS     f        ON f.id_faixa = a.id_faixa   " +
                     "WHERE a.id_aluno = ?                                       " ;

        String[] args = {"" + id};
        Cursor cursor = getDataBase().rawQuery(sql, args);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            list.add(montarViewTodosDadosAluno(cursor));
            cursor.moveToNext();
        }
        return list;
    }

    /** Retorna o Aluno que o cursor está apontando*/
    private ViewTodosDadosAluno montarViewTodosDadosAluno(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }

        int     codigo      = cursor.getInt(cursor.getColumnIndex("Matricula"));
        int     idade       = cursor.getInt(cursor.getColumnIndex("Idade"));
        String  nome        = cursor.getString(cursor.getColumnIndex("Nome"));
        String  cpf         = cursor.getString(cursor.getColumnIndex("CPF"));
        String  contato     = cursor.getString(cursor.getColumnIndex("Contato"));
        String  cidade      = cursor.getString(cursor.getColumnIndex("Cidade"));
        String  bairro      = cursor.getString(cursor.getColumnIndex("Bairro"));
        String  logadouro   = cursor.getString(cursor.getColumnIndex("Logadouro"));
        String  data        = cursor.getString(cursor.getColumnIndex("Data de Cadastro"));
        String  faixa       = cursor.getString(cursor.getColumnIndex("Faixa"));

        return new ViewTodosDadosAluno(codigo, nome, contato, cpf, idade, cidade, bairro, logadouro, data, faixa);
    }
}
