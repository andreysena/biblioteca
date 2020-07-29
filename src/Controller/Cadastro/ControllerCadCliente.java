/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cadastro;

import DAO.DaoCliente;
import Model.Cliente;
import View.Cad.Cad_Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerCadCliente {
    
    private final Cad_Cliente vCadCliente;
    
    public ControllerCadCliente(Cad_Cliente vCadCliente){
        
        this.vCadCliente = vCadCliente;
    }
    
    public void verificar(String nome, String cpf, String nascimento, String email){
    
        if(nome.equals("") || cpf.equals("") || nascimento.equals("")){
            vCadCliente.exibeMensagem("Preencha todos os campos obrigatórios!");
            
        }else{
            
            if(email.equals("")){
                email = "O clinte não possui email";
            }
            Model.Cliente cliente = new Cliente(nome, cpf, nascimento, email);
       
            DAO.DaoCliente daoCliente = new DaoCliente();                                                                                       
            daoCliente.adicionar(cliente);
            
            vCadCliente.exibeMensagem("Cliente cadastrado com sucesso!");
        }
    }
}
