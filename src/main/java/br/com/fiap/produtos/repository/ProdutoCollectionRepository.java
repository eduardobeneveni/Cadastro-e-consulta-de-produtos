package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ProdutoCollectionRepository {
    private static List<Produto> produtos;

    static {
        produtos = new Vector<>();

        Produto celular = new Produto();

        celular.setNome("Iphone 14 Pro Max")
                .setDescricao("Celular da Apple")
                .setCategoria(CategoriaCollectionRepository.findById(2l))
                .setDataCadastro(LocalDate.from(LocalDateTime.now()))
                .setPreco(BigDecimal.valueOf(12000));

        save(celular);

    }

    public static List<Produto> findAll() {
        return produtos;
    }

    public static Produto save(Produto produto) {
        if(!produtos.contains(produto)) {
            Produto produto1 = produto.setId((long) produtos.size()+1);
            produtos.add(produto);
            return produto;
        }else{
            JOptionPane.showMessageDialog(null, "Ja existe um cadastro com esse nome");
            return null;
        }
    }

    public static List<Produto> findByCategoria(Categoria categoria) {
        return produtos.stream().filter(p -> p.getCategoria() != null && p.getCategoria().equals(categoria)).toList();
    }
}
