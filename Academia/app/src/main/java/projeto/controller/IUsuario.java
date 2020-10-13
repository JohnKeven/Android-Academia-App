package projeto.controller;

import java.util.List;

import projeto.object.Usuario;

public interface IUsuario {
    void inserir(Usuario usuario);
    public List<Usuario> retornarTodos();
    boolean pesquisarPorLogin(String email, String senha);
}
