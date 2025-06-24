package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.repository.CategoriaCollectionRepository;

import javax.swing.*;

public class CategoriaView {
   static CategoriaCollectionRepository repository;

   public static Categoria select(Categoria categoria){
       Categoria ret = (Categoria) JOptionPane.showInputDialog(
               null,
               "Selecione uma categoria",
               "Menu",
               JOptionPane.QUESTION_MESSAGE,
               null,
               repository.findAll().toArray(),
               categoria == null ? 1 : categoria);
       return ret;
   }

   public void sucesso(){
       JOptionPane.showMessageDialog(null, "Categoria salva com Sucesso");
   }

    public void sucesso(Categoria categoria){
        JOptionPane.showMessageDialog(null, "Categoria "+ categoria.getNome() +" salva com Sucesso");
    }

    public static Categoria form(Categoria categoria){
       String nome = JOptionPane.showInputDialog(null, "Informe o Nome do Categoria", categoria !=null? categoria.getNome():"");
       return new Categoria();
    }
}
