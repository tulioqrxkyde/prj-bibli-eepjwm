package fvsosp.util;

import fvsosp.usuario.Usuario;
import fvsosp.usuario.UsuarioDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Pedro Saraiva
 */
public class Principal {

    public static void main(String[] args) {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        u.setLogin("c");
        u.setSenha("c");
        
        dao.salvar(u);
        
    }
}
