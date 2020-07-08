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
public class Cliente {
    
    private String nome;
    private String cpf;
    private String dt_nascimento;
    private String email;
    
    public Cliente(String nome, String cpf, String dt_nascimento, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        if (email != ""){
            this.email = email;
        }else{
            this.email = "O cliente não possui email";
        }
        
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//    
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public String getDtNascimento(){
        return this.dt_nascimento;
    }
    
    public String getEmail(){
        return this.email;
    }
}
