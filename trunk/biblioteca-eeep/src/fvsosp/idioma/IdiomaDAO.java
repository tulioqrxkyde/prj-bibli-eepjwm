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
package fvsosp.idioma;

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
public class IdiomaDAO extends GenericDAO<Idioma> {

    /**
     * Construtor da classe IdiomaDAO.
     */
    public IdiomaDAO() {
        super(Idioma.class);
    }

    /**
     * Pesquisa Idioma que contenham o nome passado por parâmetro.
     *
     * @param descricao String.
     * @return List(Idioma) idiomas.
     */
    public List<Idioma> pesquisarDescricao(String descricao) {
        List<Idioma> idiomas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            idiomas = (List<Idioma>) getSessao().createCriteria(Idioma.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return idiomas;
    }

    /**
     * Pesquisa Idioma que contenham o nome passado por parâmetro.
     *
     * @param descricao String.
     * @return List(Idioma) idiomas.
     */
    public Idioma pesquisarDescricaoEq(String descricao) {
        Idioma idiomas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            idiomas = (Idioma) getSessao().createCriteria(Idioma.class).
                    add(Restrictions.eq("descricao", descricao)).addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return idiomas;
    }

    /**
     * Pesquisa Idioma que contenham o nome passado por parâmetro.
     *
     * @param codigo String.
     * @return List(Idioma) idiomas.
     */
    public Idioma pesquisarCodigo(short codigo) {
        Idioma idioma = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            idioma = (Idioma) getSessao().createCriteria(Idioma.class).
                    add(Restrictions.eq("idIdioma", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return idioma;
    }
}
