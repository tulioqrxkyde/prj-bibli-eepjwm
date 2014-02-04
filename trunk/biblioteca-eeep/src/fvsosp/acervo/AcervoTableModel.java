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

import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tulio.xcrtf
 */
@SuppressWarnings("serial")
public class AcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Título", "Sub-Título", "ISBN",
        "Sessão"};
    private List<Acervo> acervos;

    /**
     * Construtor padrão.
     */
    public AcervoTableModel() {
        //acervos = new LinkedList<Acervo>();
    }

    /**
     * Construtor sobrecarregado.
     *
     * @param list List(Acervo).
     */
    public AcervoTableModel(List<Acervo> lista) {
        //this();
        acervos = new ArrayList(new HashSet(lista));
        Collections.sort(acervos);
        //this.acervos.clear();
        //this.acervos.addAll(lista);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return acervos.size();
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
        Acervo acervo = acervos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return acervo.getIdAcervo();
            case 1:
                return acervo.getTituloObra();
            case 2:
                return acervo.getSubtituloObra();
            case 3:
                return acervo.getIsbn();
            case 4:
                return acervo.getSessao();

        }
        return null;
    }

    /**
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
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
            case 4:
                return nomeColunas[4];
        }
        return null;
    }
}