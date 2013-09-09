/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.especificacoes;

import fvsosp.acervo.Acervo;
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
public class EspecificacoesTecnicasDAO extends GenericDAO<EspecificacoesTecnicas>{
    
    public EspecificacoesTecnicasDAO(){
        super(EspecificacoesTecnicas.class);
    }

  /* Metódo da Pesquisa criado por Marcos Ellys */  
    
public List<Acervo> pesquinaAcervo(String acervo) {
        List<Acervo> acervos = null;

        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            acervos = (List<Acervo>) getSessao().createCriteria(Acervo.class).
                    add(Restrictions.like("acervo", acervo, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("acervo")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Acervo: " + e.getMessage());
        }
        return acervos;
    }


}
