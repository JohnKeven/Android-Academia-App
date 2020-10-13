package projeto.academia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Context context;
    private Button btnCadastro, btnLista, btnPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        context = this;
        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnLista = (Button) findViewById(R.id.btnListarAlunos);
        btnPagamento = (Button) findViewById(R.id.btnHistoricoPagamento);
    }

    public void onClickMenuCadastro(View view) {
        startActivity(new Intent(context, CadastroActivity.class));
    }

    public void onClickListarAlunos(View view) {
        startActivity(new Intent(context, ListarAlunosActivity.class));
    }

    public void onClickHistoricoPagamento(View view) {

    }
}
