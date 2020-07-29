/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Alteracao;

import DAO.DaoEmprestimo;
import Model.Emprestimo;
import View.Alt.Alt_Emprestimo;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerAltEmprestimo {
    
    private final Alt_Emprestimo vAltEmprestimo;
    
    public ControllerAltEmprestimo(Alt_Emprestimo vAlt_Emprestimo){
        
        this.vAltEmprestimo = vAlt_Emprestimo;
    }
    
    public void alterar(String retirada, String devolucao, int FK_Biblio, int FK_Cliente, String cod){
        if(retirada.equals("") || devolucao.equals("") || FK_Biblio < 1 || FK_Cliente < 1){
            vAltEmprestimo.exibeMensagem("Os campos obrigatótios devem ser preenchidos!");
        }else{
        
            Model.Emprestimo emprestimo = new Emprestimo(retirada, devolucao, FK_Biblio, FK_Cliente);
            
            String id = cod;
            
            DAO.DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
            daoEmprestimo.alterar(emprestimo, id);
            
            vAltEmprestimo.exibeMensagem("Alteração efetuada com sucesso!");
            
        }
    }
        
        
}
