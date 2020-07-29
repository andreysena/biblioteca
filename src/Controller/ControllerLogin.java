/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoLogin;
import View.Login;
import View.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey
 */
public class ControllerLogin {
    
    private final Login tela;
    
    public ControllerLogin(Login tela){
        
        this.tela = tela;
    }
    
    public void realizarLogin(String usuario, String senha){
        
        if(usuario.equals("") || senha.equals("")){
            tela.exibeMensagem("Preencha todos os campos!");
        }else{
            DAO.DaoLogin login = new DaoLogin();
            boolean resposta = login.consultar(usuario, senha);
        
            if(resposta == true){
                tela.exibeMensagem("Login efetuado com sucesso!");
                new MainFrame().setVisible(true);
                tela.dispose();
            }else{
                tela.exibeMensagem("Login Incorreto! \nPor favor verifique os dados informados.");
            }

        }
        
    }
    
}
