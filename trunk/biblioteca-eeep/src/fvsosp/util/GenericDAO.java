/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.util;

import fvsosp.usuario.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pedro Saraiva
 */
@SuppressWarnings("unchecked")
public abstract class GenericDAO<T> {

    private Session sessao;
    private Transaction transacao;
    private Class classe;

    public GenericDAO(Class classe) {
        this.classe = classe;
    }

    public void salvar(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().save(entity);
            this.getTransacao().commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir " + entity.getClass()
                    + ". Erro: " + e.getMessage());
        } finally {
            getSessao().close();

        }
    }

    public void atualizar(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().update(entity);
            this.getTransacao().commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível atualizar " + entity.getClass()
                    + ". Erro: " + e.getMessage());
        } finally {
            getSessao().close();

        }
    }

    public void remover(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().delete(entity);
            this.getTransacao().commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível remover " + entity.getClass()
                    + ". Erro: " + e.getMessage());
        } finally {
            getSessao().close();

        }
    }

    public List<T> listar() {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe).list();
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            System.out.println("Erro ao listar. Erro " + e.getMessage());
        }
        return lista;
    }

    /**
     * @return the sessao
     */
    public Session getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    /**
     * @return the transacao
     */
    public Transaction getTransacao() {
        return transacao;
    }

    /**
     * @param transacao the transacao to set
     */
    public void setTransacao(Transaction transacao) {
        this.transacao = transacao;
    }
}
