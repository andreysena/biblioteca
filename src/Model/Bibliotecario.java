/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



/**
 *
 * @author andrey
 */
public class Bibliotecario {
    
    private String nome;
    private String nascimento;
    private String telefone;
    private int biblioResponsavel;
    
    public Bibliotecario(String nome, String nascimento, String telefone, int biblioResponsavel){
        
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.biblioResponsavel = biblioResponsavel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getNascimento(){
        return this.nascimento;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void setBiblioResponsavel(int biblioResponsavel) {
        this.biblioResponsavel = biblioResponsavel;
    }
    
    public int getBiblioReponsavel(){
        
        return this.biblioResponsavel;
        
    }
}
