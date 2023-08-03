package restaurante;

public class Pessoa {
    private String nome;
    private String cpf;
    private Pedidos pedido;

    public Pessoa(String nome, String cpf, String senha, Pedidos pedido) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedido = pedido;
    }
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Pedidos getPedido() {
        return pedido;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "\nNome:" + nome + "\n"+ "Cpf:" + cpf ;
    }

    
}
