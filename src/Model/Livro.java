/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author andrey
 */
public class Livro {
    
    private String nome;
    private String dt_publicacao;
    private String paginas;
    private String valor_unitario;
    private int categoria;
    private int editora;
    
    public Livro(String nome, String dt_publicacao, String paginas, String valor_unitario, int categoria, int editora){
        this.nome = nome;
        this.dt_publicacao = dt_publicacao;
        this.paginas = paginas;
        this.valor_unitario = valor_unitario;
        this.categoria = categoria;
        this.editora = editora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDt_publicacao(String dt_publicacao) {
        this.dt_publicacao = dt_publicacao;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public void setValor_unitario(String valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getDt_Publicacao(){
        return this.dt_publicacao;
    }
    
    public String getPaginas(){
        return this.paginas;
    }
    
    public String getValorUnitario(){
        return this.valor_unitario;
    }
    
    public void setCategoria(int categoria){
        this.categoria = categoria;
    }
    
    public int getCategoria(){
        return this.categoria;
    }
    
    public void setEditora(int editora){
        this.editora = editora;
    }
    
    public int getEditora(){
        return this.editora;
    }
}
