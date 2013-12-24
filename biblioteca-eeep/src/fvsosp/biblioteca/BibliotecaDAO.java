/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.biblioteca;

import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Oziel
 */
public class BibliotecaDAO extends GenericDAO<Biblioteca> {

    public BibliotecaDAO() {
        super(Biblioteca.class);
    }
    
    public List<Biblioteca> pesquisarDescricao(String descricao) {
        List<Biblioteca> bibliotecas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            /*
             * pesquisa uma biblioteca por descricao
             * usando o like, o MatchMode.ANYWHERE quer dizer
             * que a sequência de caracteres passada na String descricao
             * pode ser encontrada em qualquer lugar, representa o '%descricao%', ordenando
             * de forma crescente por descicao
             */
            bibliotecas = (List<Biblioteca>) getSessao().createCriteria(Biblioteca.class).
                    add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE)).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Descrição: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return bibliotecas;
    }

    public Biblioteca pesquisarCodigo(short codigo) {
        Biblioteca biblioteca = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            biblioteca = (Biblioteca) getSessao().createCriteria(Biblioteca.class).
                    add(Restrictions.eq("idBiblioteca", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return biblioteca;
    }
}