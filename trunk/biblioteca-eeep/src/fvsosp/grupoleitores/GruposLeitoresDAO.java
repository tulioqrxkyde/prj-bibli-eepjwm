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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.grupoleitores;

import fvsosp.editora.Editora;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Francisco Junior
 */
public class GruposLeitoresDAO extends GenericDAO<GruposLeitores> {

    /**
     * Construtor da classe GrupoLeitoresDAO.
     */
    public GruposLeitoresDAO() {
        super(GruposLeitores.class);
    }

    /**
     * Pesquisa GrupoLeitores que contenham o nome passado por parâmetro.
     *
     * @param GrupoLeitores String.
     * @return List(c) autores.
     */
    
    /* Metódo da Pesquisa criado por Marcos Ellys */
    public List<GruposLeitores> pesquisaDescricao(String descricao) {
        List<GruposLeitores> descricaoPesquisa = null;

        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            descricaoPesquisa = (List<GruposLeitores>) getSessao().createCriteria(GruposLeitores.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return descricaoPesquisa;
        
     /**
     * Pesquisa GruposLeitores que contenham o pesquisaDescricaoEq passado por parâmetro.
     *
     * @param descricao String.
     * @return List(GruposLeitores) descricaoPesquisa.
     */
        
    }

    public GruposLeitores pesquisaDescricaoEq(String descricao) {
        GruposLeitores descricaoPesquisa = null;

        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            descricaoPesquisa = (GruposLeitores) getSessao().createCriteria(GruposLeitores.class).
                    add(Restrictions.eq("descricao", descricao)).
                    addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return descricaoPesquisa;
    }

    /**
     * Pesquisa descricaoPesquisa que contenha o codigo passado por parâmetro.
     *
     * @param descricao String.
     * @return GruposLeitores descricaoPesquisa.
     */
    
    
    public List<GruposLeitores> pesquisarDescricaoLike(String descricao) {
        List<GruposLeitores> gruposleitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            gruposleitores = (List<GruposLeitores>) getSessao().createCriteria(GruposLeitores.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }

        return gruposleitores;

    }

    /**
     * Pesquisa um gruposleitores que contenha o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return GruposLeitores descricaoPesquisa.
     */
    public GruposLeitores pesquisarCodigo(short codigo) {
        GruposLeitores gruposleitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            gruposleitores = (GruposLeitores) getSessao().createCriteria(GruposLeitores.class).
                    add(Restrictions.eq("idGruposLeitores", codigo)).
                    addOrder(Order.asc("idGruposLeitores")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return gruposleitores;
    }
}