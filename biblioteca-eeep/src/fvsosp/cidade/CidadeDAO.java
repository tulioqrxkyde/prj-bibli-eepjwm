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
package fvsosp.cidade;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.*;

/**
 *
 * @author oziel.ico
 */
public class CidadeDAO extends GenericDAO<Cidade> {

    /**
     * Construtor.
     */
    public CidadeDAO() {
        super(Cidade.class);
    }

    /**
     * Pesquisa uma Cidade que contenha o código do IBGE passado por parâmetro.
     *
     * @param codibge int.
     * @return Cidade cidade.
     */
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

    /**
     * Pesquisa Cidades que contenham a descrição passada por parâmetro.
     *
     * @param descricao String.
     * @return List(Cidade) cidades.
     */
    public List<Cidade> pesquisarDescricao(String descricao) {
        List<Cidade> cidades = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            cidades = (List<Cidade>) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return cidades;
    }

    /**
     * Pesquisa uma Cidade que contenha a descrição passada por parâmetro.
     *
     * @param descricao String.
     * @return Cidade cidades.
     */
    public Cidade pesquisarDescricaoEq(String descricao) {
        Cidade cidades = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            cidades = (Cidade) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.eq("descricao", descricao)).
                    addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return cidades;

    }

    /**
     * Pesquisa Cidades que contenham o uf passado por parâmetro.
     *
     * @param uf String.
     * @return List(Cidade) cidades.
     */
    public List<Cidade> pesquisarUf(String uf) {
        List<Cidade> cidades = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            cidades = (List<Cidade>) getSessao().createCriteria(Cidade.class).
                    add(Restrictions.ilike("descricao", uf, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao pesquisar por UF: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return cidades;
    }
}