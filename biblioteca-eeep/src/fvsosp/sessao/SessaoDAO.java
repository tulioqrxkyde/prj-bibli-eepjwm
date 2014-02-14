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
package fvsosp.sessao;

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
 * @author oziel.ico
 */
public class SessaoDAO extends GenericDAO<Sessao> {

    /**
     * Construtor da classe SeesaoDAO.
     */
    public SessaoDAO() {
        super(Sessao.class);
    }

    /**
     * Pesquisa uma Sessao que contenha a descrição passada por parâmetro.
     *
     * @param descricao String.
     * @return Sessao sessao.
     */
    public Sessao pesquisarDescricao(String descricao) {
        Sessao sessao = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            sessao = (Sessao) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.eq("descricao", descricao)).
                    addOrder(Order.asc("descricao")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por descricao: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }

        return sessao;

    }

    /**
     * Pesquisa por Sessões que contenham a descrição passada por parâmetro.
     *
     * @param descricao String.
     * @return List(Sessao) sessao.
     */
    public List<Sessao> pesquisarDescricaoLike(String descricao) {
        List<Sessao> sessao = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            sessao = (List<Sessao>) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por descricao: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }

        return sessao;

    }

    /**
     * Pesquisa uma Sessao que contenha o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return Sessao sessao.
     */
    public Sessao pesquisarCodigo(short codigo) {
        Sessao sessao = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            sessao = (Sessao) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.eq("idSessao", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return sessao;

    }

    /**
     * Pesquisa uma Sessao que contenha o acervo passado por parâmetro.
     *
     * @param acervos Acervo.
     * @return List(Sessao) sessao.
     */
    public List<Sessao> pesquisarAcervos(Acervo acervos) {
        List<Sessao> sessao = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            sessao = (List<Sessao>) getSessao().createCriteria(Sessao.class).
                    add(Restrictions.eq("acervos", acervos)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por acervos: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return sessao;
    }
}