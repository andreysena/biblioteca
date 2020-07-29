/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Alteracao;

import DAO.DaoCategoria;
import Model.Categoria;
import View.Alt.Alt_Categoria;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerAltCategoria {
    
    private final Alt_Categoria vAltCategoria;
    
    public ControllerAltCategoria(Alt_Categoria vAlt_Categoria){
        
        this.vAltCategoria = vAlt_Categoria;
    }
    
    public void alterar(String nome, String cod){
    
        if(nome.equals("")){
            vAltCategoria.exibeMensagem("Preencha todos os campos obrigatórios!");
            
        }else{
            Model.Categoria categoria = new Categoria(nome);
            
            String id = cod;
            
            DAO.DaoCategoria daoCategoria = new DaoCategoria();
            daoCategoria.alterar(categoria, id);
            
            vAltCategoria.exibeMensagem("Alteração efetuada com sucesso!");
        }
    }
}
