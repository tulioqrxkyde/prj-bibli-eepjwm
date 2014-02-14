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
package fvsosp.acervo;

import fvsosp.autor.Autor;
import fvsosp.biblioteca.Biblioteca;
import fvsosp.editora.Editora;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import fvsosp.util.GenericDAO;
import fvsosp.util.HibernateUtil;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

/**
 *
 * @author oziel.ico
 */
public class AcervoDAO extends GenericDAO<Acervo> {

    /**
     * Construtor da classe AcervoDAO.
     */
    public AcervoDAO() {
        super(Acervo.class);
    }

    /**
     * Pesquisa um Acervo que contenham o título da obra passado por parâmetro.
     *
     * @param titulo String.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarTitulodaObra(String titulo) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("tituloObra", titulo, MatchMode.ANYWHERE)).addOrder(Order.asc("tituloObra")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Título. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa um Acervo que contenham o título da obra passado por parâmetro.
     *
     * @param titulo String.
     * @return Acervo acervo.
     */
    public Acervo pesquisarTitulodaObraEq(String titulo) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("tituloObra", titulo)).addOrder(Order.asc("tituloObra")).uniqueResult();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Título. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham o subtitulo da obra passado por parâmetro.
     *
     * @param subtitulo String.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarSubTitulodaObra(String subtitulo) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("subtituloObra", subtitulo, MatchMode.ANYWHERE)).addOrder(Order.asc("subtituloObra")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Sub-Título. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham o isbn passado por parâmetro.
     *
     * @param isbn String.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarIsbn(String isbns) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("isbn", isbns, MatchMode.ANYWHERE)).addOrder(Order.asc("isbn")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o isbn. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham o volume passado por parâmetro.
     *
     * @param volumes String.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarVolume(String volumes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("volume", volumes, MatchMode.ANYWHERE)).addOrder(Order.asc("volume")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Volume. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham as edições passadas por parâmetro.
     *
     * @param edicoes String.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarEdicao(String edicoes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("edicao", edicoes, MatchMode.ANYWHERE)).addOrder(Order.asc("edicao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Edição. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham o ano, passado por parâmetro.
     *
     * @param ano short.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisaranoEdicao(short ano) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("anoEdicao", ano)).addOrder(Order.asc("anoEdicao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Ano de Edição. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham a informação adicional passada por
     * parâmetro.
     *
     * @param informacoes String.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarInformacoesAdicionais(String informacoes) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("informacoesAdicionais", informacoes, MatchMode.ANYWHERE)).addOrder(Order.asc("informacoesAdicionais")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar as Informações Adicionais. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham a localização passada por parâmetro.
     *
     * @param localizacao String.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarLocalizacao(String localizacao) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.ilike("localizacao", localizacao, MatchMode.ANYWHERE)).addOrder(Order.asc("localizacao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Localização. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham o Tipo de Item passado por parâmetro.
     *
     * @param tipoitem TipoItem.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarTipoItem(TipoItem tipoitem) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("tipoitem", tipoitem)).addOrder(Order.asc("idtipoitem")).addOrder(Order.asc("tipoitem")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Tipo do Item. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham o Autor passado por parâmetro.
     *
     * @param autor Autor.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarAutor(Autor autor) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("autor", autor)).addOrder(Order.asc("autor")).addOrder(Order.asc("idautor")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Autor. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos localizáveis pela query(Autor) passada por parâmetro.
     *
     * @param informacoes String.
     * @return List querySQL.list().
     */
    public List pesquisarAutorQuery(String query) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery querySQL = getSessao().createSQLQuery(query);
            return querySQL.list();
        } catch (HibernateException e) {
            System.out.println("Erro ao consultar por Autor. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return null;
    }

    /**
     * Pesquisa Acervos que contenham a Editora passada por parâmetro.
     *
     * @param editora Editora.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarEditora(Editora editora) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("editora", editora)).addOrder(Order.asc("editora")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Editora. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham a Sessao passada por parâmetro.
     *
     * @param sessao Sessao.
     * @return List(Acervo) acervo.
     */
    public List<Acervo> pesquisarSessao(Sessao sessao) {
        List<Acervo> acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (List<Acervo>) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("sessao", sessao)).addOrder(Order.asc("sessao")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Sessão. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos que contenham a Biblioteca passada por parâmetro.
     *
     * @param biblioteca Biblioteca.
     * @return Acervo acervo.
     */
    public Acervo pesquisarBiblioteca(Biblioteca biblioteca) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            acervo = (Acervo) getSessao().createCriteria(Acervo.class).add(Restrictions.eq("biblioteca", biblioteca)).addOrder(Order.asc("biblioteca")).list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar a Biblioteca. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa Acervos localizáveis pela query(PalavrasChaves) passada por
     * parâmetro.
     *
     * @param query String.
     * @return List querySQL.list().
     */
    public List pesquisarPalavrasChavesQuery(String query) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery querySQL = getSessao().createSQLQuery(query);
            return querySQL.list();
        } catch (HibernateException e) {
            System.out.println("Erro ao consultar por Palavras Chaves. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return null;
    }

    /**
     * Pesquisa Acervos que contenham o codigo passado por parâmetro.
     *
     * @param codigo short.
     * @return Acervo acervo.
     */
    public Acervo pesquisarCodigo(short codigo) {
        Acervo acervo = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());

            acervo = (Acervo) getSessao().createCriteria(Acervo.class).
                    add(Restrictions.eq("idAcervo", codigo)).uniqueResult();

        } catch (HibernateException e) {
            System.out.println("Erro ao procurar por código: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return acervo;
    }

    /**
     * Pesquisa por todos os acervos, e os retorna.
     *
     * @return List querySQL.list()
     */
    public List relatorioAcervo() {
        String text = "select ac.idAcervo, "
                + "ac.tituloObra, "
                + "ci.descricao, "
                + "ed.nome, "
                + "ac.anoEdicao, "
                + "au.nome, "
                + "(select count(*) from exemplar exe "
                + "		where exe.idacervo=2 and ativo=true ) as qtdexemplares, "
                + "(select count(*) from exemplar exe "
                + "		inner join exemplaremprestimos exeemp "
                + "					on exeemp.idExemplar=exe.tombo "
                + "		where exe.idacervo=2) as qtdemprestimos, "
                + "(select count(*) from exemplar exe "
                + "		where exe.idacervo=ac.idAcervo and exe.situacao=3 and ativo=true) as qtdexemplaresemprestados, "
                + "(select count(*) from exemplar exe "
                + "		where exe.idacervo=ac.idAcervo and exe.situacao=4 and ativo=true) as qtdexemplaresconsulta "
                + "from acervo ac "
                + "inner join editora ed on ed.ideditora=ac.ideditora "
                + "inner join cidade ci on ci.idCidade=ed.idcidade "
                + "inner join autoresacervo ae on ae.idAcervo=ac.idAcervo "
                + "inner join autor au on au.idAutor=ae.idAutor;";
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery query = getSessao()
                    .createSQLQuery("select * from acervo ac ").addEntity("acervo", Acervo.class);
            return query.list();
        } catch (HibernateException e) {
            System.out.println("Erro ao localizar o Acervo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return null;
    }

    /**
     * Pesquisa Acervos localizáveis pela query(String) passada por parâmetro.
     *
     * @param query String.
     * @return List querySQL.list().
     */
    public List consultaAcervo(String query) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            SQLQuery querySQL = getSessao().createSQLQuery(query).addEntity(Acervo.class);
            return querySQL.list();
        } catch (HibernateException e) {
            System.out.println("Erro ao consultar por Acervo. Erro: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return null;
    }
}