/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import org.hibernate.*;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioDAO extends GenericDAO<Usuario>{

    private Session sessao;
    private Transaction transacao;
    
    public UsuarioDAO(){
        super(Usuario.class);
    }
    
    public String pesquisarLogin(String login) {
        String name = "";
        try {
            this.sessao = HibernateUtil.getSessionFactory().openSession();
            this.transacao = sessao.beginTransaction();
            Query loginFind = sessao.createQuery("select idUsuario from Usuario where login = ?");
            loginFind.setParameter(0, login);
            name = loginFind.list().toString();
        } catch (Throwable t) {
            System.out.println("Não foi possível localizar o login.");
        }
        return name;
    }

    public boolean autenticaLoginSenha(String login, String senha) {
        this.sessao = HibernateUtil.getSessionFactory().openSession();
        this.transacao = sessao.beginTransaction();
        Query loginFind = sessao.createQuery("from Usuario as usr where usr.login = :procurarLogin and usr.senha = :procurarSenha");
        loginFind.setParameter("procurarLogin", login);
        loginFind.setParameter("procurarSenha", senha);
        if (!loginFind.list().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}