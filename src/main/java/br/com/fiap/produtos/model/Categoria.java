package br.com.fiap.produtos.model;

import java.util.Objects;

public class Categoria {

    Long id;

    String nome;

    public Categoria() {
    }

    public Categoria(long l, String nome) {
        this.setId(id);
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public Categoria setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Categoria setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }



}
