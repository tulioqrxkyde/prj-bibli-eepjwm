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
 * @author Oziel
 */
public class GruposLeitoresDAO extends GenericDAO<GruposLeitores> {

    public GruposLeitoresDAO() {
        super(GruposLeitores.class);
    }

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
    }
    
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

    public GruposLeitores pesquisarCodigo(int codigo) {
        GruposLeitores gruposleitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            gruposleitores = (GruposLeitores) getSessao().createCriteria(GruposLeitores.class).
                    add(Restrictions.ilike("descricao", String.valueOf(codigo), MatchMode.ANYWHERE)).
                    addOrder(Order.asc("descricao")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return gruposleitores;
    }
}