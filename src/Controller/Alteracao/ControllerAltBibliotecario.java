/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Alteracao;

import DAO.DaoBibliotecario;
import Model.Bibliotecario;
import View.Alt.Alt_Bibliotecario;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerAltBibliotecario {
    
    private final Alt_Bibliotecario vAltBiblio;
    
    public ControllerAltBibliotecario(Alt_Bibliotecario vAltBiblio){
        
        this.vAltBiblio = vAltBiblio;
    }
    
    public void alterar(String nome, String nascimento, String telefone, int bibilioReposavel, String cod){
    
        if(nome.equals("") || nascimento.equals("") || telefone.equals("")){
            vAltBiblio.exibeMensagem("Preencha todos os campos obrigatórios!");
            
            
        }else{
           
            Model.Bibliotecario bibliotecario = new Bibliotecario(nome, nascimento, telefone, bibilioReposavel);
       
            String id = cod;
            
            DAO.DaoBibliotecario daoBibliotecario = new DaoBibliotecario();
            daoBibliotecario.alterar(bibliotecario, id);
            
            vAltBiblio.exibeMensagem("Alteração efetuada com sucesso!");
        }
    }
}
