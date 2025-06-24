package br.com.fiap.produtos.view;

import javax.swing.*;

public class OpcaoView {
    public static opcao select(){

        opcao ret = (opcao) JOptionPane.showInputDialog(
                null, //componente pai
                "Selecione uma opcao",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                opcao.values(),
                opcao.CADASTRAR_PRODUTO);

        return ret != null ? ret : opcao.ENCERRAR_SISTEMA;

    }
}
