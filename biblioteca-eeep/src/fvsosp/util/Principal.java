package fvsosp.util;

import fvsosp.tipoitem.TipoItem;
import fvsosp.tipoitem.TipoItemDAO;
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
        HibernateUtil.getSessionFactory().openSession();
        
//        u = dao.carregaChavePrimaria(1);
//        JOptionPane.showMessageDialog(null, u.getDescricao());
        
        //        u.setLogin("c");
        //        u.setSenha("c");
        //
        //        dao.salvar(u);
        
               
        /* Modelo de Autenticação */ 
        /* if(dao.autenticaLoginSenha("c", (String) u.md5("c")))
        /*    System.out.println("Sucesso");
        /* else
        /*    System.out.println("Insucesso");
        /* 
        /* Exemplo de pesquisa através do Login */ 
        /* System.out.println("Login: "+dao.pesquisarLogin(u.getLogin()));
         */
        
            
        
        
    }
}