/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.multa;

import fvsosp.exemplar.Exemplar;
import fvsosp.leitor.Leitor;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;

/**
 *
 * @author Pedro Saraiva
 */
public class MultaDAO extends GenericDAO<Multa> {

    public MultaDAO() {
        super(MultaDAO.class);
    }

    public boolean pesquisarSeTemEmAbertoMulta(Leitor leitor) {
        String text = "select sum(valor) from multa m "
                + "join exemplaremprestimos exeem on exeem.idexemplaremprestimos=m.exemplaremprestimo "
                + "join emprestimo e on e.idemprestimo=exeem.idemprestimo "
                + "join leitor l on l.idleitor=e.idleitor "
                + "where m.pago=false and l.idleitor=" + String.valueOf(leitor.getIdLeitor());
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery query = getSessao()
                    .createSQLQuery(text);
            System.out.println(query.list());

            Object o = query.list().get(0);

            if (o == null) {
                return false;
            } else {
                return true;
            }
        } catch (HibernateException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return false;
    }
}
