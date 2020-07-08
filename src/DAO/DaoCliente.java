/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoCliente {
    
    private Connection connection = new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(Cliente cliente){
        String sql = "INSERT INTO tbl_cliente (nome_cliente, cpf_cliente, nasc_cliente, email) VALUES(?, ?, ?, ?)" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDtNascimento());
            stmt.setString(4, cliente.getEmail());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public ResultSet listar(){
        
        String sql = "select * from tbl_cliente where status = 'D'";
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
        
        String sql = "update tbl_cliente set status = 'I' where codigo_cliente = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException msg){
            throw new RuntimeException(sql);
        }
    }
    
    public void alterar(Cliente cliente, String id){
        String sql = "update tbl_cliente set nome_cliente = ?, cpf_cliente = ?, nasc_cliente = ?, "
                + "email = ? where codigo_cliente = ?" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDtNascimento());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
}
