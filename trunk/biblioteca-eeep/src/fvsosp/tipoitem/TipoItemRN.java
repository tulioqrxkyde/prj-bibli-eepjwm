/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.tipoitem;

import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class TipoItemRN {

    private TipoItemDAO dao = new TipoItemDAO();

    public boolean remover(TipoItem tp) {
        dao.remover(tp);
        return true;
    }

    public boolean atualizar(TipoItem tp) {
        dao.atualizar(tp);
        return true;
    }

    public boolean adiciona(TipoItem tp) {
        if (tp.getDescricao() != null) {
            dao.adicionar(tp);
            return true;
        }
        return false;
    }

    public List<TipoItem> listar() {
        return dao.listar();
    }

    public List<TipoItem> pesquisaDescricao(String descricao) {
        return dao.procuraDescricao(descricao);
    }
}
