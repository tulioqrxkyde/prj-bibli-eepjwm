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
package fvsosp.tipoitem;

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
public class TipoItemDAO extends GenericDAO<TipoItem> {

    /**
     * Construtor da classe TipoItemDAO.
     */
    public TipoItemDAO() {
        super(TipoItem.class);
    }

    /**
     * Pesquisa TipoItem que contenha a descrição passado por parâmetro.
     *
     * @param descricao String.
     * @return List(TipoItem)tipoitens.
     */
    public List<TipoItem> procuraDescricao(String descricao) {
        List<TipoItem> tipoitens = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            /**
             * pesquisa um tipo de item por descricao usando o ilike, o
             * MatchMode.ANYWHERE quer dizer que a sequência de caracteres
             * passada na String descricao pode ser encontrada em qualquer
             * lugar, representa o '%descricao%', ordenando de forma crescente
             * por descicao
             */
            tipoitens = (List<TipoItem>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return tipoitens;
    }

    /**
     * Pesquisa um TipoItem que contenha a descrição passado por parãmetro.
     *
     * @param descricao String.
     * @return TipoItem tipoitens.
     */
    public TipoItem pesquisarDescricaoEq(String descricao) {
        TipoItem tipoitens = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            tipoitens = (TipoItem) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.eq("descricao", descricao)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return tipoitens;
    }

    /**
     * Pesquisa um TipoItem que contenha o codigo passada por parãmetro.
     *
     * @param codigo short.
     * @return TipoItem tipointens.
     */
    public TipoItem pesquisarCodigo(short codigo) {
        TipoItem tipoitens = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            tipoitens = (TipoItem) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.eq("idTipoItem", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return tipoitens;
    }
}
