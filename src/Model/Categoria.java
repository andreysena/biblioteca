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
public class Categoria {
    
    private String nome;
    
    public Categoria(String nome){
       this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
}