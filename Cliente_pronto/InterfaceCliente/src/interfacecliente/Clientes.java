
package interfacecliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Clientes {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs; 

    public void inserir(Pessoa pessoa){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso");
        //
        try {
            // so cpf eh obrigatorio por ser first key
            pstm = conn.prepareStatement("INSERT INTO CLIENTES (NOME, CPF, SENHA) VALUES (?, ?, ?)");
            // trocar interrogacoes
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getCpf());
            pstm.setString(3, pessoa.getSenha());
            pstm.execute();
            System.out.println("Inserido com sucesso");
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir no DB: " + ex.getMessage());
        }
    }
    
    public String getNome(String cpf){
        Conecta conexao = new Conecta();
        conn = conexao.conectar();
        String nome = "";
        try {
            Clientes clientes = new Clientes();
            ResultSet rs =clientes.buscarPorCpf(cpf);
            while(rs.next()){
                nome = rs.getString("NOME");
               // conexao.desconectar(); // Fechando a conexão com o banco​
            }
            return nome;
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
            System.err.println("Falha em Inserir no DB" + e.getMessage());
            return null;
        }
    }
    
        
    public String getSenha(String cpf){
        Conecta conexao = new Conecta();
        conn = conexao.conectar();
        String senha = "";
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscarPorCpf(cpf);
            while(rs.next()){
                senha = rs.getString("SENHA");
            }
            return senha;
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
            System.err.println("Falha em Inserir no DB" + e.getMessage());
            return null;
        }
    }
    
    public boolean remover(String cpf){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso na remocao");
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscarPorCpf(cpf);
            int soma=0;
            while(rs.next()){
            soma =rs.getInt("X_SLD")+ rs.getInt("X_BG")+ rs.getInt("CQ")+rs.getInt("MQ")+rs.getInt("SLD_FRU")+rs.getInt("REFRI")+rs.getInt("SUCO");
            }
            if(soma!=0){
                pstm = conn.prepareStatement("DELETE FROM CLIENTES WHERE CPF = ?");
                pstm.setString(1, cpf);
                pstm.execute();
                System.out.println("Removido com sucesso");
                conexao.desconectar();
                return true;
            }
            else{
                System.out.println("AQUI REMOVER");   
                return false; 
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao remover no DB: " + ex.getMessage());
            return false;
        }
    }
    
    public void inserirPedido(String cpf, PedidosFeitos pedido){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        Clientes cliente = new Clientes();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso");
        //
        try {
            // so cpf eh obrigatorio por ser first key
            pstm = conn.prepareStatement("UPDATE CLIENTES SET X_SLD= ?, X_BG= ?, CQ= ?, MQ= ?, SLD_FRU= ?, REFRI= ?, SUCO = ?, N_PEDIDO = ? WHERE CPF = ?");
            // trocar interrogacoes
            pstm.setInt(1, pedido.getQnt_X_salada());
            pstm.setInt(2, pedido.getQnt_X_burger());
            pstm.setInt(3, pedido.getQnt_Cachorro_quente());
            pstm.setInt(4, pedido.getQnt_Misto_quente());
            pstm.setInt(5, pedido.getQnt_Salada_de_frutas());
            pstm.setInt(6, pedido.getQnt_Refrigerante());
            pstm.setInt(7, pedido.getQnt_Suco_natural());
            pstm.setInt(8, cliente.NumeroPedido());
            pstm.setString(9, cpf);
            pstm.execute();
            System.out.println("Inserido com sucesso");
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir no DB: " + ex.getMessage());
        }
    }
    public ResultSet buscarPorCpf(String cpf) {
        // Abrindo a conexão com o banco​
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)
            pstm = conn.prepareStatement("SELECT * FROM CLIENTES WHERE CPF = ? ");
            pstm.setString(1, cpf);
            // Executando o comando sql e armazenando no ResultSet
            rs = pstm.executeQuery();
            //Retornando o ResultSet​
            return rs;
        } catch (SQLException e) {
            System.out.println("Incapaz");
            conexao.desconectar();
            return null;
        }
    }
    public String PrintExtratoCliente(String cpf){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar(); 
        try {
            Clientes clientes = new Clientes();
            ResultSet rs =clientes.buscarPorCpf(cpf);
            String pedidos=("");
            while(rs.next()){
                PedidosFeitos pedido = new PedidosFeitos(rs.getInt("X_SLD"),rs.getInt("X_BG"), rs.getInt("CQ"),rs.getInt("MQ"),rs.getInt("SLD_FRU"),rs.getInt("REFRI"),rs.getInt("SUCO"));
                double cont = pedido.getConta();
                pedidos = pedidos + ("Cliente: "+ rs.getString("NOME")+"  |  CPF: "+ rs.getString("CPF")+"\n"+pedido+"\n"+"Valor da compra: R$ "+ cont+"\n");  
            }
            if (pedidos.equals("")){
            pedidos = "Cliente não possui pedidos";
            }
            return pedidos;
        } catch (SQLException ex) {
            System.out.println("Conulta não foi possível" + ex.getMessage());
            return null;
        }
    }
    public ResultSet buscar() {
        // Abrindo a conexão com o banco​
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar(); 
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstm = conn.prepareStatement("SELECT * FROM CLIENTES ORDER BY CPF");
            // Executando o comando sql e armazenando no ResultSet
            rs = pstm.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
    
    public ArrayList pegarPedido(String cpf){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso na remocao");
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscarPorCpf(cpf);
            ArrayList<Integer> soma = new ArrayList();
            while(rs.next()){
                soma.add(rs.getInt("X_SLD")); 
                soma.add(rs.getInt("X_BG"));
                soma.add(rs.getInt("CQ"));
                soma.add(rs.getInt("MQ"));
                soma.add(rs.getInt("SLD_FRU"));
                soma.add(rs.getInt("REFRI"));
                soma.add(rs.getInt("SUCO"));
            }
            return soma;
            
            
        } catch (SQLException ex) {
            System.out.println("Falha ao remover no DB: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean buscarPedido(String cpf){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso na remocao");
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscarPorCpf(cpf);
            int soma=0;
            while(rs.next()){
            soma =rs.getInt("X_SLD")+ rs.getInt("X_BG")+ rs.getInt("CQ")+rs.getInt("MQ")+rs.getInt("SLD_FRU")+rs.getInt("REFRI")+rs.getInt("SUCO");
            }
            if(soma!=0){   
                return true;
            }
            else{
                return false; 
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao remover no DB: " + ex.getMessage());
            return false;
        }
    }
     public int NumeroPedido(){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        int maior = 0;
        try {
            Clientes clientes = new Clientes();
            ResultSet rs =clientes.buscar();
            while(rs.next()){
                if (rs.getInt("N_PEDIDO")>maior){
                    maior = rs.getInt("N_PEDIDO");               
                }
            }
            Historico historico = new Historico();
            ResultSet rs_novo = historico.buscar();
            while(rs_novo.next()){
                if (rs_novo.getInt("N_PEDIDO")>maior){
                    maior = rs_novo.getInt("N_PEDIDO");               
                }
            }  
        return maior+1;
        } catch (SQLException ex) {
            System.out.println("Consulta não foi possível" + ex.getMessage());
            return 0;
            }
     }
}
