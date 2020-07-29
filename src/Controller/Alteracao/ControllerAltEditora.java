/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Alteracao;

import DAO.DaoEditora;
import Model.Editora;
import View.Alt.Alt_Editora;

/**
 *
 * @author andrey
 */
public class ControllerAltEditora {
    
    private final Alt_Editora vAltEditora;
    
    public ControllerAltEditora(Alt_Editora vAlt_Editora){
        
        this.vAltEditora = vAlt_Editora;
    }
    
    public void alterar(String nome, String cnpj, String email, String cod){
        
        if(nome.equals("") || cnpj.equals("")){
            vAltEditora.exibeMensagem("Os campos obrigatórios devem ser preenchidos");
                    
        }else{
        
            if(email.equals("")){
                email = "Está Editora não possui um email.";
            }
            
            Model.Editora editora = new Editora(nome, cnpj, email);
            
            String id = cod;
            
            DAO.DaoEditora daoEditora = new DaoEditora();
            daoEditora.alterar(editora, id);
            
            vAltEditora.exibeMensagem("Alteração efetuada com sucesso!");
            vAltEditora.dispose();
        }
    } 
    
}
