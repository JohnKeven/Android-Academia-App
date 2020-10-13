package projeto.database;

public class Script {
    //Tabelas
    public static String criarTabelaUsuario() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS Usuario( ");
        sql.append("    id_usuario      INTEGER         PRIMARY KEY AUTOINCREMENT, ");
        sql.append("    nome            VARCHAR(50)     NOT NULL, ");
        sql.append("    email           VARCHAR(50)     NOT NULL, ");
        sql.append("    senha           VARCHAR(20)     NOT NULL)");
        return sql.toString();
    }

    public static String criarTabelaCidade() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS Cidade( ");
        sql.append("    id_cidade       INTEGER         PRIMARY KEY AUTOINCREMENT, ");
        sql.append("    descricao       VARCHAR(50)     NOT NULL)");
        return sql.toString();
    }

    public static String criarTablelaFaixa() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS Faixa( ");
        sql.append("    id_faixa        INTEGER         PRIMARY KEY AUTOINCREMENT, ");
        sql.append("    descricao       VARCHAR(20)     NOT NULL)");
        return sql.toString();
    }

    public static String criarTabelaAluno() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS Aluno( ");
        sql.append("    id_aluno        INTEGER         PRIMARY KEY AUTOINCREMENT, ");
        sql.append("    nome            VARCHAR(50)     NOT NULL, ");
        sql.append("    contato         VARCHAR(50)     NOT NULL, ");
        sql.append("    cpf             VARCHAR(11)     NOT NULL, ");
        sql.append("    idade           INTEGER         NOT NULL, ");
        sql.append("    id_cidade       INTEGER         REFERENCES Cidades(id_cidade) NOT NULL, ");
        sql.append("    bairro          VARCHAR(50)     NOT NULL, ");
        sql.append("    logadouro       VARCHAR(50)     NOT NULL, ");
        sql.append("    data_cadastro   VARCHAR(10)     NOT NULL, ");
        sql.append("    id_faixa        INTEGER         REFERENCES Faixa(id_faixa) NOT NULL)");
        return sql.toString();
    }

    public static String criarTabelaPagamento() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS Pagamento( ");
        sql.append("    id_pagamento    INTEGER         PRIMARY KEY AUTOINCREMENT, ");
        sql.append("    id_aluno        INTEGER         REFERENCES Aluno(id_aluno) NOT NULL, ");
        sql.append("    data            VARCHAR(10)     NOT NULL, ");
        sql.append("    valor           NUMERIC(8,2)    NOT NULL) ");
        return sql.toString();
    }
}
