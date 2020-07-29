/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cadastro;

import DAO.DaoCategoria;
import Model.Categoria;
import View.Cad.Cad_Categoria;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerCadCategoria {

    private final Cad_Categoria vCadCategoria;
    
    public ControllerCadCategoria(Cad_Categoria vCad_Categoria){
        
        this.vCadCategoria = vCad_Categoria;
    }
    
    public void verificar(String nome){
    
        if(nome.equals("")){
            vCadCategoria.exibeMensagem("Preencha todos os campos obrigatórios!");
            
        }else{
            Model.Categoria categoria = new Categoria(nome);
            
            DAO.DaoCategoria daoCategoria = new DaoCategoria();
            daoCategoria.adicionar(categoria);
            
            vCadCategoria.exibeMensagem("Categoria cadastrada com sucesso!");
        }
    }
}
