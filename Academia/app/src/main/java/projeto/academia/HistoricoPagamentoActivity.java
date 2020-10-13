package projeto.academia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import projeto.controller.IPagamento;
import projeto.dao.PagamentoDAO;

public class HistoricoPagamentoActivity extends AppCompatActivity {
    private Context context;
    private ListView lvPagamento;
    private IPagamento iPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_pagamento);
        lvPagamento = (ListView) findViewById(R.id.lvListaHistoricoPagamento);

        context = this;
        iPagamento = new PagamentoDAO(context);
    }

    public void listarHistoricoPagamento() {

    }
}
