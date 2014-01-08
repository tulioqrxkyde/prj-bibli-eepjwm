/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.exemplar;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class ExemplarDAO extends GenericDAO<Exemplar> {
    
    public ExemplarDAO() {
        super(Exemplar.class);
    }
    
    public Exemplar pesquisarTombo(short tombo) {
        Exemplar exemplar = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            exemplar = (Exemplar) getSessao().createCriteria(Exemplar.class).
                    add(Restrictions.eq("tombo", tombo)).addOrder(Order.asc("exemplar")).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Tombo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return exemplar;
    }
    
    public List<Exemplar> pesquisarAcervo(Acervo acervo) {
        List<Exemplar> exemplar = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            exemplar = (List<Exemplar>) getSessao().createCriteria(Acervo.class).
                    add(Restrictions.eq("acervo", acervo)).addOrder(Order.asc("exemplar")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Acervo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return exemplar;
    }
    
    
}
