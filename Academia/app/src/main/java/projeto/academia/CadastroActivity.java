package projeto.academia;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import projeto.controller.IAluno;
import projeto.controller.ICidade;
import projeto.controller.IFaixa;
import projeto.dao.AlunoDAO;
import projeto.dao.CidadeDAO;
import projeto.dao.FaixaDAO;
import projeto.object.Aluno;
import projeto.object.Cidade;
import projeto.object.Faixa;

public class CadastroActivity extends AppCompatActivity {
    private Context context;
    private IAluno iAluno;
    private ICidade iCidade;
    private IFaixa iFaixa;
    private EditText nome, idade, contato, bairro, logadouro, cpf, data_cadastro;
    private Spinner cidade, faixa;
    private Button cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome          = (EditText) findViewById(R.id.txtNome);
        idade         = (EditText) findViewById(R.id.txtIdade);
        contato       = (EditText) findViewById(R.id.txtContato);
        cidade        = (Spinner)  findViewById(R.id.spnCidade);
        bairro        = (EditText) findViewById(R.id.txtBairro);
        logadouro     = (EditText) findViewById(R.id.txtLogadouro);
        cadastro      = (Button)   findViewById(R.id.btnCadastrarAluno);
        //editar        = (Button)   findViewById(R.id.btnEditar);
        cpf           = (EditText) findViewById(R.id.txtCpf);
        data_cadastro = (EditText) findViewById(R.id.txtDataCadastro);
        faixa         = (Spinner)  findViewById(R.id.spnFaixa);

        context = this;
        iAluno     = new AlunoDAO(context);
        iCidade    = new CidadeDAO(context);
        iFaixa     = new FaixaDAO(context);

        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        data_cadastro.setText(format.format(data));
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

    public void onClickCadastrarAluno(View view) {
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
            iAluno.inserir(aluno);
            Toast.makeText(context, "Inserido com sucesso!", Toast.LENGTH_LONG).show();
            this.nome.setText("");
            this.idade.setText("");
            this.contato.setText("");
            this.cpf.setText("");
            this.bairro.setText("");
            this.logadouro.setText("");
            this.data_cadastro.setText("");
        } catch (SQLiteException e) {
            Toast.makeText(context, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
