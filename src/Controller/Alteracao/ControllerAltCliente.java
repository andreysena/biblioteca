/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Alteracao;

import DAO.DaoCliente;
import Model.Cliente;
import View.Alt.Alt_Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerAltCliente {

    private final Alt_Cliente vAltCliente;
    
    public ControllerAltCliente(Alt_Cliente vAltCliente){
    
        this.vAltCliente = vAltCliente;
    }
    
    public void alterar(String nome, String cpf, String nascimento, String email, String cod){
     
        if(nome.equals("") || cpf.equals("") || nascimento.equals("")){
            vAltCliente.exibeMensagem("Preencha todos os campos obrigatórios!");
            
        }else{
            
            if(email.equals("")){
                email = "O clinte não possui email";
            }
            Model.Cliente cliente = new Cliente(nome, cpf, nascimento, email);
       
            String id = cod;
            
            DAO.DaoCliente daoCliente = new DaoCliente();                                                                                       
            daoCliente.alterar(cliente, id);
            
            vAltCliente.exibeMensagem("Alteração efetuada com sucesso!");
        }
    }
}
