/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.tipoitem;

import fvsosp.idioma.Idioma;
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

    public TipoItemDAO() {
        super(TipoItem.class);
    }

    public List<TipoItem> procuraDescricao(String descricao) {
        List<TipoItem> tipoitens = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            /*
             * pesquisa um tipo de item por descricao
             * usando o ilike, o MatchMode.ANYWHERE quer dizer
             * que a sequência de caracteres passada na String descricao 
             * pode ser encontrada em qualquer lugar, representa o '%descricao%', ordenando
             * de forma crescente por descicao
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
