/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioDAO extends GenericDAO<Usuario>{

    public UsuarioDAO(){
        super(Usuario.class);
    }
    
    /*
     * Recebe um login por parâmetro e procura
     * se encontrar retorna o usuário
     */
    public Usuario pesquisarLogin(String login) {
        Usuario usuario=null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            Query loginFind = getSessao().createQuery("from Usuario where login = ?");
            loginFind.setParameter(0, login);
            usuario = (Usuario) loginFind.list().get(0);
            this.getTransacao().commit();
            this.getSessao().close();
        } catch (Throwable t) {
            System.out.println("Não foi possível localizar o login.");
        }
        return usuario;
    }

    /*
     * Recebe um usuário e verifica o seu login e senha estão corretos
     * caso estejam ele retorna true, caso não retorna false
     */
    public boolean autenticaLoginSenha(Usuario usuario) {
        this.setSessao(HibernateUtil.getSessionFactory().openSession());
        this.setTransacao(this.getSessao().beginTransaction());
        Query loginFind = this.getSessao().createQuery("from Usuario as usr where usr.login = :procurarLogin and usr.senha = :procurarSenha");
        loginFind.setParameter("procurarLogin", usuario.getLogin());
        loginFind.setParameter("procurarSenha", usuario.getSenha());
        this.getTransacao().commit();
        this.getSessao().close();
        if (!loginFind.list().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}