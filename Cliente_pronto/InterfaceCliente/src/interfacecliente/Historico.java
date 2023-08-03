/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacecliente;

import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Historico {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    
    public String VerificarPedido(String cpf) {
        // Abrindo a conexão com o banco​
        Conecta conexao = new Conecta();
        conn = conexao.conectar();
        int N_pedido=0;
        try {
            Historico historico = new Historico();
            ResultSet rs_pedido = historico.buscar();
            String Status=("");
            while(rs_pedido.next()){
                if (rs_pedido.getInt("N_PEDIDO")>N_pedido){
                    N_pedido= rs_pedido.getInt("N_PEDIDO");
                }
            }
            Clientes cliente = new Clientes();
            ResultSet rs_clientes = cliente.buscarPorCpf(cpf);
            while(rs_clientes.next()){
                if (rs_clientes.getInt("N_PEDIDO")>N_pedido){
                    PedidosFeitos Pedido1 = new PedidosFeitos(rs_clientes.getInt("X_SLD"),rs_clientes.getInt("X_BG"), rs_clientes.getInt("CQ"),rs_clientes.getInt("MQ"),rs_clientes.getInt("SLD_FRU"),rs_clientes.getInt("REFRI"),rs_clientes.getInt("SUCO"));
                    Status = Status + "Pedido ainda não está pronto\n"+Pedido1+"\n"+"Valor: R$ "+Pedido1.getConta();
                }
                else if (N_pedido == 0 && rs_clientes.getInt("N_PEDIDO")==0 ){
                    Status = Status + "Não possui pedidos";
                }
                else{
                    ResultSet rs_historico = historico.buscarPorN_Pedido(N_pedido);
                    while(rs_historico.next()){
                        PedidosFeitos Pedido = new PedidosFeitos(rs_historico.getInt("X_SLD"),rs_historico.getInt("X_BG"), rs_historico.getInt("CQ"),rs_historico.getInt("MQ"),rs_historico.getInt("SLD_FRU"),rs_historico.getInt("REFRI"),rs_historico.getInt("SUCO"));
                        Status = Status + "Pedido está pronto!\n"+Pedido+"\n"+"Valor: R$ "+Pedido.getConta();
                    }
                }
            }
            return Status;
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
            System.err.println("Falha em Inserir no DB" + e.getMessage());
            return null;
        }
    }
   
    public ResultSet buscarPorN_Pedido(int N_PEDIDO) {
        // Abrindo a conexão com o banco​
        Conecta conexao = new Conecta();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM HISTORICO WHERE N_PEDIDO = ? ");
            pstmt.setInt(1, N_PEDIDO);
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
            return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
        public ResultSet buscar() {
        // Abrindo a conexão com o banco​
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar(); 
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM HISTORICO ORDER BY N_PEDIDO");
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
