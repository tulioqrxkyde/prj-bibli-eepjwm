/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
 * @author marcos
 */
public class AcervoRN {
    
    private AcervoDAO dao = new AcervoDAO();

    // Metódo que adiciona um livro no acervo, caso contrário retorna false
    public boolean salvar(Acervo acervo) {
        if (acervo.getIdAcervo() == 0) {
            List<Acervo> lista = dao.checkExists("tituloObra", acervo.getTituloObra());
            if (lista.size() == 0) {
                return dao.adicionar(acervo);
            } else {
                JOptionPane.showMessageDialog(null, "Título de Obra Já cadastrado para Acervo");
                return false;
            }
        } else {
            return dao.atualizar(acervo);
        }
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
    
    public Acervo pesquisarTitulodaObraEq(String obra) {
        return dao.pesquisarTitulodaObraEq(obra);
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
    
    public List<Acervo> pesquisarAutor(Autor autor) {
        return dao.pesquisarAutor(autor);
    }
    
    public List pesquisarAutorQuery(String query) {
        return dao.pesquisarAutorQuery(query);
    }
    
    public List<Acervo> pesquisarEditora(Editora editora) {
        return dao.pesquisarEditora(editora);
    }
    
    public List pesquisarPalavrasChavesQuery(String query) {
        return dao.pesquisarPalavrasChavesQuery(query);
    }
    
    public List<Acervo> pesquisarTipoItem(TipoItem tipoitem) {
        return dao.pesquisarTipoItem(tipoitem);
    }
    
    public List<Acervo> pesquisarSessao(Sessao sessao) {
        return dao.pesquisarSessao(sessao);
    }
    
    public Acervo pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
    
    public List relatorioAcervo() {
        return dao.relatorioAcervo();
    }
    
    public List consultaAcervo(String query) {
        return dao.consultaAcervo(query);
    }
}