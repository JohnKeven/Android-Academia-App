package projeto.controller;

import java.util.List;

import projeto.object.Pagamento;
import projeto.object.ViewPagamento;

public interface IPagamento {
    void inserir(Pagamento pagamento);
    List<ViewPagamento> retornarTodos();
}
