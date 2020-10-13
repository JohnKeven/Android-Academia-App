package projeto.object;

public class ViewAluno {
    private String nome;
    private String cpf;
    private int matricula;

    public ViewAluno(int id, String nome, String cpf) {
        this.setMatricula(id);
        this.setNome(nome);
        this.setCpf(cpf);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String contato) {
        this.cpf = contato;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Matricula: " + this.getMatricula());
        builder.append("\nNome: " + this.getNome());
        builder.append("\nCPF: " + this.getCpf());
        return builder.toString();
    }
}
