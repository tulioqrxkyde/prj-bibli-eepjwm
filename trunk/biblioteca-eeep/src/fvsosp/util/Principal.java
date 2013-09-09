package fvsosp.util;

import fvsosp.usuario.Usuario;
import fvsosp.usuario.UsuarioDAO;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Pedro Saraiva
 */
public class Principal {

    public static void main(String[] args) {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        //        u.setLogin("c");
        //        u.setSenha("c");
        //
        //        dao.salvar(u);
        
        List<Usuario> listar = dao.listar();
        for (int i = 0; i < dao.listar().size(); i++) {
            JOptionPane.showMessageDialog(null, dao.listar().get(i).getLogin());
        }
        
        // Modelo de Autenticação 
        if(dao.autenticaLoginSenha("c", (String) u.md5("c")))
            System.out.println("Sucesso");
        else
            System.out.println("Insucesso");
      
        /* Exemplo de pesquisa através do Login */ 
         System.out.println("Login: "+dao.pesquisarLogin(u.getLogin()));
        //*/
        
    }
}