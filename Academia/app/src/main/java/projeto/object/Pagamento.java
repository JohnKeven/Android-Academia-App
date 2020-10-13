package projeto.object;

public class Pagamento {
    private int idAluno, idStatus;
    private String data;
    private double valor;

    public Pagamento(int idAluno, String data, double valor, int idStatus) {
        this.setIdAluno(idAluno);
        this.setData(data);
        this.setValor(valor);
        this.setIdStatus(idStatus);
    }

    public int getIdAluno() {
        return idAluno;
    }

    private void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdStatus() {
        return idStatus;
    }

    private void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
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
        builder.append("ID Aluno: " + getIdAluno());
        builder.append("\nData: " + getData());
        builder.append("\nValor: " + getValor());
        builder.append("\nID Status: " + getIdStatus());
        return builder.toString();
    }
}
