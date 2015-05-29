package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
    public Connection getConexao(String user, String senha, String banco){
        Connection conn = null;  
        String driver = "org.postgresql.Driver";  
        //String user   = "postgres"; 
        //String senha = "123456";  
        String url = "jdbc:postgresql://localhost:5432/" + banco;  
        try {  
            
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, senha);
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
           
}
