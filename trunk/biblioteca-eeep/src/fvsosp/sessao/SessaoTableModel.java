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
package fvsosp.sessao;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PSaraiva
 */
@SuppressWarnings("serial")
public class SessaoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Sessão"};
    private List<Sessao> sessoes;

    /**
     * Construtor sobrecarregado que adiciona a lista passada pelo método
     * a Sessao.
     *
     * @param lista List(Sessao).
     */
    public SessaoTableModel(List<Sessao> lista) {
        sessoes = new ArrayList(new HashSet(lista));
        this.sessoes.clear();
        this.sessoes.addAll(lista);
        Collections.sort(sessoes);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return sessoes.size();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    /**
     * Método sobrescrito.
     *
     * @param rowIndex int.
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sessao sessao = sessoes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(sessao.getIdSessao());
            case 1:
                return sessao.getDescricao();
        }
        return null;
    }

    /**
     * Método sobrescrito
     * 
     * @param column String.
     * @return String nomeColunas[index].
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
            case 1:
                return nomeColunas[1];
        }
        return null;
    }
}