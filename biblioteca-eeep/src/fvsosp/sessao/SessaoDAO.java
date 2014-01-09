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

    public Sessao pesquisarDescricao(String descricao) {
        Sessao sessao = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            sessao = (Sessao) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.eq("descricao", descricao)).
                    addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por descricao: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
            
        return sessao;

    }
    
        
    public List<Sessao> pesquisarDescricaoLike(String descricao) {
        List<Sessao> sessao = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            sessao = (List<Sessao>) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por descricao: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
            
        return sessao;

    }
    
    public Sessao pesquisarCodigo(short codigo) {
        Sessao sessao = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            sessao = (Sessao) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.eq("idSessao", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return sessao;

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
        } finally {
            this.getSessao().close();
        }
        return Sessaoa;

    }
}