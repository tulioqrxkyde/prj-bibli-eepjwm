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
package fvsosp.idioma;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
public class IdiomaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Idioma"};
    private List<Idioma> idiomas;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    
    public IdiomaTableModel(List<Idioma> lista) {
        idiomas = new ArrayList(new HashSet(lista));
//        this.idiomas.clear();
//        this.idiomas.addAll(lista);
        super.fireTableDataChanged();
    }

     /**
     * Método sobrescrito.
     *
     * @return int.
     */
    
    @Override
    public int getRowCount() {
        return idiomas.size();
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
     * @param rowIndex int
     * @param columnIndex int.
     * @return Object.
     */
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Idioma idioma = idiomas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(idioma.getIdIdioma());
            case 1:
                return idioma.getDescricao();
        }
        return null;
    }

    /**
     * Método sobrescrito.
     * 
     * @param column int.
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