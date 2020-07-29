/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cadastro;

import DAO.DaoAutor;
import Model.Autor;
import View.Cad.Cad_Autor;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerCadAutor {
    
    private final Cad_Autor vCadAutor;
    
    public ControllerCadAutor(Cad_Autor vCad_Autor){
    
        this.vCadAutor = vCad_Autor;
    }
    
    
    public void verificar(String nome, String nascimento, String nacionalidade){
    
        if(nome.equals("") || nascimento.equals("") || nacionalidade.equals("")){
            vCadAutor.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
            
        }else{
            
            Model.Autor autor = new Autor(nome, nascimento, nacionalidade);
            
            DAO.DaoAutor daoAutor = new DaoAutor();
            daoAutor.adicionar(autor);
            
            vCadAutor.exibeMensagem("Autor cadastrado com sucesso!");
            vCadAutor.dispose();
        }
    }
    
}
