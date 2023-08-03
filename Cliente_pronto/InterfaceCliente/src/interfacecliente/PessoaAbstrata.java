/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacecliente;

/**
 *
 * @author Nick
 */
public abstract class PessoaAbstrata {
    public abstract String getCpf();
    public abstract String getSenha();
    public abstract String getNome();
    public abstract void setCpf(String cpf);
    public abstract void setSenha(String senha);
    public abstract void setNome(String nome);
    @Override
    public abstract String toString();
}
