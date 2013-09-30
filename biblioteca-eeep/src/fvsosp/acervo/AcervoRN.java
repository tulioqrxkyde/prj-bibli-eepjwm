/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;

import fvsosp.editora.Editora;
import fvsosp.especificacoes.EspecificacoesTecnicas;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class AcervoRN {

    private AcervoDAO dao = new AcervoDAO();

    // Metódo que adiciona um livro no acervo, caso contrário retorna false
    public boolean salvar(Acervo acervo) {
        if (!acervo.getTituloObra().isEmpty() && !acervo.getSubtituloObra().isEmpty() && !acervo.getIsbn().isEmpty()
                && !acervo.getVolume().isEmpty() && !acervo.getEdicao().isEmpty() && acervo.getAnoEdicao() > 0
                && !acervo.getInformacoesAdicionais().isEmpty() && !acervo.getLocalizacao().isEmpty() /*&& acervo.getAutor() != null
                && acervo.getBiblioteca() != null && acervo.getEditora() != null && acervo.getEspecificacoesTecnicas() != null 
                && acervo.getExemplares() != null && acervo.getIdioma() != null && acervo.getSessao() != null && acervo.getTipoItem() != null
                * */) {
            if (acervo.getIdAcervo() == 0) {
                return dao.adicionar(acervo);
            } else {
                return dao.atualizar(acervo);
            }
        }
        JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
        return false;
    }

    // Metódo que remove
    public boolean remover(Acervo acervo) {
        return dao.remover(acervo);
    }

    // Metódo que faz um List de arcervos
    public List<Acervo> listar() {
        return dao.listar();
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

    public List<Acervo> pesquisarVolume(String volumes) {
        return dao.pesquisarVolume(volumes);
    }

    public List<Acervo> pesquisarEdicao(String edicoes) {
        return dao.pesquisarEdicao(edicoes);
    }

    public List<Acervo> pesquisaranoEdicao(short anos) {
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

    public Acervo pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}
