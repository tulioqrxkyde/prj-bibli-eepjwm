/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.idioma;

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
public class IdiomaDAO extends GenericDAO<Idioma>{
    
    public IdiomaDAO(){
        super(Idioma.class);
    }
    
    public List<Idioma> procuraDescricao(String descricao) {
        List<Idioma> idiomas = null;

        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            idiomas = (List<Idioma>) getSessao().createCriteria(Idioma.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        }
        return idiomas;
    }
}
