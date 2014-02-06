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

     /**
     * Construtor da classe EditoraDAO.
     */
    public EditoraDAO() {
        super(Editora.class);
    }
    
     /**
     * Pesquisa Autores que contenham o nome passado por parâmetro.
     *
     * @param nome String.
     * @return List(Editora) editoras.
     */
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
    
     /**
     * Pesquisa NomeEditora que contenham o nome passado por parâmetro.
     *
     * @param nome String.
     * @return List(Editora) editoras.
     */
    
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
 
     /**
     * Pesquisa Acervos que contenham o ed passado por parâmetro.
     *
     * @param ed Editora.
     * @return List(Acervos) acervos.
     */
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
    
     /**
     * Pesquisa Editoras que contenham o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return Editora editora.
     */
    
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