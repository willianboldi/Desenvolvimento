package Database;

import Classes.AltRegedit;
import Interfaces.DadosConexao;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection getConexao(){
        Connection conn = null;  
        String driver = "org.postgresql.Driver";  
        String user;
        String senha;
        String url;
        String banco;
        String servidor;
        
        String caminhoSistema ="SOFTWARE\\WASistema\\Conexao";
        try {
            
            banco = AltRegedit.readString(AltRegedit.HKEY_CURRENT_USER,caminhoSistema ,"Banco");
            user = AltRegedit.readString(AltRegedit.HKEY_CURRENT_USER,caminhoSistema ,"User");
            senha = AltRegedit.readString(AltRegedit.HKEY_CURRENT_USER,caminhoSistema ,"Senha");
            servidor = AltRegedit.readString(AltRegedit.HKEY_CURRENT_USER,caminhoSistema ,"Servidor");
        
            url = "jdbc:postgresql://"+ servidor +":5432/" + banco; //+ banco;  
            
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, senha);
            
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados! \n" + ex.getMessage() );
            
            new DadosConexao().setVisible(true);
        }
        
        return conn;
    }
    
    public String getTestConection(String servidor, String user, String senha, String banco){
        Connection conn = null;  
        String driver = "org.postgresql.Driver";  
        String url = "jdbc:postgresql://"+ servidor +":5432/" + banco; //+ banco;  
        
        if (banco.equals("")){
            return "Informe o banco de dados!";
        }
        
        try {
            
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, senha);
            
            return "";
        
        } catch (ClassNotFoundException | SQLException ex) {
            return "Erro ao conectar com o banco de dados: " + ex.getMessage();
        }   
        
       
    }
    
    public void GravarRegedit(String servidor, String user, String senha, String banco){
        Connection conn = null;  
        String driver = "org.postgresql.Driver";  
        String url = "jdbc:postgresql://"+ servidor +":5432/" + banco; //+ banco;  
                
        try {
            String caminhoSistema ="SOFTWARE\\WASistema\\Conexao";
            
            AltRegedit.createKey(AltRegedit.HKEY_CURRENT_USER, caminhoSistema);
            AltRegedit.writeStringValue(AltRegedit.HKEY_CURRENT_USER,caminhoSistema, "Servidor", servidor);
            AltRegedit.writeStringValue(AltRegedit.HKEY_CURRENT_USER,caminhoSistema, "User", user);
            AltRegedit.writeStringValue(AltRegedit.HKEY_CURRENT_USER,caminhoSistema, "Senha", senha);
            AltRegedit.writeStringValue(AltRegedit.HKEY_CURRENT_USER,caminhoSistema, "Banco", banco);
            
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
                             
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Erro ao gravar dados do banco de dados! \n" + ex.getMessage() );
        }   
 
    }
             
}
