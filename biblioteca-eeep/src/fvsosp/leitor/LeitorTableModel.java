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
package fvsosp.leitor;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
public class LeitorTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Leitor", "Matrícula"};
    private List<Leitor> leitores;

      /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Autor).
     */
    
    // construtor que adiciona a lista passada pelo método ao alunos  
    public LeitorTableModel(List<Leitor> lista) {
        leitores = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(leitores);
        super.fireTableDataChanged();
    }

     /**
     * Método sobrescrito.
     *
     * @return int.
     */
    
    @Override
    public int getRowCount() {
        return leitores.size();
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
        Leitor leitor = leitores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(leitor.getIdLeitor());
            case 1:
                return leitor.getNome();
            case 2:
                return leitor.getMatricula();
            
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
            case 2:
                return nomeColunas[2];
        }
        return null;
    }
}