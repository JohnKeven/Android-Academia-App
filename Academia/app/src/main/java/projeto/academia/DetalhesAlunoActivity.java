package projeto.academia;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import projeto.controller.IAluno;
import projeto.dao.AlunoDAO;
import projeto.object.ViewTodosDadosAluno;

public class DetalhesAlunoActivity extends AppCompatActivity {
    private Context context;
    private ListView lvDetalhes;
    private Button btnEditar, btnRemover, btnPagar;
    private IAluno iAluno;
    private static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_aluno);

        context = this;
        lvDetalhes = (ListView) findViewById(R.id.lvDetalhesAluno);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnRemover = (Button) findViewById(R.id.btnRemover);
        btnPagar = (Button) findViewById(R.id.btnPagamento);

        iAluno = new AlunoDAO(context);

        id = ((int) ListarAlunosActivity.getVwAdapter().getMatricula());

        List<ViewTodosDadosAluno> value = iAluno.retornarDados(id);
        ArrayAdapter<ViewTodosDadosAluno> adapter = new ArrayAdapter<ViewTodosDadosAluno>
                (context, android.R.layout.simple_list_item_1, value);
        lvDetalhes.setAdapter(adapter);
    }

    public static int getId() {
        return id;
    }

    public void onClickEditarAlunos(View view) {
        startActivity(new Intent(context, EditarActivity.class));
    }

    public void onClickRemoverAlunos(View view) {
        try {
            iAluno.remover(id);
            Toast.makeText(context, "Removido com sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLiteException e){
            Toast.makeText(context, "Não pode ser removido!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickRealizarPagamento(View view) {
        startActivity(new Intent(context, PagamentoActivity.class));
    }
}
