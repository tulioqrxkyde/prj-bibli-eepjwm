/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
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
public class SessaoDAO extends GenericDAO<Sessao> {

    public SessaoDAO() {
        super(Sessao.class);
    }

    public List<Sessao> pesquisarDescricao(String descricao) {
        List<Sessao> Sessaoa = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            Sessaoa = (List<Sessao>) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.like("decricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por descricao: " + e.getMessage());
        }
        return Sessaoa;

    }

    public List<Sessao> pesquisarAcervos(Acervo acervos) {
        List<Sessao> Sessaoa = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            Sessaoa = (List<Sessao>) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.eq("acervos", acervos)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por acervos: " + e.getMessage());
        }
        return Sessaoa;

    }
}