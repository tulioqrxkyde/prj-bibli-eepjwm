package fvsosp.editora;

import fvsosp.acervo.Acervo;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.*;

/**
 *
 * @author Oziel
 */
public class EditoraDAO extends GenericDAO<Editora> {

    public EditoraDAO() {
        super(Editora.class);
    }

    public List<Editora> procuraNomeEditora(String nome) {
        List<Editora> editoras = null;

        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            editoras = (List<Editora>) getSessao().createCriteria(Editora.class).
                    add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Nome da Editora: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return editoras;
    }
    
    public Editora procuraNomeEditoraEq(String nome) {
        Editora editoras = null;

        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            editoras = (Editora) getSessao().createCriteria(Editora.class).
                    add(Restrictions.eq("nome", nome)).
                    addOrder(Order.asc("nome")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Nome da Editora: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return editoras;
    }
 
    public List<Acervo> procuraAcervoEditora(Editora ed) {
        List<Acervo> acervos = null;

        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            acervos = (List<Acervo>) getSessao().createCriteria(Editora.class).
                    add(Restrictions.eq("acervo", ed)).
                    addOrder(Order.asc("acervo")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Acervo: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervos;
    }
    
    public Editora pesquisarCodigo(short codigo) {
        Editora editora = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            editora = (Editora) getSessao().createCriteria(Editora.class).
                    add(Restrictions.eq("idEditora", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return editora;
    }
}