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
package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.exemplar.Exemplar;
import fvsosp.exemplaremprestimos.ExemplarEmprestimos;
import fvsosp.leitor.Leitor;
import fvsosp.util.*;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.*;

/**
 *
 * @author oziel.ico
 */
public class EmprestimoDAO extends GenericDAO<Emprestimo> {

    /**
     * Construtor da classe EmprestimoDAO.
     */
    public EmprestimoDAO() {
        super(Emprestimo.class);
    }

    /**
     * Pesquisa um Emprestimo que contenha o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return Emprestimo emprestimo.
     */
    public Emprestimo pesquisarCodigo(short codigo) {
        Emprestimo emprestimo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            emprestimo = (Emprestimo) getSessao().createCriteria(Emprestimo.class).
                    add(Restrictions.eq("idEmprestimo", codigo)).
                    addOrder(Order.asc("idEmprestimo")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar pelo Código do Empréstimo: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return emprestimo;
    }

    /**
     * Pesquisa Emprestimos que contenham a data de emprestimo passada por
     * parâmetro.
     *
     * @param emprestimo Date.
     * @return List(Emprestimo) emprestimo.
     */
    public List<Emprestimo> pesquisardataEmprestimo(Date data) {
        List<Emprestimo> emprestimo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            emprestimo = (List<Emprestimo>) getSessao().createCriteria(Emprestimo.class).add(Restrictions.eq("dataEmprestimo", data)).addOrder(Order.asc("dataEmprestimo")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Data de Emprestimo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return emprestimo;
    }

    /**
     * Pesquisa Emprestimos que contenham a data de devolução passada por
     * parâmetro.
     *
     * @param data Date.
     * @return Emprestimo emprestimo.
     */
    public Emprestimo pesquisardataDevolucao(Date data) {
        Emprestimo emprestimo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            emprestimo = (Emprestimo) getSessao().createCriteria(Emprestimo.class).add(Restrictions.ilike("dataDevolucao", data)).addOrder(Order.asc("dataDevolucao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Data de Devolução. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return emprestimo;
    }

    /**
     * Pesquisa por Acervos que contenham o emprestimo passado por parâmetro.
     *
     * @param emprestimo Emprestimo.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarEmprestimo(Emprestimo emprestimo) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Emprestimo.class).add(Restrictions.eq("acervos", emprestimo)).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Acervo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa o Leitor que contenha o emprestimo passado por parâmetro.
     *
     * @param emprestimo Emprestimo.
     * @return Leitor leitor.
     */
    public Leitor pesquisarLeitorEmprestimo(Emprestimo emprestimo) {
        Leitor leitor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            leitor = (Leitor) getSessao().createCriteria(Emprestimo.class).add(Restrictions.eq("idLeitor", emprestimo)).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Leitor. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitor;
    }

    /**
     * Pesquisa pelo leitor passado por parâmetro, e retorna sua situação.
     *
     * @return int querySQL.list().size()
     */
    public int pesquisarSituacao(Leitor leitor) {
        String text = "select distinct(exe.tombo) from exemplaremprestimos ee  "
                + "inner join  emprestimo e on e.idEmprestimo=ee.idEmprestimo "
                + "inner join exemplar exe on exe.tombo=ee.idExemplar "
                + "where e.idLeitor=" + leitor.getIdLeitor() + " and exe.situacao=3 and ee.datadevolucao is null";
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery query = getSessao()
                    .createSQLQuery(text);
            return query.list().size();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Leitor. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return 0;

    }

    /**
     * Pesquisa por todos os exemplares emprestados, e os retorna.
     *
     * @param leitor Leitor
     * @return List(ExemplarEmprestimos) querySQL.list()
     */
    public List<ExemplarEmprestimos> pesquisarExemplaresEmprestados(Leitor leitor) {
        String text = "select * from exemplaremprestimos ee  "
                + "inner join  emprestimo e on e.idEmprestimo=ee.idEmprestimo "
                + "inner join exemplar exe on exe.tombo=ee.idExemplar and exe.situacao=3 "
                + "where e.idLeitor=" + leitor.getIdLeitor() + " and ee.datadevolucao is null";
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery query = getSessao()
                    .createSQLQuery(text).addEntity(ExemplarEmprestimos.class);
            return query.list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Leitor. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return null;
    }

    /**
     * Pesquisa por todos os emprestimos, e retorna seu código
     *
     * @return short querySQL.list().get(0)
     */
    public short pesquisarEmprestimoLivroDevolvido(Exemplar exe) {
        String text = "select e.idEmprestimo from exemplaremprestimos ee "
                + "inner join  emprestimo e on e.idEmprestimo=ee.idEmprestimo  "
                + "where ee.idExemplarEmprestimos=( "
                + "select max(idExemplarEmprestimos) from exemplaremprestimos ee "
                + "where ee.idExemplar=" + exe.getTombo() + " and ee.operacao in (1,3))";
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
            System.out.println("Erro ao localizar o Leitor. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return 0;
    }
}