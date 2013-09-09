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
public abstract class GeneicDAO<T> {

    private Session sessao;
    private Transaction transacao;
    private Class classe;

    public GeneicDAO(Class classe) {
        this.classe = classe;
    }

    public void salvar(T entity) {
        try {
            this.sessao = HibernateUtil.getSessionFactory().openSession();
            this.transacao = sessao.beginTransaction();
            this.sessao.save(entity);
            this.transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir " + entity.getClass()
                    + ". Erro: " + e.getMessage());
        } finally {
            sessao.close();

        }
    }

    public void atualizar(T entity) {
        try {
            this.sessao = HibernateUtil.getSessionFactory().openSession();
            this.transacao = sessao.beginTransaction();
            this.sessao.update(entity);
            this.transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível atualizar " + entity.getClass()
                    + ". Erro: " + e.getMessage());
        } finally {
            sessao.close();

        }
    }

    public void remover(T entity) {
        try {
            this.sessao = HibernateUtil.getSessionFactory().openSession();
            this.transacao = sessao.beginTransaction();
            this.sessao.delete(entity);
            this.transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível atualizar " + entity.getClass()
                    + ". Erro: " + e.getMessage());
        } finally {
            sessao.close();

        }
    }

    public List<T> listar() {
        this.sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        return this.sessao.createCriteria(classe).list();
    }
}
