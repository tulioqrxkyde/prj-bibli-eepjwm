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
package fvsosp.biblioteca;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author oziel.ico
 */
public class BibliotecaDAO extends GenericDAO<Biblioteca> {

    /**
     * Construtor.
     */
    public BibliotecaDAO() {
        super(Biblioteca.class);
    }

    /**
     * Pesquisa Bibliotecas que contenham a descrição passada por parâmetro.
     *
     * @param descricao String.
     * @return List(Biblioteca) bibliotecas.
     */
    public List<Biblioteca> pesquisarDescricao(String descricao) {
        List<Biblioteca> bibliotecas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            bibliotecas = (List<Biblioteca>) getSessao().createCriteria(Biblioteca.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return bibliotecas;
    }

    /**
     * Pesquisa uma Biblioteca que contenha a descrição passada por parâmetro.
     *
     * @param descricao String.
     * @return Biblioteca biblioteca.
     */
    public Biblioteca pesquisarDescricaoEq(String descricao) {
        Biblioteca bibliotecas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            bibliotecas = (Biblioteca) getSessao().createCriteria(Biblioteca.class).
                    add(Restrictions.eq("descricao", descricao)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return bibliotecas;
    }

    /**
     * Pesquisa uma Biblioteca que contenha a descrição passada por parâmetro.
     *
     * @param codigo short.
     * @return Biblioteca biblioteca.
     */
    public Biblioteca pesquisarCodigo(short codigo) {
        Biblioteca biblioteca = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            biblioteca = (Biblioteca) getSessao().createCriteria(Biblioteca.class).
                    add(Restrictions.eq("idBiblioteca", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return biblioteca;
    }
}