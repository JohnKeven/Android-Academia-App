package projeto.academia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import projeto.controller.IAluno;
import projeto.dao.AlunoDAO;
import projeto.object.ViewAluno;

public class ListarAlunosActivity extends AppCompatActivity {
    private Context context;
    private ListView lvAlunos;
    private IAluno iAluno;
    private static ViewAluno vwAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        lvAlunos = (ListView) findViewById(R.id.lvListaAlunos);

        context = this;
        iAluno = new AlunoDAO(this);

        listarAlunos();
    }

    public void listarAlunos() {
        List<ViewAluno> values = iAluno.retornarTodos();
        final ArrayAdapter<ViewAluno> adapter = new ArrayAdapter<ViewAluno>(context, android.R.layout.simple_list_item_1, values);
        lvAlunos.setAdapter(adapter);

        lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, DetalhesAlunoActivity.class);
                ListarAlunosActivity.vwAdapter = adapter.getItem(position);
                startActivity(intent);
            }
        });
    }

    public static ViewAluno getVwAdapter() {
        return vwAdapter;
    }
}
