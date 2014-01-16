/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.leitor;

import fvsosp.cidade.Cidade;
import fvsosp.grupoleitores.GruposLeitores;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Oziel
 */
public class LeitorDAO extends GenericDAO<Leitor> {

    public LeitorDAO() {
        super(Leitor.class);
    }

    public List<Leitor> pesquisarNome(String nome) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;
    }
    
    public Leitor pesquisarNomeEq(String nome) {
        Leitor leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (Leitor) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("nome", nome)).
                    addOrder(Order.asc("nome")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;
    }

    public List<Leitor> pesquisarEmail(String email) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.like("email", email, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("email")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por email: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    public List<Leitor> pesquisarDataNascimento(Date dataNascimento) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.like("dataNascimento", String.valueOf(dataNascimento), MatchMode.ANYWHERE)).
                    addOrder(Order.asc("dataNascimento")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Data de Nascimento: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;
    }

    public List<Leitor> pesquisarTelefone(String telefone) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.like("telefone", telefone, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por telefone: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    public List<Leitor> pesquisarCelular(String celular) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.like("celular", celular, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por celular: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    public List<Leitor> pesquisarMatricula(String matricula) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.like("matricula", matricula, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("matricula")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por matricula: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }
    
    public Leitor pesquisarMatriculaEq(String matricula) {
        Leitor leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (Leitor) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("matricula", matricula)).
                    addOrder(Order.asc("matricula")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por matricula: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }


    public List<Leitor> pesquisarAtivo(boolean ativo) {
        List<Leitor> leitores = null;

        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("ativo", ativo)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por ativo: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    public List<Leitor> pesquisarGrupoLeitores(GruposLeitores gruposLeitores) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("gruposLeitores", gruposLeitores)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por grupos de Leitores: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    public List<Leitor> pesquisarCidade(Cidade cidades) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("cidade", cidades)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por cidades: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }
    
    public Leitor pesquisarCodigo(short id) {
        Leitor leitor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitor = (Leitor) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("idLeitor", id)).
                    addOrder(Order.asc("nome")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por leitor: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitor;

    }
    
    public List<Leitor> pesquisarCpf(String cpf) {
        List<Leitor> leitor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitor = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("cpf", cpf)).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por leitor: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitor;

    }
}
