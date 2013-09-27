/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.idioma;

import fvsosp.sessao.Sessao;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class IdiomaRN {

    private IdiomaDAO dao = new IdiomaDAO();

    public boolean salvar (Idioma idioma) {
        if (!idioma.getDescricao().isEmpty()){
        if (idioma.getIdIdioma() == 0) {
            if (idioma.getDescricao() != null) {
                return dao.adicionar(idioma);

            }
        } else {
            return dao.atualizar(idioma);
        }
        }
        return false;

    }

    public boolean remove(Idioma idioma) {
        return dao.remover(idioma);

    }

    public List<Idioma> listar() {
        return dao.listar();
    }

    public List<Idioma> pesquisaDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    public List<Idioma> pesquisarDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }
    public Idioma pesquisarCodigo(int codigo) {
        return dao.pesquisarCodigo(codigo);
 }
}
