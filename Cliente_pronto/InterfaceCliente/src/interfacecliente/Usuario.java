
package interfacecliente;

public class Usuario {
    private final String cpf;
    private final String senha;

    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
    
}

