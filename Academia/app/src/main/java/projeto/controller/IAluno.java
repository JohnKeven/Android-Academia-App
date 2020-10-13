package projeto.controller;

import java.util.List;

import projeto.object.Aluno;
import projeto.object.ViewAluno;
import projeto.object.ViewTodosDadosAluno;

public interface IAluno {
    void inserir(Aluno aluno);
    void editar(Aluno aluno, int id);
    void remover(int id);
    List<ViewAluno> retornarTodos();
    List<ViewTodosDadosAluno> retornarDados(int id);
}
