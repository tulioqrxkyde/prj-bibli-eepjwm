/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;

import fvsosp.autor.Autor;
import fvsosp.biblioteca.Biblioteca;
import fvsosp.editora.Editora;
import fvsosp.especificacoes.EspecificacoesTecnicas;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

/**
 *
 * @author Oziel
 */
public class AcervoDAO extends GenericDAO<Acervo> {

    public AcervoDAO() {
        super(Acervo.class);
    }

    public List<Acervo> pesquisarTombo(int tombos) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("tombo", String.valueOf(tombos))).addOrder(Order.asc("tombo")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Tombo. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarTitulodaObra(String titulo) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("tituloObra", "titulo", MatchMode.ANYWHERE)).addOrder(Order.asc("tituloObra")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Título. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarSubTitulodaObra(String subtitulo) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("subtituloObra", "subtitulo", MatchMode.ANYWHERE)).addOrder(Order.asc("subtituloObra")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Sub-Título. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarIsbn(String isbns) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("isbn", "isbns", MatchMode.ANYWHERE)).addOrder(Order.asc("isbn")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o isbn. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarExemplar(int exemplares) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("exemplar", String.valueOf(exemplares))).addOrder(Order.asc("exemplar")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Exemplar. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarVolume(String volumes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("volume", "volumes", MatchMode.ANYWHERE)).addOrder(Order.asc("volume")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Volume. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarEdicao(String edicoes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("edicao", "edicoes", MatchMode.ANYWHERE)).addOrder(Order.asc("edicao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Edição. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisaranoEdicao(int anos) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("anoEdicao", String.valueOf(anos))).addOrder(Order.asc("anoEdicao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Ano de Edição. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarinformacoesAdicionais(String informacoes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("informacoesAdicionais", "informacoes", MatchMode.ANYWHERE)).addOrder(Order.asc("informacoesAdicionais")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar as Informações Adicionais. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarLocalizacao(String localizacoes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("localizacao", "localizacoes", MatchMode.ANYWHERE)).addOrder(Order.asc("localizacoes")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Localização. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarTipoItem(TipoItem tipoitem) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("idtipoitem", tipoitem)).addOrder(Order.asc("idtipoitem")).addOrder(Order.asc("idtipoitem")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Tipo do Item. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarAutor(Autor autor) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("idautor", autor)).addOrder(Order.asc("idautor")).addOrder(Order.asc("idautor")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Autor. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Acervo pesquisarEditora(Editora editora) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("ideditora", editora)).addOrder(Order.asc("ideditora")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Editora. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarEspecificacoesTecnicas(EspecificacoesTecnicas escpecificacoestecnicas) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.like("idaespecificacoestecnicas", escpecificacoestecnicas)).addOrder(Order.asc("idespecificacoestecnicas")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar as Especificacões Técnicas. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarSessao(Sessao sessao) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("idsessao", sessao)).addOrder(Order.asc("idsessao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Sessão. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public Acervo pesquisarBiblioteca(Biblioteca biblioteca) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("idbiblioteca", biblioteca)).addOrder(Order.asc("idbiblioteca")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Biblioteca. Erro: " + e.getMessage());
        }
        return acervo;
    }
}