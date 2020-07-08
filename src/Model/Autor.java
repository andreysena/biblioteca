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
public class Autor {

    private String nome;
    private String dt_nascimento;
    private String nacionalidade;
    
    public Autor(String nome, String dt_nascimento, String nacionalidade){
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.nacionalidade = nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getDtNascimento(){
        return this.dt_nascimento;
    }
    
    public String getNacionalidade(){
        return this.nacionalidade; 
    }
}
