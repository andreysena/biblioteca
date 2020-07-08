/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import Model.Editora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author andrey
 */
public class DaoEditora {
    
    private Connection connection = new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(Editora editora){
        String sql = "INSERT INTO tbl_editora (nome_editora, cnpj, email) VALUES(?, ?, ?)" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getCnpj());
            stmt.setString(3, editora.getEmail());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public ResultSet listar(){
    
        String sql = "select * from tbl_editora where status = 'D'";
        ResultSet rs;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            return rs;
            
        }catch(SQLException msg){
            throw new RuntimeException(msg);
        }
    }
    
    public void excluir(int id){
        String sql = "update tbl_editora set status = 'I' where codigo_editora = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException msg){
            throw new RuntimeException(msg); 
        }
    }
    
    public void alterar(Editora editora, String id){
        String sql = "update tbl_editora set nome_editora = ?, cnpj = ?, email = ? where codigo_editora = ?" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getCnpj());
            stmt.setString(3, editora.getEmail());
            stmt.setInt(4, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
}
