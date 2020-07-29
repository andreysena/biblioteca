/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Livro;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author andrey
 */
public class DaoLivro {
    
    private Connection connection = new ConnectionFactory().getConnection();
    
    public void adicionar(Livro livro){
    
        String sql = "insert into tbl_livros (nome_livro, data_publicacao, paginas, valor_unitario, FK_Categoria, FK_Editora)"
                + "values (?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getDt_Publicacao());
            stmt.setInt(3, Integer.parseInt(livro.getPaginas()));
            stmt.setDouble(4, Double.parseDouble(livro.getValorUnitario()));
            stmt.setInt(5, livro.getCategoria());
            stmt.setInt(6, livro.getEditora());
            
            stmt.execute();
            stmt.close();
            
            
        }catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
            
    }
    
    public ResultSet listar(){
        
        String sql = "select l.codigo_livro, l.nome_livro, l.data_publicacao, " +
                     "l.paginas, l.valor_unitario, nome_categoria, FK_Categoria, nome_editora, FK_Editora from tbl_livros l\n" +
                     "join tbl_categoria on FK_Categoria = codigo_categoria \n" +
                     "join tbl_editora on FK_Editora = codigo_editora\n" +
                        "where l.status = 'D' order by codigo_livro";                     
                        
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
        
        String sql = "update tbl_livros set status = 'I' where codigo_livro = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        
        }catch(SQLException msg){
            throw new RuntimeException(msg);
        }
    }
    
    public void alterar(Livro livro, String id){
    
        String sql = "update tbl_livros set nome_livro = ?, data_publicacao = ?, paginas = ?, valor_unitario = ?, "
                + "FK_Categoria = ?, FK_Editora = ? where codigo_livro = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getDt_Publicacao());
            stmt.setInt(3, Integer.parseInt(livro.getPaginas()));
            stmt.setDouble(4, Double.parseDouble(livro.getValorUnitario()));
            stmt.setInt(5, livro.getCategoria());
            stmt.setInt(6, livro.getEditora());
            stmt.setInt(7, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
            
        }catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
            
    }
    
}
