/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package fvsosp.autor;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author oziel.ico
 */
public class AutorDAO extends GenericDAO<Autor> {

    /**
     * Construtor da classe AutorDAO.
     */
    public AutorDAO() {
        super(Autor.class);
    }

    /**
     * Pesquisa Autores que contenham o nome passado por parâmetro.
     *
     * @param nome String.
     * @return List(Autor) autores.
     */
    public List<Autor> pesquisarNome(String nome) {
        List<Autor> autores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            autores = (List<Autor>) getSessao().createCriteria(Autor.class).
                    add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return autores;
    }

    /**
     * Pesquisa Autores que contenham o sobreOAutor passado por parâmetro.
     *
     * @param sobreOAutor String.
     * @return List(Autor) autores.
     */
    public List<Autor> pesquisarsobreOAutor(String sobreOAutor) {
        List<Autor> autores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            autores = (List<Autor>) getSessao().createCriteria(Autor.class).
                    add(Restrictions.ilike("sobreOAutor", sobreOAutor, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("sobreOAutor")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar sobre autor: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return autores;
    }

    /**
     * Pesquisa um Autor que contenha o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return Autor autores.
     */
    public Autor pesquisarCodigo(short codigo) {
        Autor autor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            autor = (Autor) getSessao().createCriteria(Autor.class).
                    add(Restrictions.eq("idAutor", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return autor;
    }
}