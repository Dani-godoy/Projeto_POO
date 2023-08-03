/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacecliente;

/**
 *
 * @author Nick
 */
public class Pessoa extends PessoaAbstrata{
    private String cpf;
    private String senha;
    private String nome;
    private Pedidos pedido;

    public Pessoa(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa(String cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", senha=" + senha + ", nome=" + nome + ", pedido=" + pedido + '}';
    }
    
    
}
