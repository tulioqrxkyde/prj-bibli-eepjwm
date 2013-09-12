/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;

import fvsosp.biblioteca.Biblioteca;
import fvsosp.editora.Editora;
import fvsosp.especificacoes.EspecificacoesTecnicas;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import java.util.List;

/**
 *
 * @author marcos
 */
public class AcervoRN {

    private AcervoDAO dao = new AcervoDAO();

    // Metódo que adiciona um livro no acervo, caso contrário retorna false
    public boolean adiciona(Acervo acervo) {
        if (acervo.getTituloObra() != null) {
            dao.adicionar(acervo);
            return true;
        }
        return false;
    }

    // Metódo que remove
    public boolean remover(Acervo acervo) {
        dao.remover(acervo);
        return true;
    }

    // Metódo que atualiza no banco de dados o acervo
    public boolean atualizar(Acervo acervo) {
        dao.atualizar(acervo);
        return true;
    }

    // Metódo que faz um List de arcervos
    public List<Acervo> listar() {
        return dao.listar();
    }

    // Metódos de pesquisa
    public List<Acervo> pesquisarTombo(int tombos) {
        return dao.pesquisarTombo(tombos);
    }

    public List<Acervo> pesquisarTitulodaObra(String obra) {
        return dao.pesquisarTitulodaObra(obra);
    }

    public List<Acervo> pesquisarSubTitulodaObra(String subtitulo) {
        return dao.pesquisarSubTitulodaObra(subtitulo);
    }

    public List<Acervo> pesquisarIsbn(String isbns) {
        return dao.pesquisarIsbn(isbns);
    }

    public List<Acervo> pesquisarExemplar(int exemplares) {
        return dao.pesquisarExemplar(exemplares);
    }

    public List<Acervo> pesquisarVolume(String volumes) {
        return dao.pesquisarVolume(volumes);
    }

    public List<Acervo> pesquisarEdicao(String edicoes) {
        return dao.pesquisarEdicao(edicoes);
    }

    public List<Acervo> pesquisaranoEdicao(int anos) {
        return dao.pesquisaranoEdicao(anos);
    }

    public List<Acervo> pesquisarInformacoesAdicionais(String informacoes) {
        return dao.pesquisarInformacoesAdicionais(informacoes);
    }

    public List<Acervo> pesquisarLocalizacao(String localizacoes) {
        return dao.pesquisarLocalizacao(localizacoes);
    }

    public List<Acervo> pesquisarTipoItem(TipoItem tipoitem) {
        return dao.pesquisarTipoItem(tipoitem);
    }

    public List<Acervo> pesquisarEditora(Editora editora) {
        return dao.pesquisarEditora(editora);
    }

    public List<Acervo> pesquisarEspecificacoesTecnicas(EspecificacoesTecnicas escpecificacoestecnicas) {
        return dao.pesquisarEspecificacoesTecnicas(escpecificacoestecnicas);
    }

    public List<Acervo> pesquisarSessao(Sessao sessao) {
        return dao.pesquisarSessao(sessao);
    }
}
