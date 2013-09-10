/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.cidade;

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

    public List<Cidade> pesquisarCodIbge(int codibge) {
        List<Cidade> cidades = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            cidades = (List<Cidade>) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.eq("codibge", codibge)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por CodigoIbge: " + e.getMessage());
        }
        return cidades;
    
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
        }
        return cidades;
    
    }
       
        public List<Cidade> pesquisarUf(String descricao) {
        List<Cidade> cidades = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            cidades = (List<Cidade>) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao pesquisar por UF: " + e.getMessage());
        }
        return cidades;
    }
}
