/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cadastro;

import DAO.DaoEmprestimo;
import Model.Emprestimo;
import View.Cad.Cad_Emprestimo;


/**
 *
 * @author andrey
 */
public class ControllerCadEmprestimo {
    
    private final Cad_Emprestimo vCadEmprestimo;
    
    public ControllerCadEmprestimo(Cad_Emprestimo vCad_Emprestimo){
        
        this.vCadEmprestimo = vCad_Emprestimo;
    }
    
    public void verificar(String retirada, String devolucao, int FK_Biblio, int FK_Cliente){
        if(retirada.equals("") || devolucao.equals("") || FK_Biblio < 1 || FK_Cliente < 1){
            vCadEmprestimo.exibeMensagem("Os campos obrigatótios devem ser preenchidos!");
        }else{
        
            Model.Emprestimo emprestimo = new Emprestimo(retirada, devolucao, FK_Biblio, FK_Cliente);

            
            DAO.DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
            daoEmprestimo.adicionar(emprestimo);
            
            vCadEmprestimo.exibeMensagem("Cadastro efetuado com sucesso!");
            
        }
    }
}
