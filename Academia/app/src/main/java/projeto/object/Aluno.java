package projeto.object;

public class Aluno {
    private String nome, contato, cpf;
    private int idade, idCidade, idFaixa;
    private String bairro, logadouro, dataCadastro;

    public Aluno(String nome, String contato, String cpf, int idade, int idCidade, String bairro, String logadouro, String dataCadastro, int idfaixa) {
        this.setNome(nome);
        this.setContato(contato);
        this.setCpf(cpf);
        this.setIdade(idade);
        this.setIdCidade(idCidade);
        this.setBairro(bairro);
        this.setLogadouro(logadouro);
        this.setDataCadastro(dataCadastro);
        this.setFaixa(idfaixa);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    private void setContato(String contato) {
        this.contato = contato;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBairro() {
        return bairro;
    }

    private void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogadouro() {
        return logadouro;
    }

    private void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public int getIdCidade() {
        return idCidade;
    }

    private void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getFaixa() {
        return idFaixa;
    }

    public void setFaixa(int faixa) {
        this.idFaixa = faixa;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Nome: " + this.getNome());
        string.append("\nIdade: " + this.getIdade());
        string.append("\nCPF: " + this.getCpf());
        string.append("\nContato: " + this.getContato());
        string.append("\nID Cidade: " + this.getIdCidade());
        string.append("\nBairro: " + this.getBairro());
        string.append("\nLogadouro: " + this.getLogadouro());
        string.append("\nID Faixa " + this.getFaixa());
        return string.toString();
    }
}
