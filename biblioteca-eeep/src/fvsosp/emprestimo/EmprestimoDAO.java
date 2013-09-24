package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import fvsosp.util.*;
import java.util.*;
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

    public List<Emprestimo> pesquisardataEmprestimo(Date data) {
        List<Emprestimo> emprestimo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            emprestimo = (List<Emprestimo>) getSessao().createCriteria(Emprestimo.class).add(Restrictions.ilike("dataEmprestimo", data)).addOrder(Order.asc("dataEmprestimo")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Data de Emprestimo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return emprestimo;
    }

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
}