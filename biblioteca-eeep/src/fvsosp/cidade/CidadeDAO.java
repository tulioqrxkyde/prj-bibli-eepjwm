/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.cidade;

import fvsosp.autor.Autor;
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
public class CidadeDAO extends GenericDAO<Cidade> {

    public CidadeDAO() {
        super(Cidade.class);
    }
    /*
     * Na classe GenericDAO já possui um método para carregar o
     * objeto a partir de sua chave primária
     */
    public Cidade pesquisarCodIbge(int codibge) {
        Cidade cidade = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            cidade = (Cidade) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.eq("codibge", String.valueOf(codibge))).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por CodigoIbge: " + e.getMessage());
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

    public Cidade pesquisarCodigo(int codigo) {
        Cidade cidade = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            cidade = (Cidade) getSessao().createCriteria(Autor.class).
                    add(Restrictions.eq("idcidade", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return cidade;
    }
}
