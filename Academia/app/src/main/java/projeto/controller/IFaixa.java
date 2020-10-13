package projeto.controller;

import java.util.List;

import projeto.object.Faixa;

public interface IFaixa {
    void inserir(Faixa faixa);
    List<Faixa> retornarTodas();
}
