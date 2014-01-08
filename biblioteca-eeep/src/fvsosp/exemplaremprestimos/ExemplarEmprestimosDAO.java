/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.exemplaremprestimos;

import fvsosp.exemplar.Exemplar;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class ExemplarEmprestimosDAO extends GenericDAO<ExemplarEmprestimos> {
    
    public ExemplarEmprestimosDAO(){
        super(ExemplarEmprestimos.class);
    }
    
    public ExemplarEmprestimos pesquisarCodigo(short codigo) {
        ExemplarEmprestimos exemplarempr = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            exemplarempr = (ExemplarEmprestimos) getSessao().createCriteria(ExemplarEmprestimos.class).
                    add(Restrictions.eq("idExemplarEmprestimos", codigo)).
                    addOrder(Order.asc("idExemplarEmprestimos")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar pelo Código do ExemplarEmprestimo: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return exemplarempr;
    }
    
    public short pesquisarIdExemplarEmprestimoDevolvido(Exemplar exe) {
        String text = "select ee.idExemplarEmprestimos from exemplaremprestimos ee "
                + "inner join  emprestimo e on e.idEmprestimo=ee.idEmprestimo  "
                + "where ee.idExemplarEmprestimos=( "
                + "select max(idExemplarEmprestimos) from exemplaremprestimos ee "
                + "where ee.idExemplar="+exe.getTombo()+" and ee.operacao in (1,3))";
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery query = getSessao()
                    .createSQLQuery(text);
            System.out.println(query.list());
            
            Object o = query.list().get(0);
            
            //Integer codigo = (Integer) list.get(0);
            return (short) o;
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o ExemplarEmprestimo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return 0;

    }
}
