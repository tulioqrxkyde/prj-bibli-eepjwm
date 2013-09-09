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
public class EspecificacoesTecnicasDAO extends GenericDAO<EspecificacoesTecnicas> {

    public EspecificacoesTecnicasDAO() {
        super(EspecificacoesTecnicas.class);
    }

    /* Metódo da Pesquisa criado por Marcos Ellys */
    public EspecificacoesTecnicas pesquisaPorAcervo(Acervo acervo) {
        EspecificacoesTecnicas et = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            et = (EspecificacoesTecnicas) this.getSessao().createCriteria(EspecificacoesTecnicas.class).
                    add(Restrictions.eq("acervo", acervo)).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Acervo: " + e.getMessage());
        }
        return et;
    }
}
