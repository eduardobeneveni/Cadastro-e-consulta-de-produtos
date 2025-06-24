package br.com.fiap.produtos;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.CategoriaCollectionRepository;
import br.com.fiap.produtos.repository.ProdutoCollectionRepository;
import br.com.fiap.produtos.view.CategoriaView;
import br.com.fiap.produtos.view.OpcaoView;
import br.com.fiap.produtos.view.ProdutoView;
import br.com.fiap.produtos.view.opcao;

import javax.swing.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        opcao opcao = null;

        do {
            opcao = OpcaoView.select();
            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO ->  alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorID();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_SISTEMA -> encerrarSistema();
                
            }

        }while (opcao != opcao.ENCERRAR_SISTEMA);
    }

    private static void alterarProduto() {
        Produto produto = ProdutoView.select(null);
        ProdutoView.update(produto);
    }

    private static void encerrarSistema() {
        System.exit(0);
    }

    private static void consultarProdutoPorCategoria() {
        Categoria categoria = CategoriaView.select(null);

        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);

        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nao encontramos produtos com a categoria ");
        }else{
            produtos.forEach(ProdutoView::show);
            produtos.forEach(System.out::println);
        }


    }

    private static void consultarProdutoPorID() {
        
    }

    private static void cadastrarProduto() {
         Produto produto = ProdutoView.form(new Produto());
         ProdutoCollectionRepository.save(produto);
         ProdutoView.sucesso(produto);
        
    }

    private static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form(new Categoria());
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
        
    }
}