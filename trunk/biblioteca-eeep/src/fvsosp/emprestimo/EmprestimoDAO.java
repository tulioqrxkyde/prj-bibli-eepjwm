/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.criterion.*;

/**
 *
 * @author Oziel
 */
public class EmprestimoDAO extends GenericDAO<Emprestimo> {

    public EmprestimoDAO() {
        super(Emprestimo.class);
    }

    public Acervo pesquisaridEmprestimo(int id) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("idEmprestimo", String.valueOf(id), MatchMode.ANYWHERE)).addOrder(Order.asc("idEmprestimo")).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o isbn. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Acervo pesquisardataEmprestimo(Date data) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("dataEmprestimo", data)).addOrder(Order.asc("dataEmprestimo")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o isbn. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Acervo pesquisardataDevolucao(Date data) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("dataDevolucao", data)).addOrder(Order.asc("dataDevolucao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o isbn. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Acervo pesquisarAcervoEmprestimo(Emprestimo emprestimo) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("AcervoEmprestimos", emprestimo)).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Acervo. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Leitor pesquisarLeitorEmprestimo(Emprestimo emprestimo) {
        Leitor leitor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            leitor = (Leitor) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("idLeitor", emprestimo)).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Leitor. Erro: " + e.getMessage());
        }
        return leitor;
    }
}