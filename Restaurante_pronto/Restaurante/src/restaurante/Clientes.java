
package restaurante;


import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Clientes {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs; 
    
    public void inserirSemPedidos(String cpf, String senha) {
        // Abrindo a conexão com o banco​
       Conecta conexao = new Conecta();
        conn = conexao.conectar();
        try {  
            Clientes cliente = new Clientes();
            ResultSet rs = cliente.buscarPorCpf(cpf);
            Historico historico = new Historico();
            rs = historico.buscarPorCpf(cpf);
            String nome;
            while(rs.next()){
                nome = rs.getString("NOME");
            // Instanciando o objeto preparedStatement (pstmt)​
                pstm = conn.prepareStatement("INSERT INTO CLIENTES (CPF,SENHA, NOME) VALUES (?, ?,?)");
                // Setando o valor aos parâmetros
                pstm.setString(1, cpf);
                pstm.setString(2, senha);
                pstm.setString(3, nome);
                // Executando o comando sql do objeto preparedStatement​
                pstm.execute();
                System.out.println("Pedido inserido no Historico com sucesso");
                conexao.desconectar(); // Fechando a conexão com o banco​
            }
            
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
            System.err.println("Falha em Inserir no DB" + e.getMessage());
        }
    }

    public void remover(String cpf){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso");
        
        try {
            pstm = conn.prepareStatement("DELETE FROM CLIENTES WHERE CPF = ?");
            pstm.setString(1, cpf);
            pstm.execute();
            System.out.println("Removido com sucesso");
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Falha ao remover no DB: " + ex.getMessage());
        }
    }
    public ResultSet buscar(){
         Conecta conexao = new Conecta();
         this.conn = conexao.conectar();
         try{
             pstm = conn.prepareStatement("SELECT * FROM CLIENTES ORDER BY CPF");
             rs = pstm.executeQuery();
             return rs;
         }
         catch (SQLException e){
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
                Pedidos Pedido = new Pedidos(rs.getInt("X_SLD"),rs.getInt("X_BG"), rs.getInt("CQ"),rs.getInt("MQ"),rs.getInt("SLD_FRU"),rs.getInt("REFRI"),rs.getInt("SUCO"));
                double cont = Pedido.getConta();
                pedidos = pedidos + ("Cliente: "+ rs.getString("NOME")+"  |  CPF: "+ rs.getString("CPF")+"\n"+Pedido+"\n"+"Valor da compra: R$ "+ cont+"\n"); 
                if (rs.getInt("X_SLD")+rs.getInt("X_BG")+ rs.getInt("CQ")+rs.getInt("MQ")+rs.getInt("SLD_FRU")+rs.getInt("REFRI")+rs.getInt("SUCO")==0){
                    pedidos = "Cliente não possui pedidos";
                }
            }
            
            return pedidos;
        } catch (SQLException ex) {
            System.out.println("Consulta não foi possível" + ex.getMessage());
            return null;
        }
    }
    public String PrintPedido(String cpf){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar(); 
        try {
            Clientes clientes = new Clientes();
            ResultSet rs =clientes.buscarPorCpf(cpf);
            String pedidos=("");
            while(rs.next()){
                Pedidos Pedido = new Pedidos(rs.getInt("X_SLD"),rs.getInt("X_BG"), rs.getInt("CQ"),rs.getInt("MQ"),rs.getInt("SLD_FRU"),rs.getInt("REFRI"),rs.getInt("SUCO"));
                pedidos = pedidos + ("Cliente: "+ rs.getString("NOME")+"  |  CPF: "+ rs.getString("CPF")+"\n"+Pedido+"\n");  
                if (rs.getInt("X_SLD")+rs.getInt("X_BG")+ rs.getInt("CQ")+rs.getInt("MQ")+rs.getInt("SLD_FRU")+rs.getInt("REFRI")+rs.getInt("SUCO")==0){
                    pedidos = "Cliente não possui pedidos";
                }
            }
            return pedidos;
        } catch (SQLException ex) {
            System.out.println("Consulta não foi possível" + ex.getMessage());
            return null;
        }
    }
    
    public String PrintFilaPedidos(){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();  
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscar();
            String Cadastros=("");
            while(rs.next()){
                Pedidos Pedido = new Pedidos(rs.getInt("X_SLD"),rs.getInt("X_BG"), rs.getInt("CQ"),rs.getInt("MQ"),rs.getInt("SLD_FRU"),rs.getInt("REFRI"),rs.getInt("SUCO"));
                if ((rs.getInt("X_SLD")+rs.getInt("X_BG")+ rs.getInt("CQ")+rs.getInt("MQ")+rs.getInt("SLD_FRU")+rs.getInt("REFRI")+rs.getInt("SUCO"))!=0){
                   Cadastros = Cadastros + ("Cliente: "+ rs.getString("NOME")+"  |  CPF: "+ rs.getString("CPF")+"\nNúmero do Pedido: "+rs.getInt("N_PEDIDO")+"\n"+Pedido+"\n"+
                        "-----------------------------------------"+"\n");    
                }
            }
          return Cadastros;
        } catch (SQLException ex) {
            System.out.println("Falha ao encontrar no DB: " + ex.getMessage());
            return null;
        }
    }
    public String PrintClientes(){
        Conecta conexao = new Conecta();
        this.conn = conexao.conectar();  
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscar();
            String Cadastros=("");
            while(rs.next()){
                Cadastros = Cadastros + ("Cliente: "+ rs.getString("NOME")+"  |  CPF: "+ rs.getString("CPF")+"\n");      
            }
          return Cadastros;
        } catch (SQLException ex) {
            System.out.println("Falha ao encontrar no DB: " + ex.getMessage());
            return null;
        }
    }
    
    public ResultSet buscarPorCpf(String cpf) {
        // Abrindo a conexão com o banco​
        Conecta conexao = new Conecta();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstm = conn.prepareStatement("SELECT * FROM CLIENTES WHERE CPF = ? ");
            pstm.setString(1, cpf);
            // Executando o comando sql e armazenando no ResultSet
            rs = pstm.executeQuery();
            //Retornando o ResultSet​
            return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }  
      public String getSenha(String cpf){
        // Abrindo a conexão com o banco​
       Conecta conexao = new Conecta();
       conn = conexao.conectar();
       String senha="";
        try {
            Clientes clientes = new Clientes();
            ResultSet rs = clientes.buscarPorCpf(cpf);
            while(rs.next()){
                senha = rs.getString("SENHA");
            }
            return senha;
        }
        catch (SQLException e){
             conexao.desconectar();
             return null;
        }
    }
}
