/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import java.sql.Connection;
import Model.Autor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoAutor {
    
    private Connection connection = new ConnectionFactory().getConnection();
    
    public void adicionar(Autor autor){
        String sql = "insert into tbl_autor (nome_autor, nasc_autor, nacionalidade) values (?, ?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getDtNascimento());
            stmt.setString(3, autor.getNacionalidade());
            
            stmt.execute();
            stmt.close();
                    
        }catch(SQLException erro){
            throw new RuntimeException(erro); 
        }
    }
    
    public ResultSet listar(){
        
        String sql = "select * from tbl_autor where status = 'D'";
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
        
        String sql = "update tbl_autor set status = 'I' where codigo_autor = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException msg){
            throw new RuntimeException(msg);
        }
    }
    
    public void alterar(Autor autor, String id){
        String sql = "update tbl_autor set nome_autor = ?, nasc_autor = ?, nacionalidade = ? where codigo_autor = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getDtNascimento());
            stmt.setString(3, autor.getNacionalidade());
            stmt.setInt(4, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
                    
        }catch(SQLException erro){
            throw new RuntimeException(erro); 
        }
    }
    
}
