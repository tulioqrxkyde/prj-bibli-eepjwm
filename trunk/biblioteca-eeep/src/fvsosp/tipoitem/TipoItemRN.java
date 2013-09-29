/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.tipoitem;

import fvsosp.idioma.Idioma;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class TipoItemRN {

    private TipoItemDAO dao = new TipoItemDAO();

    public boolean remover(TipoItem tp) {
        return dao.remover(tp);

    }

    public boolean salvar(TipoItem tp) {
        if (tp.getIdTipoItem() == 0) {
            if (tp.getDescricao() != null) {
                return dao.adicionar(tp);

            }
        } else {
            return dao.atualizar(tp);
        }
        return false;
    }

    public List<TipoItem> listar() {
        return dao.listar();
    }

    public List<TipoItem> pesquisaDescricao(String descricao) {
        return dao.procuraDescricao(descricao);
    }
    public List<TipoItem> pesquisarDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }
    public TipoItem pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
 }
}

