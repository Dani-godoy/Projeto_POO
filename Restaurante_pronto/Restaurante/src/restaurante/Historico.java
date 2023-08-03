/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Historico {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    
    
    public void inserir(String cpf) {
        // Abrindo a conexão com o banco​
       Conecta conexao = new Conecta();
        conn = conexao.conectar();
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscarPorCpf(cpf);
            String nome;
            while(rs.next()){
                nome = rs.getString("NOME");
                Pedidos Pedido = new Pedidos(rs.getInt("X_SLD"),rs.getInt("X_BG"), rs.getInt("CQ"),rs.getInt("MQ"),rs.getInt("SLD_FRU"),rs.getInt("REFRI"),rs.getInt("SUCO"));
            // Instanciando o objeto preparedStatement (pstmt)​
                pstmt = conn.prepareStatement("INSERT INTO HISTORICO (N_PEDIDO,CPF, NOME, X_SLD, X_BG, CQ, MQ, SLD_FRU, REFRI, SUCO) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?)");
                // Setando o valor aos parâmetros
                pstmt.setInt(1, rs.getInt("N_PEDIDO"));
                pstmt.setString(2, cpf);
                pstmt.setString(3, nome);
                pstmt.setInt(4, Pedido.getQnt_X_salada());
                pstmt.setInt(5, Pedido.getQnt_X_burger());
                pstmt.setInt(6, Pedido.getQnt_Cachorro_quente());
                pstmt.setInt(7, Pedido.getQnt_Misto_quente());
                pstmt.setInt(8, Pedido.getQnt_Salada_de_frutas());
                pstmt.setInt(9, Pedido.getQnt_Refrigerante());
                pstmt.setInt(10, Pedido.getQnt_Suco_natural());
                // Executando o comando sql do objeto preparedStatement​
                pstmt.execute();
                System.out.println("Pedido inserido no Historico com sucesso");
                conexao.desconectar(); // Fechando a conexão com o banco​
            }
            
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
            System.err.println("Falha em Inserir no DB" + e.getMessage());
        }
    }
    public ResultSet buscarPorCpf(String cpf) {
        // Abrindo a conexão com o banco​
        Conecta conexao = new Conecta();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM HISTORICO WHERE CPF = ? ");
            pstmt.setString(1, cpf);
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
            return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
  
}
