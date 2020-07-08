/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Bibliotecario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoBibliotecario {

    private Connection connection = new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(Bibliotecario bibliotecario){
        String sql = "INSERT INTO tbl_bibliotecario (nome_bibliotecario, nasc_bibliotecario, telefone, FK_Biblio_responsavel) VALUES(?, ?, ?, ?)" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, bibliotecario.getNome());
            stmt.setString(2, bibliotecario.getNascimento());
            stmt.setString(3, bibliotecario.getTelefone());
            if(bibliotecario.getBiblioReponsavel() == 0){
                stmt.setObject(4, null);
            }else{
                stmt.setInt(4, bibliotecario.getBiblioReponsavel());
            }
            
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public ResultSet listar(){
    
        String sql = "select tbl_bibliotecario.codigo_bibliotecario, tbl_bibliotecario.nome_bibliotecario, \n" +
                     "tbl_bibliotecario.nasc_bibliotecario, tbl_bibliotecario.telefone, \n" +
                     "c.nome_bibliotecario, c.codigo_bibliotecario from tbl_bibliotecario \n" +
                     "left join tbl_bibliotecario c on tbl_bibliotecario.FK_Biblio_responsavel = c.codigo_bibliotecario\n" +
                     "where tbl_bibliotecario.status = 'D' order by tbl_bibliotecario.codigo_bibliotecario";
        
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
        
        String sql = "update tbl_bibliotecario set status = 'I' where codigo_bibliotecario = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
        }catch(SQLException msg){
            throw new RuntimeException(msg);
        }
    }
    
    public void alterar(Bibliotecario bibliotecario, String id){
        String sql = "update tbl_bibliotecario set nome_bibliotecario = ?, nasc_bibliotecario = ?,"
                + "telefone = ?, FK_Biblio_responsavel = ? where codigo_bibliotecario = ?" ;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, bibliotecario.getNome());
            stmt.setString(2, bibliotecario.getNascimento());
            stmt.setString(3, bibliotecario.getTelefone());
            if(bibliotecario.getBiblioReponsavel() == 0){
                stmt.setObject(4, null);
            }else{
                stmt.setInt(4, bibliotecario.getBiblioReponsavel());
            }
            stmt.setInt(5, Integer.parseInt(id));
            
            
            stmt.execute();
            stmt.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
}
