/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.palavraschaves;

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
public class PalavrasChavesDAO extends GenericDAO<PalavrasChaves> {

    public PalavrasChavesDAO() {
        super(PalavrasChaves.class);
    }

    public List<PalavrasChaves> pesquisarDescricao(String descricao) {
        List<PalavrasChaves> PalavrasChavess = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            PalavrasChavess = (List<PalavrasChaves>) getSessao().createCriteria(PalavrasChaves.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return PalavrasChavess;
    }
    
    public PalavrasChaves pesquisarDescricaoEq(String descricao) {
        PalavrasChaves PalavrasChavess = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            PalavrasChavess = (PalavrasChaves) getSessao().createCriteria(PalavrasChaves.class).
                    add(Restrictions.eq("descricao", descricao)).
                    addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return PalavrasChavess;
    }
    
    public PalavrasChaves pesquisarCodigo(short id){
    PalavrasChaves palavrasChavess = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            palavrasChavess = (PalavrasChaves) getSessao().createCriteria(PalavrasChaves.class).
                    add(Restrictions.eq("idPalavrasChaves", id)).
                    addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Palavra Chave: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return palavrasChavess;
    }

    public List<PalavrasChaves> pesquisarAcervo(Acervo acervo) {
        List<PalavrasChaves> PalavrasChavess = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            PalavrasChavess = (List<PalavrasChaves>) getSessao().createCriteria(PalavrasChaves.class).
                    add(Restrictions.eq("acervo", acervo)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Acervo: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return PalavrasChavess;
    }
}