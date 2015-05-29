package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection getConexao(){//String user, String senha, String banco){
        Connection conn = null;  
        String driver = "org.postgresql.Driver";  
        String user   = "postgres"; 
        String senha = "123456";  
        String url = "jdbc:postgresql://localhost:5432/CACA"; //+ banco;  
        try {  
            
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, senha);
            
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados! \n" + ex.getMessage() );
        }
        
        return conn;
    }
           
}
