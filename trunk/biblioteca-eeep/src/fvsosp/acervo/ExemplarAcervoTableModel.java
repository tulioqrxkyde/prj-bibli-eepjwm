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
package fvsosp.acervo;

import fvsosp.exemplar.Exemplar;
import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedrosaraiva
 */
@SuppressWarnings("serial")
public class ExemplarAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Tombo", "Nº Exemplar"};
    private List<Exemplar> exemplares;

    /**
     * Construtor padrão.
     */
    public ExemplarAcervoTableModel() {
    }

    /**
     * Construtor sobrecarregado.
     *
     * @param list List(Exemplar).
     */
    public ExemplarAcervoTableModel(List<Exemplar> lista) {
        //this();
//        this.exemplares.clear();
//        this.exemplares.addAll(lista);
        exemplares = new ArrayList(new HashSet(lista));
        Collections.sort(exemplares);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return exemplares.size();
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
        List<Exemplar> outraLista = (List<Exemplar>) exemplares;
        Exemplar exemplar = outraLista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(exemplar.getTombo());
            case 1:
                return Util.decimalFormat(1).format(exemplar.getExemplar());
        }
        return null;
    }

    /**
     * Método sobrescrito.
     * 
     * @param column int
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