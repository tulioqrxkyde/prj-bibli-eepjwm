/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    /*
     * Camada de Dados referente a Usuário,
     * essa classe deve conter métodos especificos a persistência de 
     * dados de Usuário, a msma extends GenericDAO
     * herdando assim métodos comuns a classes persistentes
     */
    public UsuarioDAO() {
        super(Usuario.class);
    }

    /*
     * Recebe um login por parâmetro e procura
     * se encontrar retorna o usuário
     */
    public List<Usuario> pesquisarLogin(String login) {
        List<Usuario> usuario = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            usuario = getSessao().createCriteria(Usuario.class)
                    .add(Restrictions.like("login", login, MatchMode.ANYWHERE)).list();
            this.getTransacao().commit();
            this.getSessao().close();
        } catch (Throwable t) {
            System.out.println("Não foi possível localizar o login.");
        }
        return usuario;
    }

    public Usuario pesquisaUsuario(Usuario usuario) {
        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            return (Usuario) getSessao().createCriteria(Usuario.class).
                    add(Restrictions.eq("login", usuario.getLogin())).
                    add(Restrictions.eq("senha", usuario.getSenha())).uniqueResult();
        } catch (Exception e) {
            System.out.println("Erro encontrado. Erro "+e.getMessage());            
        }
        return null;
    }
}