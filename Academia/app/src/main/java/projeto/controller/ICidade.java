package projeto.controller;

import java.util.List;

import projeto.object.Cidade;

public interface ICidade {
    void inserir(Cidade cidade);

    List<Cidade> retornarTodos();
}
