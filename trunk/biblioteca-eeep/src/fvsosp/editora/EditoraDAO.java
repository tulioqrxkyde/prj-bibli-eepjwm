/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.editora;

import fvsosp.tipoitem.TipoItem;
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
public class EditoraDAO extends GenericDAO<Editora> {

    public EditoraDAO() {
        super(Editora.class);
    }

    public List<Editora> procuraDescricao(String descricao) {
        List<Editora> editoras = null;

        try {

            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            editoras = (List<Editora>) getSessao().createCriteria(Editora.class).
                    add(Restrictions.like("descricao", descricao, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        }
        return editoras;
    }
}