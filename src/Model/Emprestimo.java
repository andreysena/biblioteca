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
public class Emprestimo {
    
    private String retirada;
    private String devolucao;
    private int bibliotecario;
    private int cliente;
    
    public Emprestimo(String retirada, String devolucao, int bibliotecario, int cliente){
        this.retirada = retirada;
        this.devolucao = devolucao;
        this.bibliotecario = bibliotecario; 
        this.cliente = cliente;
    }

    public void setRetirada(String retirada) {
        this.retirada = retirada;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }
    
    public String getRetirada(){
        return this.retirada;
    }
    
    public String getDevolucao(){
        return this.devolucao;
    }

    public void setBibliotecario(int bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    
    public int getBibliotecario(){
        return this.bibliotecario;
    }
    
    public int getCliente(){
        return this.cliente;
    }
}
