
package interfacecliente;

import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    private final Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs; 

    public UsuarioDAO() {
        Conecta conexao = new Conecta();
        conn = conexao.conectar();
    }
   
        public boolean verificaConta(Pessoa pessoa){
        String sql = "select * from clientes where cpf= ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pessoa.getCpf());
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;    
        }
        return false;
    }
    public boolean verificaLogin(Pessoa pessoa){
        String sql = "select * from clientes where cpf= ? and senha = ? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pessoa.getCpf());
            pstmt.setString(2, pessoa.getSenha());
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;    
        }
        return false;
    }
}

