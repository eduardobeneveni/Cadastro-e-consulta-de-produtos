package br.com.fiap.produtos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Produto {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private LocalDate dataCadastro;

    private Categoria categoria;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, LocalDate dataCadastro, Categoria categoria) {
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setDataCadastro(dataCadastro);
        this.setCategoria(categoria);
    }

    public Produto(String nome, String descricao, BigDecimal preco, LocalDate dataCadastro, Categoria categoria) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setDataCadastro(dataCadastro);
        this.setCategoria(categoria);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Produto setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Produto setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
