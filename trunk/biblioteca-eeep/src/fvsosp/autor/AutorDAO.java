/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.autor;

import fvsosp.editora.Editora;
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
public class AutorDAO extends GenericDAO<Autor> {

    public AutorDAO() {
        super(Autor.class);
    }

    public List<Autor> pesquisarNome(String nome) {
        List<Autor> autores = null;

        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            autores = (List<Autor>) getSessao().createCriteria(Autor.class).
                    add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return autores;
    }

    public List<Autor> pesquisarsobreOAutor(String sobreOAutor) {
        List<Autor> autores = null;

        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            autores = (List<Autor>) getSessao().createCriteria(Autor.class).
                    add(Restrictions.ilike("sobreOAutor", sobreOAutor, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("sobreOAutor")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar sobre autor: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return autores;
    }
    
    public Autor pesquisarCodigo(short codigo) {
        Autor autor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            autor = (Autor) getSessao().createCriteria(Autor.class).
                    add(Restrictions.eq("idAutor", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return autor;
    }
}

