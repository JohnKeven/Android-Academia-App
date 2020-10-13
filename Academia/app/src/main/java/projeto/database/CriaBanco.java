package projeto.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "dbAcademia.db";
    private static final int VERSAO = 2;
    protected SQLiteDatabase database;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    protected SQLiteDatabase getDataBase() {
        if (database == null) {
            database = getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Script.criarTabelaUsuario());
        db.execSQL(Script.criarTabelaCidade());
        db.execSQL(Script.criarTablelaFaixa());
        db.execSQL(Script.criarTabelaAluno());
        db.execSQL(Script.criarTabelaPagamento());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuario");
        db.execSQL("DROP TABLE IF EXISTS Cidade");
        db.execSQL("DROP TABLE IF EXISTS Faixa");
        db.execSQL("DROP TABLE IF EXISTS Aluno");
        db.execSQL("DROP TABLE IF EXISTS Pagamento");
        onCreate(db);
    }
}
