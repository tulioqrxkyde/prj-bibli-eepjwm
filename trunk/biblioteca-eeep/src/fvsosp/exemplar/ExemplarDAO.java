/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package fvsosp.exemplar;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class ExemplarDAO extends GenericDAO<Exemplar> {
    
     /**
     * Construtor da classe ExemplarDAO.
     */
    public ExemplarDAO() {
        super(Exemplar.class);
    }
    
     /**
     * Pesquisa Exemplares que contenham o tombo passado por parâmetro.
     *
     * @param tombo short.
     * @return Exemplar exemplar.
     */
    public Exemplar pesquisarTombo(short tombo) {
        Exemplar exemplar = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            exemplar = (Exemplar) getSessao().createCriteria(Exemplar.class).
                    add(Restrictions.eq("tombo", tombo)).addOrder(Order.asc("exemplar")).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Tombo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return exemplar;
    }
    
     /**
     * Pesquisa Exemplares que contenham o acervo passado por parâmetro.
     *
     * @param acervo Acervo.
     * @return List(Exemplar) exemplar.
     */
    public List<Exemplar> pesquisarAcervo(Acervo acervo) {
        List<Exemplar> exemplar = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            exemplar = (List<Exemplar>) getSessao().createCriteria(Acervo.class).
                    add(Restrictions.eq("acervo", acervo)).addOrder(Order.asc("exemplar")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Acervo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return exemplar;
    }
    
    
}
