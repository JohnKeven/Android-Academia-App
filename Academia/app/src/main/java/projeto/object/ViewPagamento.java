package projeto.object;

public class ViewPagamento {
    private String aluno, data;
    private double valor;

    public ViewPagamento(String idAluno, String data, double valor) {
        this.setAluno(idAluno);
        this.setData(data);
        this.setValor(valor);
    }

    public String getAluno() {
        return aluno;
    }

    private void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    private void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Aluno: " + getAluno());
        builder.append("\nData: " + getData());
        builder.append("\nValor: " + getValor());
        return builder.toString();
    }
}
