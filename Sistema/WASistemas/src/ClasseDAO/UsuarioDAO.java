
package ClasseDAO;

import Classes.Usuario;
import Database.Conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    private final Connection conn;
    
    public UsuarioDAO(){
        conn = new Conexao().getConexao();                          
    }
    
    public void Gravar(Usuario usuario){
        
        PreparedStatement pStm;
        ResultSet rs;
        
        try{ // on error goto erro
            
            String sql = "INSERT INTO Usuario"
                    + " (Nome," //1
                    + " Identificacao," //2
                    + " CodCargo," //3
                    + " CodEmpresa," //4
                    + " CPF," //5
                    + " RG," //6
                    + " CEP," //7
                    + " Endereco," //8
                    + " Bairro," //9
                    + " Cidade)" //10
                    + "Values(?,?,?,?,?,?,?,?,?,?)"; // QTDE = 10
                        
            pStm = conn.prepareStatement(sql);
            
            pStm.setString(1, usuario.getNome());
            pStm.setString(2, usuario.getIdentificacao());
            pStm.setInt(3, usuario.getCodCargo());
            pStm.setInt(4, usuario.getCodEmpresa());
            pStm.setString(5, usuario.getCpf());
            pStm.setString(6, usuario.getRg());
            pStm.setString(7, usuario.getCep());
            pStm.setString(8, usuario.getEndereco());
            pStm.setString(9, usuario.getBairro());
            pStm.setInt(10, usuario.getCodCidade());

            JOptionPane.showMessageDialog(null, "Gravando ...");
            
            pStm.execute();            
            
            JOptionPane.showMessageDialog(null, "Usuário gravado com sucesso!");
            
        }catch(SQLException | HeadlessException ex){ // Erro:
            JOptionPane.showMessageDialog(null,"Erro ao gravar usuário: " + ex.getMessage());
        }
        
    }
    
    public void Alterar(Usuario usuario){
        PreparedStatement pStm;
        ResultSet rs;
        
        try{ // on error goto erro
            
            String sql = "UPDATE Usuario SET"
                    + " Nome = ?," //1
                    + " Identificacao = ?," //2
                    + " CodCargo = ?," //3
                    + " CodEmpresa = ?," //4
                    + " CPF = ?," //5
                    + " RG = ?," //6
                    + " CEP = ?," //7
                    + " Endereco = ?," //8
                    + " Bairro = ?," //9
                    + " Cidade = ?" //10
                    + "WHERE Codigo = ?";//11
                        
            pStm = conn.prepareStatement(sql);
            
            pStm.setString(1, usuario.getNome());
            pStm.setString(2, usuario.getIdentificacao());
            pStm.setInt(3, usuario.getCodCargo());
            pStm.setInt(4, usuario.getCodEmpresa());
            pStm.setString(5, usuario.getCpf());
            pStm.setString(6, usuario.getRg());
            pStm.setString(7, usuario.getCep());
            pStm.setString(8, usuario.getEndereco());
            pStm.setString(9, usuario.getBairro());
            pStm.setInt(10, usuario.getCodCidade());
            pStm.setInt(11, usuario.getCodigo());           
                      
            pStm.execute();            
            
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
            
        }catch(SQLException | HeadlessException ex){ // Erro:
            JOptionPane.showMessageDialog(null,"Erro ao alterar o usuário: " + ex.getMessage());
        }
    }
       
}
