package projeto.academia;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projeto.controller.IPagamento;
import projeto.dao.PagamentoDAO;
import projeto.object.Pagamento;

public class PagamentoActivity extends AppCompatActivity {
    private Context context;
    private EditText nome, valor, data, status;
    private Button pagar;
    private IPagamento iPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        context = this;
        nome = (EditText) findViewById(R.id.etxtAluno);
        valor = (EditText) findViewById(R.id.etxtValor);
        data = (EditText) findViewById(R.id.etxtDataPagamento);
        pagar = (Button) findViewById(R.id.btnPagar);
        iPagamento = new PagamentoDAO(context);

        //nome.setText(""+DetalhesAlunoActivity.getId());
    }

    public void onClickPagar(View view) {
        double valor = Double.valueOf(this.valor.getText().toString());
        String data = this.data.getText().toString();
        Pagamento pagamento;
        try {
            pagamento = new Pagamento(1, data, valor, 1);
            iPagamento.inserir(pagamento);
            Toast.makeText(context, "Pagamento efetuado com sucesso!", Toast.LENGTH_LONG).show();
        }catch (SQLiteException e) {
            Toast.makeText(context, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
