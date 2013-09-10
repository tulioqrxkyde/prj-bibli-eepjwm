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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("tombo", new Integer(tombos))).addOrder(Order.asc("tombo")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("tituloObra", titulo, MatchMode.ANYWHERE)).addOrder(Order.asc("tituloObra")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("subtituloObra", subtitulo, MatchMode.ANYWHERE)).addOrder(Order.asc("subtituloObra")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("isbn", isbns, MatchMode.ANYWHERE)).addOrder(Order.asc("isbn")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("exemplar", new Integer(exemplares))).addOrder(Order.asc("exemplar")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("volume", volumes, MatchMode.ANYWHERE)).addOrder(Order.asc("volume")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("edicao", edicoes, MatchMode.ANYWHERE)).addOrder(Order.asc("edicao")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("anoEdicao", new Integer(anos))).addOrder(Order.asc("anoEdicao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Ano de Edição. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarInformacoesAdicionais(String informacoes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("informacoesAdicionais", informacoes, MatchMode.ANYWHERE)).addOrder(Order.asc("informacoesAdicionais")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("localizacao", localizacoes, MatchMode.ANYWHERE)).addOrder(Order.asc("localizacoes")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("tipoitem", tipoitem)).addOrder(Order.asc("idtipoitem")).addOrder(Order.asc("tipoitem")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("autor", autor)).addOrder(Order.asc("autor")).addOrder(Order.asc("idautor")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Autor. Erro: " + e.getMessage());
        }
        return acervo;
    }

    public List<Acervo> pesquisarEditora(Editora editora) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("editora", editora)).addOrder(Order.asc("editora")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("especificacoesTecnicas", escpecificacoestecnicas)).addOrder(Order.asc("especificacoesTecnicas")).list();
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
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("sessao", sessao)).addOrder(Order.asc("sessao")).list();
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
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("biblioteca", biblioteca)).addOrder(Order.asc("biblioteca")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Biblioteca. Erro: " + e.getMessage());
        }
        return acervo;
    }
}