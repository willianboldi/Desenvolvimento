package Main;

import Database.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class WASistemas {
    public static void main(String[] args) {
        Connection conn = null;
        
        Conexao cx = new Conexao();
        conn = cx.getConexao("postgres","123456", "CACA");
        
    
        JOptionPane.showMessageDialog(null,"Conexão Realizada com Sucesso!");
    }
}
