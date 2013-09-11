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

    public Emprestimo pesquisaridEmprestimo(int id) {
        Emprestimo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Emprestimo) getSessao().createCriteria(Emprestimo.class).add(Restrictions.ilike("idEmprestimo", String.valueOf(id), MatchMode.ANYWHERE)).addOrder(Order.asc("idEmprestimo")).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o id do Emprestimo. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Emprestimo> pesquisardataEmprestimo(Date data) {
        List<Emprestimo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Emprestimo>) getSessao().createCriteria(Emprestimo.class).add(Restrictions.ilike("dataEmprestimo", data)).addOrder(Order.asc("dataEmprestimo")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Data de Emprestimo. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Emprestimo pesquisardataDevolucao(Date data) {
        Emprestimo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Emprestimo) getSessao().createCriteria(Emprestimo.class).add(Restrictions.ilike("dataDevolucao", data)).addOrder(Order.asc("dataDevolucao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Data de Devolução. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Acervo pesquisarEmprestimo(Emprestimo emprestimo) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Emprestimo.class).add(Restrictions.eq("AcervoEmprestimos", emprestimo)).uniqueResult();
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
            leitor = (Leitor) getSessao().createCriteria(Emprestimo.class).add(Restrictions.eq("idLeitor", emprestimo)).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Leitor. Erro: " + e.getMessage());
        }
        return leitor;
    }
}