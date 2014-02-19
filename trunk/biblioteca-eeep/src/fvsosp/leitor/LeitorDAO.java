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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.leitor;

import fvsosp.cidade.Cidade;
import fvsosp.grupoleitores.GruposLeitores;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Francisco junior
 */
public class LeitorDAO extends GenericDAO<Leitor> {

    /**
     * Construtor da classe LeitorDAO.
     */
    
    public LeitorDAO() {
        super(Leitor.class);
    }

     /**
     * Pesquisa Leitores que contenham o nome passado por parâmetro.
     *
     * @param nome String.
     * @return List(Leitor) Leitores.
     */
    
    public List<Leitor> pesquisarNome(String nome) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;
    }
    
     /**
     * Pesquisa Leitoress que contenham o nomeEq passado por parâmetro.
     *
     * @param nome String.
     * @return  Leitor leitores.
     */
    public Leitor pesquisarNomeEq(String nome) {
        Leitor leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (Leitor) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("nome", nome)).
                    addOrder(Order.asc("nome")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por nome: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;
    }

     /**
     * Pesquisa um Leitor que contenha o email passado por parâmetro.
     *
     * @param Email String.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarEmail(String email) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.ilike("email", email, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("email")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por email: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    /**
     * Pesquisa um Leitor que contenha o dataNascimento passado por parâmetro.
     *
     * @param dataNascimento Date.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarDataNascimento(Date dataNascimento) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.ilike("dataNascimento", String.valueOf(dataNascimento), MatchMode.ANYWHERE)).
                    addOrder(Order.asc("dataNascimento")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por Data de Nascimento: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;
    }

    /**
     * Pesquisa um Leitor que contenha o telefone passado por parâmetro.
     *
     * @param telefone String.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarTelefone(String telefone) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.ilike("telefone", telefone, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por telefone: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

     /**
     * Pesquisa um Leitor que contenha o celular passado por parâmetro.
     *
     * @param celular String.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarCelular(String celular) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.ilike("celular", celular, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por celular: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    /**
     * Pesquisa um Leitor que contenha a matricula passado por parâmetro.
     *
     * @param matricula String.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarMatricula(String matricula) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.ilike("matricula", matricula, MatchMode.ANYWHERE)).
                    addOrder(Order.asc("matricula")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por matricula: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }
    
     /**
     * Pesquisa um Leitor que contenha a MatriculaEq passado por parâmetro.
     *
     * @param matricula String.
     * @return Leitor leitores.
     */
    public Leitor pesquisarMatriculaEq(String matricula) {
        Leitor leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (Leitor) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("matricula", matricula)).
                    addOrder(Order.asc("matricula")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por matricula: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    /**
     * Pesquisa um Leitor que contenha  ativo passado por parâmetro.
     *
     * @param ativo boolean.
     * @return List(Leitor) leitores.
     */

    public List<Leitor> pesquisarAtivo(boolean ativo) {
        List<Leitor> leitores = null;

        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("ativo", ativo)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por ativo: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    /**
     * Pesquisa um Leitor que contenha no gruposLeitores passado por parâmetro.
     *
     * @param gruposLeitores GruposLeitores.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarGrupoLeitores(GruposLeitores gruposLeitores) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("gruposLeitores", gruposLeitores)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por grupos de Leitores: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }

    /**
     * Pesquisa um Leitor que contenha cidades passado por parâmetro.
     *
     * @param cidades Cidade.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarCidade(Cidade cidades) {
        List<Leitor> leitores = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitores = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("cidade", cidades)).
                    addOrder(Order.asc("nome")).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por cidades: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitores;

    }
    
    /**
     * Pesquisa um Leitor que contenha o id passado por parâmetro.
     *
     * @param id short.
     * @return Leitor leitores.
     */
    public Leitor pesquisarCodigo(short id) {
        Leitor leitor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitor = (Leitor) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("idLeitor", id)).
                    addOrder(Order.asc("nome")).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por leitor: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitor;

    }
    
     /**
     * Pesquisa um Leitor que contenha cpf passado por parâmetro.
     *
     * @param cpf String.
     * @return List(Leitor) leitores.
     */
    public List<Leitor> pesquisarCpf(String cpf) {
        List<Leitor> leitor = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            leitor = (List<Leitor>) getSessao().createCriteria(Leitor.class).
                    add(Restrictions.eq("cpf", cpf)).list();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por leitor: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return leitor;

    }
}
