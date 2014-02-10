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
    
     /**
     * Construtor da classe ExemplarDAO.
     */
    public ExemplarEmprestimosDAO(){
        super(ExemplarEmprestimos.class);
    }
    
     /**
     * Pesquisa Exemplares emprestados que contenham o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return Exemplar exemplarempr.
     */
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
    
     /**
     * Pesquisa pelo exe devolvido, e o retorna
     *
     * @return List querySQL.list()
     */
    
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
