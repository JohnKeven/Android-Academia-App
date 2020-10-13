package projeto.object;

public class Cidade {
    private String descricao;

    public Cidade(String descricao) {
        this.setDescricao(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
