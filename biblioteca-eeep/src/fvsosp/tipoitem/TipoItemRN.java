/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.tipoitem;

import java.util.List;
import javax.swing.JOptionPane;

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
            List<TipoItem> lista = dao.checkExists("descricao", tp.getDescricao());
            if(lista.size()==0){
            return dao.adicionar(tp);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição já cadastrada para Tipo de Item!");
                return false;
            }
        } else {
            return dao.atualizar(tp);
        }
    }

    public List<TipoItem> listar() {
        return dao.listar();
    }

    public List<TipoItem> pesquisaDescricao(String descricao) {
        return dao.procuraDescricao(descricao);
    }

    public TipoItem pesquisarDescricaEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }

    public TipoItem pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}
