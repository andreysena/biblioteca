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
public class Editora {
    
    private String nome;
    private String cnpj;
    private String email;
    
    public Editora(String nome, String cnpj, String email){
        this.nome = nome;
        this.cnpj = cnpj;
        
        if(email != ""){
            this.email = email;
        }else{
            this.email = "Este cliente não possui um email.";
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCnpj(){
        return this.cnpj;
    }
    
    public String getEmail(){
        return this.email;
    }
}
