/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.leitor;

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
public class LeitorDAO extends GenericDAO<Leitor> {

    public LeitorDAO() {
        super(Leitor.class);
    }

    public List<Leitor> pesquisarNome(String nome) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        }
        return leitores;
    }

    public List<Leitor> pesquisarEmail(String email) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("email", email, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("email")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por email: " + e.getMessage());
        }
        return leitores;

    }
    
    public List<Leitor> pesquisarDataNascimento(String dataNascimento) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            leitores= (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("dataNascimento", dataNascimento, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("dataNascimento")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Data de Nascimento: "+e.getMessage());
        }
        return leitores;
}
     public List<Leitor> pesquisarTelefone(String telefone) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            leitores= (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("telefone", telefone, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("telefone")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por telefone: "+e.getMessage());
        }
        return leitores;
   
}
          public List<Leitor> pesquisarCelular(String celular) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            leitores= (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("celular", celular, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("celular")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por celular: "+e.getMessage());
        }
        return leitores;
   
}
     
           public List<Leitor> pesquisarMatricula(String matricula) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            leitores= (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("matricula", matricula, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("matricula")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por matricula: "+e.getMessage());
        }
        return leitores;
   
}
           
            public List<Leitor> pesquisarAtivo(String ativo) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            leitores= (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("ativo", ativo, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("ativo")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por ativo: "+e.getMessage());
        }
        return leitores;
   
}
          public List<Leitor> pesquisarGrupoLeitores(String gruposLeitores) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            leitores= (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("gruposLeitores", gruposLeitores, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("gruposLeitores")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por grupos de Leitores: "+e.getMessage());
        }
        return leitores;
   
}    
           public List<Leitor> pesquisarCidades(String cidades) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            
            leitores= (List<Leitor>) getSessao().createCriteria(TipoItem.class).
                    add(Restrictions.like("cidades", cidades, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("cidades")).list();
                
        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por cidades: "+e.getMessage());
        }
        return leitores;
   
}    
}

