/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cadastro;

import DAO.DaoLivro;
import Model.Livro;
import View.Cad.Cad_Livros;

/**
 *
 * @author andrey
 */
public class ControllerCadLivro {
    
    private final Cad_Livros vCadLivros;
    
    public ControllerCadLivro(Cad_Livros vCad_Livros){
        
        this.vCadLivros = vCad_Livros;
    }
    
    public void adicionar(String nome, String dt_publicacao, String paginas, String valor_unitario, int FK_Categoria, int FK_Editora){
        if(nome.equals("") || dt_publicacao.equals("") || paginas.equals("") || valor_unitario.equals("") || FK_Categoria < 1 || FK_Editora < 1){
            vCadLivros.exibeMensagem("Os campos obrigatótios devem ser preenchidos!");
        }else{
        
            Model.Livro livro = new Livro(nome, dt_publicacao, paginas, valor_unitario, FK_Categoria, FK_Editora);
            
            
            DAO.DaoLivro daoEmprestimo = new DaoLivro();
            daoEmprestimo.adicionar(livro);
            
            vCadLivros.exibeMensagem("Alteração efetuada com sucesso!");
            
        }
    }
}
