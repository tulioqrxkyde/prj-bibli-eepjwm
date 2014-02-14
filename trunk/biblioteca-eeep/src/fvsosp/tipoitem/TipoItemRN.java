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
package fvsosp.tipoitem;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pedrosaraiva
 */
public class TipoItemRN {

    private TipoItemDAO dao = new TipoItemDAO();

    /**
     * Acessa o método dao.remover de TipoItemDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) removendo o TipoItem.
     *
     * @param tp TipoItem.
     * @return booleano (true|false).
     * @see TipoItemDAO.
     */
    public boolean remover(TipoItem tp) {
        return dao.remover(tp);

    }

    /**
     * Acessa o método dao.adicionar de TipoItemDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) salvado o TipoItem.
     *
     * @param tp TipoItem.
     * @return booleano (true|false).
     * @see TipoItemDAO.
     */
    public boolean salvar(TipoItem tp) {
        if (tp.getIdTipoItem() == 0) {
            List<TipoItem> lista = dao.checkExists("descricao", tp.getDescricao());
            if (lista.isEmpty()) {
                return dao.adicionar(tp);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição já cadastrada para Tipo de Item!");
                return false;
            }
        } else {
            return dao.atualizar(tp);
        }
    }

    /**
     * Acessa o método dao,listar de TipoItemDAO que por sua vez acessa o método
     * da classe generica (GenericDAO) listando o TipoItem.
     *
     * @return List(TipoItem).
     * @see TipItemDAO.
     */
    public List<TipoItem> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.procuraDescricao(descricao) de TipoItemDAO.
     *
     * @param descricao String.
     * @return TipoItem.
     * @see TipoItemDAO.
     */
    public List<TipoItem> pesquisaDescricao(String descricao) {
        return dao.procuraDescricao(descricao);
    }

    /**
     * Acessa o método dao.pesquisarDescricaoEq(descricao) de TipoItemDAO.
     *
     * @param descricao String.
     * @return TipoItem.
     * @see TipoItemDAO.
     */
    public TipoItem pesquisarDescricaEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }

    /**
     * Acessa o método dao.pesquisarCodigo(codigo) de TipoItemDAO.
     *
     * @param codigo short.
     * @return TipoItem.
     * @see TipoItemDAO.
     */
    public TipoItem pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}