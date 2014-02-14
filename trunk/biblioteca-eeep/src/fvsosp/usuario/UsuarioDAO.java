/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package fvsosp.usuario;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    /**
     * Construtor da classe UsuarioDAO.
     */
    public UsuarioDAO() {
        super(Usuario.class);
    }

    /**
     * Pesquisa um Usuario que contenha o login passado por parâmetro.
     *
     * @param String login.
     * @return Usuario usuario.
     */
    public Usuario pesquisarLogin(String login) {
        Usuario usuario = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            usuario = (Usuario) getSessao().createCriteria(Usuario.class)
                    .add(Restrictions.eq("login", login)).uniqueResult();
            this.getTransacao().commit();
        } catch (Throwable t) {
            System.out.println("Não foi possível localizar o login.");
        } finally {
            this.getSessao().close();
        }
        return usuario;
    }

    /**
     * Pesquisa um Usuario que contenha o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return Usuario usuario.
     */
    public Usuario pesquisarCodigo(short codigo) {
        Usuario usuario = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            usuario = (Usuario) getSessao().createCriteria(Usuario.class)
                    .add(Restrictions.eq("idUsuario", codigo)).uniqueResult();
            this.getTransacao().commit();
        } catch (Throwable t) {
            System.out.println("Não foi possível localizar o código.");
        } finally {
            this.getSessao().close();
        }
        return usuario;
    }

    /**
     * Pesquisa um Usuario que contenha o login passado por parâmetro.
     *
     * @param login String.
     * @return List(Usuario) usuario.
     */
    public List<Usuario> pesquisarLoginLike(String login) {
        List<Usuario> usuario = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            usuario = (List<Usuario>) getSessao().createCriteria(Usuario.class)
                    .add(Restrictions.like("login", login, MatchMode.ANYWHERE)).list();
            this.getTransacao().commit();
        } catch (Throwable t) {
            System.out.println("Não foi possível localizar o login.");
        } finally {
            this.getSessao().close();
        }
        return usuario;
    }

    /**
     * Pesquisa um Usuario que contenha o usuario passado por parâmetro.
     *
     * @param usuario Usuario.
     * @return usuario Usuario.
     */
    public Usuario pesquisaUsuario(Usuario usuario) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            return (Usuario) getSessao().createCriteria(Usuario.class).
                    add(Restrictions.eq("login", usuario.getLogin())).
                    add(Restrictions.eq("senha", usuario.getSenha())).uniqueResult();
        } catch (Exception e) {
            System.out.println("Erro encontrado. Erro " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return null;
    }
}