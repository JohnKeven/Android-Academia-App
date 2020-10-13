package projeto.academia;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import projeto.controller.IAluno;
import projeto.controller.ICidade;
import projeto.controller.IFaixa;
import projeto.dao.AlunoDAO;
import projeto.dao.CidadeDAO;
import projeto.dao.FaixaDAO;
import projeto.object.Aluno;
import projeto.object.Cidade;
import projeto.object.Faixa;
import projeto.object.ViewTodosDadosAluno;

public class EditarActivity extends AppCompatActivity {
    private Context context;
    private EditText nome, contato, cpf, idade, bairro, logadouro, data_cadastro;
    private Spinner cidade, faixa;
    private Button editar;
    private IAluno iAluno;
    private IFaixa iFaixa;
    private ICidade iCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        nome          = (EditText) findViewById(R.id.txtNomeEdit);
        idade         = (EditText) findViewById(R.id.txtIdadeEdit);
        contato       = (EditText) findViewById(R.id.txtContatoEdit);
        cidade        = (Spinner)  findViewById(R.id.spnCidadeEdit);
        bairro        = (EditText) findViewById(R.id.txtBairroEdit);
        logadouro     = (EditText) findViewById(R.id.txtLogadouroEdit);
        editar        = (Button)   findViewById(R.id.btnEditarAluno);
        cpf           = (EditText) findViewById(R.id.txtCpfEdit);
        data_cadastro = (EditText) findViewById(R.id.txtDataCadastroEdit);
        faixa         = (Spinner)  findViewById(R.id.spnFaixaEdit);

        context    = this;
        iAluno     = new AlunoDAO(context);
        iCidade    = new CidadeDAO(context);
        iFaixa     = new FaixaDAO(context);

        List<ViewTodosDadosAluno> value = iAluno.retornarDados(DetalhesAlunoActivity.getId());
        nome.setText(value.get(0).getNome());
        idade.setText(""+value.get(0).getIdade());
        contato.setText(value.get(0).getContato());
        bairro.setText(value.get(0).getBairro());
        logadouro.setText(value.get(0).getLogadouro());
        cpf.setText(value.get(0).getCpf());
        data_cadastro.setText(value.get(0).getData());

        listarCidades();
        listarFaixas();
    }



    public void listarCidades() {
        ArrayAdapter<Cidade> arrayAdapter = new ArrayAdapter<Cidade>
                (context, android.R.layout.simple_spinner_item, iCidade.retornarTodos());
        ArrayAdapter<Cidade> spnArrayAdapter = arrayAdapter;
        spnArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        cidade.setAdapter(spnArrayAdapter);
    }

    public void listarFaixas() {
        ArrayAdapter<Faixa> arrayAdapter = new ArrayAdapter<Faixa>
                (context, android.R.layout.simple_list_item_1, iFaixa.retornarTodas());
        ArrayAdapter<Faixa> spnArrayAdapter = arrayAdapter;
        spnArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        faixa.setAdapter(spnArrayAdapter);
    }

    public void onClickEditarAluno(View view) {
        String nome = this.nome.getText().toString();
        int idade = Integer.valueOf(this.idade.getText().toString());
        String contato = this.contato.getText().toString();
        String cpf = this.cpf.getText().toString();
        int cidade = this.cidade.getSelectedItemPosition() + 1;
        String bairro = this.bairro.getText().toString();
        String logadouro = this.logadouro.getText().toString();
        String data_cadastro = this.data_cadastro.getText().toString();
        int faixa = this.faixa.getSelectedItemPosition() + 1;
        Aluno aluno = new Aluno(nome, contato, cpf,  idade, cidade, bairro, logadouro, data_cadastro, faixa);

        try {
            iAluno.editar(aluno, DetalhesAlunoActivity.getId());
            Toast.makeText(context, "Editado com sucesso!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(context, MenuActivity.class));
        } catch (SQLiteException e) {
            Toast.makeText(context, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
