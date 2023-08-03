/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

/**
 *
 * @author Danig
 */
public class Pedidos {
    private int qnt_X_salada;
    private int qnt_X_burger;
    private int qnt_Cachorro_quente;
    private int qnt_Misto_quente;
    private int qnt_Salada_de_frutas;
    private int qnt_Refrigerante;
    private int qnt_Suco_natural; 

    public Pedidos(int qnt_X_salada, int qnt_X_burger, int qnt_Cachorro_quente, int qnt_Misto_quente, int qnt_Salada_de_frutas, int qnt_Refrigerante, int qnt_Suco_natural) {
        this.qnt_X_salada = qnt_X_salada;
        this.qnt_X_burger = qnt_X_burger;
        this.qnt_Cachorro_quente = qnt_Cachorro_quente;
        this.qnt_Misto_quente = qnt_Misto_quente;
        this.qnt_Salada_de_frutas = qnt_Salada_de_frutas;
        this.qnt_Refrigerante = qnt_Refrigerante;
        this.qnt_Suco_natural = qnt_Suco_natural;
    }

    public int getQnt_X_salada() {
        return qnt_X_salada;
    }

    public int getQnt_X_burger() {
        return qnt_X_burger;
    }

    public int getQnt_Cachorro_quente() {
        return qnt_Cachorro_quente;
    }

    public int getQnt_Misto_quente() {
        return qnt_Misto_quente;
    }

    public int getQnt_Salada_de_frutas() {
        return qnt_Salada_de_frutas;
    }

    public int getQnt_Refrigerante() {
        return qnt_Refrigerante;
    }

    public int getQnt_Suco_natural() {
        return qnt_Suco_natural;
    }

    
    //double conta=10*pedido.getQnt_X_salada()+10*pedido.getQnt_X_burger()+7.5*pedido.getQnt_Cachorro_quente()+8*pedido.getQnt_Misto_quente()+5.5*pedido.getQnt_Salada_de_frutas()+4.5*pedido.getQnt_Refrigerante()+6.25*pedido.getQnt_Suco_natural();
    
    public double getConta(){
        double conta=10*qnt_X_salada+10*qnt_X_burger+7.5*qnt_Cachorro_quente+8*qnt_Misto_quente+5.5*qnt_Salada_de_frutas+4.5*qnt_Refrigerante+6.25*qnt_Suco_natural;
        return conta;
    }
    
    @Override
    public String toString() {
        return  "X-salada: " + qnt_X_salada + "\nX-burger: " + qnt_X_burger + "\nCachorro quente: " + qnt_Cachorro_quente + "\nMisto quente: " + qnt_Misto_quente + "\nSalada de frutas: " + qnt_Salada_de_frutas+ "\nRefrigerante: " + qnt_Refrigerante + "\nSuco natural: " + qnt_Suco_natural;
    }
    
    
}

