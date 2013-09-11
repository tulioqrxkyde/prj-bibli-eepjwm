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

    public Editora procuraIdEditora(int id) {
        Editora editoras = null;

        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            editoras = (Editora) getSessao().createCriteria(Editora.class).
                    add(Restrictions.ilike("idEditora", String.valueOf(id), MatchMode.ANYWHERE)).
                    addOrder(Order.asc("idEditora")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Id da Editora: " + e.getMessage());
        }
        return editoras;
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
        }
        return acervos;
    }
}