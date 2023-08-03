
package interfacecliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {
    private Connection conn;
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            conn = DriverManager.getConnection(url, "postgres", "fei");
            System.out.println("Conectado com Sucesso");
            return conn;
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Erro de conexão" + e.getMessage());
            return null;
        }
    }
    
    public void desconectar(){
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            } 
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }
    
}
