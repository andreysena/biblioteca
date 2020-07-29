/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Alteracao;

import DAO.DaoAutor;
import Model.Autor;
import View.Alt.Alt_Autor;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerAltAutor {
    
    private final Alt_Autor vAltAutor;
    
    public ControllerAltAutor(Alt_Autor vAlt_Autor){
        
        this.vAltAutor = vAlt_Autor;
    }
    
    public void alterar(String nome, String nascimento, String nacionalidade, String cod){
        
        if(nome.equals("") || nascimento.equals("") || nacionalidade.equals("")){
            vAltAutor.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
            
        }else{
            
            Model.Autor autor = new Autor(nome, nascimento, nacionalidade);
            
            String id = cod;
            
            DAO.DaoAutor daoAutor = new DaoAutor();
            daoAutor.alterar(autor, id);
            
            vAltAutor.exibeMensagem("Alteração efetuada com sucesso!");
            vAltAutor.dispose();
 
        }
    }
    
}
