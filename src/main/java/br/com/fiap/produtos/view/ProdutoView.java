package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.ProdutoCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoView {
    public static Produto form(Produto produto) {

        Categoria categoria = null;

        do{
            categoria = CategoriaView.select(produto.getCategoria());
        }while(categoria==null);

        String nome = "";

        do {
            nome = JOptionPane.showInputDialog(null, "Informe o Nome do produto", produto.getNome());

        }while(nome.equals(""));

        String descricao = "";

        do {
            descricao = JOptionPane.showInputDialog(null, "Informe a descricao do produto",produto.getDescricao());

        }while(descricao.equals(""));

        Double preco = (double) 0;

        do {
            try {
            preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o preco do produto", produto.getPreco()));
            } catch (Exception e) {
                preco = (double) 0;
        }
        }while(preco<=0);



        Produto ret = produto;

        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataCadastro(LocalDate.now())
                .setPreco(BigDecimal.valueOf(preco));

        return ret;
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Produto Salvo com sucesso!");
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto"+ produto.getNome() +" Salvo com sucesso!");
    }

    public static Produto select(Produto produto) {
        Produto ret = (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione um Produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ProdutoCollectionRepository.findAll().toArray(),
                produto == null ? 1 : produto);
        return ret;
    }

    public static void update(Produto produto) {
        form(produto);
        sucesso(produto);
        show(produto);
    }

    public static void show(Produto p) {
        System.out.println(p);
        String textoFormatado = String.format("PRODUTO:" + p.getNome() + System.lineSeparator() + "DESCRICAO:" + p.getDescricao() + "CATEGORIA:" + p.getCategoria().toString() + System.lineSeparator() + "PRECO: %,.2f", p.getPreco());
        JOptionPane.showMessageDialog(null, textoFormatado);
    }

}
