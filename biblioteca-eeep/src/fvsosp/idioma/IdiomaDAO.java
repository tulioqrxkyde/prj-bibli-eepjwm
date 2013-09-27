/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.idioma;

import fvsosp.biblioteca.Biblioteca;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Oziel
 */
public class IdiomaDAO extends GenericDAO<Idioma> {

    public IdiomaDAO() {
        super(Idioma.class);
    }

    public List<Idioma> pesquisarDescricao(String descricao) {
        List<Idioma> idiomas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            idiomas = (List<Idioma>) getSessao().createCriteria(Idioma.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return idiomas;
    }

    public List<Idioma> pesquisarDescricaoLike(String descricao) {
        List<Idioma> idioma = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            idioma = (List<Idioma>) getSessao().createCriteria(Idioma.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return idioma;
    }

    public Idioma pesquisarCodigo(int codigo) {
        Idioma idioma = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            idioma = (Idioma) getSessao().createCriteria(Idioma.class).
                    add(Restrictions.eq("idIdioma", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return idioma;
    }
}
