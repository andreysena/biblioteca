/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cadastro;

import DAO.DaoBibliotecario;
import Model.Bibliotecario;
import View.Cad.Cad_Bibliotecario;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerCadBibliotecario {
    
    private final Cad_Bibliotecario vCadBilio;
    
    public ControllerCadBibliotecario(Cad_Bibliotecario vCad_Biblio){
    
        this.vCadBilio = vCad_Biblio;
    }
    
    public void verificar(String nome, String nascimento, String telefone, int biblioResponsavel){
    
        if(nome.equals("") || nascimento.equals("") || telefone.equals("")){
            vCadBilio.exibeMensagem("Preencha todos os campos obrigatórios!");
            
            
        }else{
           
            Model.Bibliotecario bibliotecario = new Bibliotecario(nome, nascimento, telefone, biblioResponsavel);
       
            DAO.DaoBibliotecario daoBibliotecario = new DaoBibliotecario();
            daoBibliotecario.adicionar(bibliotecario);
            
            vCadBilio.exibeMensagem("Bibliotecário(a) cadastrado com sucesso!");
            vCadBilio.dispose();
        }
    }
}
