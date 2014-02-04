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
import fvsosp.editora.Editora;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos.ellys
 */
public class AcervoRN {

    private AcervoDAO dao = new AcervoDAO();

    /**
     * Acessa o método dao.adicionar de AcervoDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) salvando o Acervo.
     *
     * @param acervo Acervo.
     * @return booleano (true|false).
     * @see AcervoDAO.
     */
    public boolean salvar(Acervo acervo) {
        if (acervo.getIdAcervo() == 0) {
            List<Acervo> lista = dao.checkExists("tituloObra", acervo.getTituloObra());
            if (lista.isEmpty()) {
                return dao.adicionar(acervo);
            } else {
                JOptionPane.showMessageDialog(null, "Título de Obra Já cadastrado para Acervo");
                return false;
            }
        } else {
            return dao.atualizar(acervo);
        }
    }

    /**
     * Acessa o método dao.remover de AcervoDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo o Acervo.
     *
     * @param acervo Acervo.
     * @return booleano (true|false).
     * @see AcervoDAO.
     */
    public boolean remover(Acervo acervo) {
        return dao.remover(acervo);
    }

    /**
     * Acessa o método dao.listar de AcervoDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) listando os Acervos.
     *
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.pesquisarTitulodaObra(obra) de AcervoDAO.
     *
     * @param obra String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarTitulodaObra(String obra) {
        return dao.pesquisarTitulodaObra(obra);
    }

    /**
     * Acessa o método dao.pesquisarTitulodaObraEq(obra) de AcervoDAO.
     *
     * @param obra String.
     * @return Acervo.
     * @see AcervoDAO.
     */
    public Acervo pesquisarTitulodaObraEq(String obra) {
        return dao.pesquisarTitulodaObraEq(obra);
    }

    /**
     * Acessa o método dao.pesquisarSubTitulodaObra(subtitulo) de AcervoDAO.
     *
     * @param subtitulo String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarSubTitulodaObra(String subtitulo) {
        return dao.pesquisarSubTitulodaObra(subtitulo);
    }

    /**
     * Acessa o método dao.pesquisarIsbn(isbns) de AcervoDAO.
     *
     * @param isbns String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarIsbn(String isbns) {
        return dao.pesquisarIsbn(isbns);
    }

    /**
     * Acessa o método dao.pesquisarVolume(volumes) de AcervoDAO.
     *
     * @param volumes String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarVolume(String volumes) {
        return dao.pesquisarVolume(volumes);
    }

    /**
     * Acessa o método dao.pesquisarEdicao(edicoes) de AcervoDAO.
     *
     * @param edicoes String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarEdicao(String edicoes) {
        return dao.pesquisarEdicao(edicoes);
    }

    /**
     * Acessa o método dao.pesquisarTitulodaObra(obra) de AcervoDAO.
     *
     * @param obra String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisaranoEdicao(short anos) {
        return dao.pesquisaranoEdicao(anos);
    }

    /**
     * Acessa o método dao.pesquisarInformacoesAdicionais(informacoes) de
     * AcervoDAO.
     *
     * @param informacoes String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarInformacoesAdicionais(String informacoes) {
        return dao.pesquisarInformacoesAdicionais(informacoes);
    }

    /**
     * Acessa o método dao.pesquisarLocalizacao(localizacoes) de AcervoDAO.
     *
     * @param localizacoes String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarLocalizacao(String localizacoes) {
        return dao.pesquisarLocalizacao(localizacoes);
    }

    /**
     * Acessa o método dao.pesquisarAutor(autor) de AcervoDAO.
     *
     * @param autor Autor.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarAutor(Autor autor) {
        return dao.pesquisarAutor(autor);
    }

    /**
     * Acessa o método dao.pesquisarAutorQuery(query) de AcervoDAO.
     *
     * @param query String.
     * @return List querySQL.list().
     * @see AcervoDAO.
     */
    public List pesquisarAutorQuery(String query) {
        return dao.pesquisarAutorQuery(query);
    }

    /**
     * Acessa o método dao.pesquisarPalavrasChavesQuery(query) de AcervoDAO.
     *
     * @param query String.
     * @return List querySQL.list().
     * @see AcervoDAO.
     */
    public List pesquisarPalavrasChavesQuery(String query) {
        return dao.pesquisarPalavrasChavesQuery(query);
    }

    /**
     * Acessa o método dao.pesquisarEditora(editora) de AcervoDAO.
     *
     * @param editora Editora.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarEditora(Editora editora) {
        return dao.pesquisarEditora(editora);
    }

    /**
     * Acessa o método dao.pesquisarTipoItem(tipoitem) de AcervoDAO.
     *
     * @param tipoitem TipoItem.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarTipoItem(TipoItem tipoitem) {
        return dao.pesquisarTipoItem(tipoitem);
    }

    /**
     * Acessa o método dao.pesquisarSessao(sessao) de AcervoDAO.
     *
     * @param sessao Sessao.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List<Acervo> pesquisarSessao(Sessao sessao) {
        return dao.pesquisarSessao(sessao);
    }

    /**
     * Acessa o método dao.pesquisarCodigo(codigo) de AcervoDAO.
     *
     * @param codigo short.
     * @return Acervo.
     * @see AcervoDAO.
     */
    public Acervo pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }

    /**
     * Acessa o método dao.relatorioAcervo() de AcervoDAO.
     *
     * @return List querySQL.list().
     * @see AcervoDAO.
     */
    public List relatorioAcervo() {
        return dao.relatorioAcervo();
    }

    /**
     * Acessa o método dao.consultaAcervo(query) de AcervoDAO.
     *
     * @param obra String.
     * @return List(Acervo).
     * @see AcervoDAO.
     */
    public List consultaAcervo(String query) {
        return dao.consultaAcervo(query);
    }
}