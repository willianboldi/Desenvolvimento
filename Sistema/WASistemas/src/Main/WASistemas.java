package Main;

import Classes.Usuario;
import javax.swing.JOptionPane;

public class WASistemas {
    public static void main(String[] args) {
        //conn = cx.getConexao("postgres","123456", "CACA");
         
        Usuario usuario = new Usuario();
            
        JOptionPane.showMessageDialog(null, "Classes instanciados!");
        
        usuario.setNome("Gravando com herança");
        usuario.setIdentificacao("BOLDI");
        usuario.setCodCargo(1);
        usuario.setCodEmpresa(1);
        usuario.setCpf("355.245.234-32");
        usuario.setRg("48.898.342-9");
        usuario.setCep("14982-298");
        usuario.setEndereco("AV RUA");
        usuario.setBairro("Tamoio");
        usuario.setCodCidade(27);
        
        JOptionPane.showMessageDialog(null, "Cliente setado!");
        
        usuario.Gravar(usuario);
        
        
        JOptionPane.showMessageDialog(null, "FIM!");
        
        
    }
}
