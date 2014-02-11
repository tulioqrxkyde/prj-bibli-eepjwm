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
package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
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

    /**
     * Construtor da classe PalavrasChavesDAo.
     */
    public PalavrasChavesDAO() {
        super(PalavrasChaves.class);
    }

    /**
     * Pesquisa PalavrasChaves que contenha a descrição passado por parâmetro.
     *
     * @param descricao String.
     * @return List(PalavrasChaves)PalavrasChavess.
     */
    public List<PalavrasChaves> pesquisarDescricao(String descricao) {
        List<PalavrasChaves> PalavrasChavess = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            PalavrasChavess = (List<PalavrasChaves>) getSessao().createCriteria(PalavrasChaves.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return PalavrasChavess;
    }

    /**
     * Pesquisa PalavrasChaves que contenha a descrição passado por parâmetro.
     *
     * @param descricao String.
     * @return PalavrasChaves PalavrasChavess.
     */
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

    /**
     * Pesquisa PalavrasChaves que contenha o id passado por parâmetro.
     *
     * @param id short.
     * @return PalavrasChaves palavrasChavess.
     */
    public PalavrasChaves pesquisarCodigo(short id) {
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

    /**
     * Pesquisa PalavrasChaves que  contenha o acervo passado por parâmetro.
     *
     * @param acervo Acervo.
     * @return List(PalavrasChaves)PalavrasChavess.
     */
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