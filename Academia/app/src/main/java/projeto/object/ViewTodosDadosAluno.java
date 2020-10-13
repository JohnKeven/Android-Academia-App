package projeto.object;

public class ViewTodosDadosAluno {
    private String nome;
    private String contato;
    private String cpf;
    private String bairro;
    private String logadouro;
    private String cidade;
    private String data;
    private String faixa;
    private int idade, codigo;

    public ViewTodosDadosAluno(int codigo, String nome, String contato, String cpf, int idade, String cidade, String bairro, String logadouro, String data, String faixa) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setContato(contato);
        this.setCidade(cidade);
        this.setBairro(bairro);
        this.setLogadouro(logadouro);
        this.setData(data);
        this.setFaixa(faixa);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Matricula: " + this.getCodigo());
        builder.append("\nNome: " + this.getNome());
        builder.append("\nCPF: " + this.getCpf());
        builder.append("\nIdade: " + this.getIdade());
        builder.append("\nContato: " + this.getContato());
        builder.append("\nCidade: " + this.getCidade());
        builder.append("\nBairro: " + this.getBairro());
        builder.append("\nLogadouro: " + this.getLogadouro());
        builder.append("\nData de Cadastro: " + this.getData());
        builder.append("\nFaixa: " + this.getFaixa());
        return builder.toString();
    }
}
