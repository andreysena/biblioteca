/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoCategoria {
    
    private Connection connection = new ConnectionFactory().getConnection();
    
    public void adicionar(Categoria categoria){
        String sql = "INSERT INTO tbl_categoria (nome_categoria) VALUES(?)" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public ResultSet listar(){
        
        String sql = "select * from tbl_categoria where status = 'D'";
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
        String sql = "update tbl_categoria set status = 'I' where codigo_categoria = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
        
        }catch(SQLException msg){
            throw new RuntimeException(msg);
        }
    }
    
    public void alterar(Categoria categoria, String id){
        String sql = "update tbl_categoria set nome_categoria = ? wher codigo_categoria = ?" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
}
