/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoLogin {
    
    private Connection connection = new ConnectionFactory().getConnection();
    
    public boolean consultar(String usuario, String senha){
        
        boolean autenticado = false;
        
        try{
            String sql = "select usuario, senha from login where usuario = ? and senha = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
          
            ResultSet rs ;
            rs = stmt.executeQuery();
            
            if(rs.next()){
                autenticado = true;
            }
            stmt.close();
            return autenticado; 
            
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
            
        
    }
    
}
