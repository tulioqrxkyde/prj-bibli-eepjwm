/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.multa;

import fvsosp.exemplar.Exemplar;
import fvsosp.leitor.Leitor;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class MultaDAO extends GenericDAO<Multa> {

    public MultaDAO() {
        super(MultaDAO.class);
    }

    public boolean pesquisarSeTemEmAbertoMulta(Leitor leitor) {
        boolean retorno = false;
        /*
         * sql que verifica se já existe multa gerada
         */
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
            //System.out.println(query.list());

            Object o = query.list().get(0);

            if (o == null) {
                retorno = false;
            } else {
                retorno = true;
            }
            /*
             * sql que verifica se existe multa que ainda não foi gerada na tabela multas
             */
            Date now = new Date();
            DateFormat df = DateFormat.getDateInstance();
            String dataAtual = df.format(now);

            text = "select * from exemplaremprestimos ee "
                    + "inner join emprestimo em on em.idemprestimo=ee.idemprestimo "
                    + "inner join leitor l on l.idleitor=em.idleitor "
                    + "where ee.dataprevistadevolucao<'" + dataAtual
                    + "' and l.idleitor=" + leitor.getIdLeitor()
                    + " and datadevolucao is null";
            SQLQuery query2 = getSessao()
                    .createSQLQuery(text);

            try {
                Object o2 = query2.list().get(0);

                if (o2 == null) {
                    retorno = false;
                } else {
                    retorno = true;
                }
            } catch (Exception e) {
                retorno = false;
            }



        } catch (HibernateException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return retorno;
    }

    public List<Multa> pesquisarMultas(Leitor leitor) {
        List<Multa> multas = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            String sql = "select * from multa m "
                    + "inner join exemplaremprestimos exeem on exeem.idexemplaremprestimos=m.exemplaremprestimo "
                    + "inner join emprestimo e on e.idemprestimo=exeem.idemprestimo "
                    + "where e.idleitor=" + leitor.getIdLeitor() + " and m.pago=false order by exeem.datadevolucao";

            SQLQuery query = getSessao()
                    .createSQLQuery(sql).addEntity(Multa.class);
            multas = query.list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return multas;
    }

    public Multa pesquisarCodigo(int codigo) {
        Multa multa = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            multa = (Multa) getSessao().createCriteria(Multa.class).
                    add(Restrictions.eq("idMulta", codigo)).addOrder(Order.asc("idMulta")).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a multa. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return multa;
    }
}
