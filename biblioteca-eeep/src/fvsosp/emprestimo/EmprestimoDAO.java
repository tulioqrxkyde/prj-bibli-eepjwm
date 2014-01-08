package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.exemplar.Exemplar;
import fvsosp.leitor.Leitor;
import fvsosp.util.*;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.*;

/**
 *
 * @author Oziel
 */
public class EmprestimoDAO extends GenericDAO<Emprestimo> {

    public EmprestimoDAO() {
        super(Emprestimo.class);
    }

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

    public int pesquisarSituacao(Leitor leitor) {
        String text = "select distinct(exe.tombo) from exemplaremprestimos ee  "
                + "inner join  emprestimo e on e.idEmprestimo=ee.idEmprestimo "
                + "inner join exemplar exe on exe.tombo=ee.idExemplar "
                + "where e.idLeitor=" + leitor.getIdLeitor() + " and exe.situacao=3";
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

    public short pesquisarEmprestimoLivroDevolvido(Exemplar exe) {
        String text = "select e.idEmprestimo from exemplaremprestimos ee "
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
            System.out.println("Erro ao localizar o Leitor. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return 0;

    }
    
    
    
}