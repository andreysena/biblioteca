/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Emprestimo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author andrey
 */
public class DaoEmprestimo {
    
    private Connection connection = new ConnectionFactory.Connection().getConnection();
    
    
    
    public void adicionar(Emprestimo emprestimo){
        String sql = "INSERT INTO tbl_emprestimo (retirada, devolucao, FK_Bibliotecario, FK_Cliente) values(?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, emprestimo.getRetirada());
            stmt.setString(2, emprestimo.getDevolucao());
            stmt.setInt(3, emprestimo.getBibliotecario());
            stmt.setInt(4, emprestimo.getCliente());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public ResultSet listar(){
        
        String sql = "select e.codigo_emprestimo, e.retirada, e.devolucao, nome_bibliotecario, FK_Bibliotecario, nome_cliente, FK_Cliente from tbl_emprestimo e\n" +
                     "join tbl_bibliotecario on FK_Bibliotecario = codigo_bibliotecario\n" +
                     "join tbl_cliente on FK_Cliente = codigo_cliente\n" +
                     "where e.status = 'D' order by codigo_emprestimo";
        
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
        
        String sql = "update tbl_emprestimo set status = 'I' where codigo_emprestimo = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException msg){
            throw new RuntimeException(msg);
        }
    }
    
    public void alterar(Emprestimo emprestimo, String id){
        String sql = "update tbl_emprestimo set retirada = ?, devolucao = ?, "
                + "FK_Bibliotecario = ?, FK_Cliente = ? where codigo_emprestimo = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, emprestimo.getRetirada());
            stmt.setString(2, emprestimo.getDevolucao());
            stmt.setInt(3, emprestimo.getBibliotecario());
            stmt.setInt(4, emprestimo.getCliente());
            stmt.setInt(5, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }    
    
     
}
