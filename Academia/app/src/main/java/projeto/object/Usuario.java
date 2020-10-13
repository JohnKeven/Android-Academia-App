package projeto.object;

public class Usuario {
    private String nome, email, senha;

    public Usuario(String nome, String email, String senha) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nome: " + this.getNome());
        builder.append("\nEmail: " + this.getEmail());
        builder.append("\nSenha: " + this.getSenha());
        return builder.toString();
    }
}
