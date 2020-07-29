/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Alteracao;

import DAO.DaoLivro;
import Model.Livro;
import View.Alt.Alt_Livros;

/**
 *
 * @author andrey
 */
public class ControllerAltLivro {
    
    private final Alt_Livros vAltLivros;
    
    public ControllerAltLivro(Alt_Livros vAlt_Livros){
        
        this.vAltLivros = vAlt_Livros;
    }
    
    public void alterar(String nome, String dt_publicacao, String paginas, String valor_unitario, int FK_Categoria, int FK_Editora, String cod){
        if(nome.equals("") || dt_publicacao.equals("") || paginas.equals("") || valor_unitario.equals("") || FK_Categoria < 1 || FK_Editora < 1){
            vAltLivros.exibeMensagem("Os campos obrigatótios devem ser preenchidos!");
        }else{
        
            Model.Livro livro = new Livro(nome, dt_publicacao, paginas, valor_unitario, FK_Categoria, FK_Editora);
            
            String id = cod;
            
            DAO.DaoLivro daoEmprestimo = new DaoLivro();
            daoEmprestimo.alterar(livro, id);
            
            vAltLivros.exibeMensagem("Alteração efetuada com sucesso!");
            
        }
    }
}
