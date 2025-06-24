package br.com.fiap.produtos.view;

public enum opcao {

    CADASTRAR_CATEGORIA(1,"Cadastrar Categoria"),
    CADASTRAR_PRODUTO(2, "Cadastrar Produto"),
    ALTERAR_PRODUTO(3, "Alterar Produto"),
    CONSULTAR_PRODUTO_POR_ID(4, "Consultar Produto por ID"),
    CONSULTAR_PRODUTO_POR_CATEGORIA(5, "Consultar Produto por Categoria"),
    ENCERRAR_SISTEMA(6, "Encerrar o sistema");

    int id;
    String nome;

    opcao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public opcao setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public opcao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
