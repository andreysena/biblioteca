/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cadastro;

import DAO.DaoEditora;
import Model.Editora;
import View.Alt.Alt_Editora;
import View.Cad.Cad_Editora;
import javax.swing.JOptionPane;



/**
 *
 * @author andrey
 */
public class ControllerCadEditora {
    
    private final Cad_Editora vCadEditora;


    public ControllerCadEditora(Cad_Editora vCadEditora){
    
        this.vCadEditora = vCadEditora;
    }
    

    public void verificar(String nome, String cnpj, String email){
        
        if(nome.equals("") || cnpj.equals("")){
            vCadEditora.exibeMensagem("Os campos obrigatórios devem ser preenchidos");
                    
        }else{
        
            if(email.equals("")){
                email = "Está Editora não possui um email.";
            }
            
            Model.Editora editora = new Editora(nome, cnpj, email);
            DAO.DaoEditora daoEditora = new DaoEditora();
            daoEditora.adicionar(editora);
            
            vCadEditora.exibeMensagem("Editora cadastrada com sucesso!");
            vCadEditora.dispose();
        }
    }
    
    
}
