package fvsosp.cidade;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.*;


/**
 *
 * @author Oziel
 */
public class CidadeDAO extends GenericDAO<Cidade> {

    public CidadeDAO() {
        super(Cidade.class);
    }

    public Cidade pesquisarCodIbge(int codibge) {
        Cidade cidade = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            cidade = (Cidade) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.eq("codIBGE", codibge)).
                    addOrder(Order.asc("codIBGE")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar pelo Código do IBGE: " + e.getMessage());
        } finally {
            getSessao().close();
        }           
        return cidade;
    }

    public List<Cidade> pesquisarDescricao(String descricao) {
        List<Cidade> cidades = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            cidades = (List<Cidade>) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return cidades;

    }

    public List<Cidade> pesquisarUf(String uf) {
        List<Cidade> cidades = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            cidades = (List<Cidade>) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.like("descricao", uf, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao pesquisar por UF: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return cidades;
    }
}