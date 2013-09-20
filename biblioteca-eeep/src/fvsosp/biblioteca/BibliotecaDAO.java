/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.biblioteca;

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
public class BibliotecaDAO extends GenericDAO<Biblioteca> {

    public BibliotecaDAO() {
        super(BibliotecaDAO.class);
    }

    public Biblioteca pesquisarDescricao(String descricao) {
        Biblioteca bibliotecas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            /*
             * pesquisa uma biblioteca por descricao
             * usando o like, o MatchMode.ANYWHERE quer dizer
             * que a sequência de caracteres passada na String descricao
             * pode ser encontrada em qualquer lugar, representa o '%descricao%', ordenando
             * de forma crescente por descicao
             */
            bibliotecas = (Biblioteca) getSessao().createCriteria(Biblioteca.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return bibliotecas;
    }
}

