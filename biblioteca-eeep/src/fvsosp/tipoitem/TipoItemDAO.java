/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

    public TipoItemDAO() {
        super(TipoItem.class);
    }

    public List<TipoItem> procuraDescricao(String descricao) {
        List<TipoItem> tipoItens = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            /*
             * pesquisa um tipo de item por descricao
             * usando o like, o MatchMode.ANYWHERE quer dizer
             * que a sequência de caracteres passada na String descricao 
             * pode ser encontrada em qualquer lugar, representa o '%descricao%', ordenando
             * de forma crescente por descicao
             */
            tipoItens = (List<TipoItem>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: "+e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return tipoItens;
    }
}
