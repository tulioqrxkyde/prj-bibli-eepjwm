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
package fvsosp.grupoleitores;

import fvsosp.util.Util;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
public class GruposLeitoresTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Grupo", "Valor da Multa Diária", "Quantidade Máxima de Livros", "Duração dias de Empréstimo"};
    private List<GruposLeitores> grupos;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(GruposLeitores).
     */
    
    // construtor que adiciona a lista passada pelo método ao alunos  
    public GruposLeitoresTableModel(List<GruposLeitores> lista) {
        grupos = new ArrayList<>();
        this.grupos.clear();
        this.grupos.addAll(lista);
        Collections.sort(grupos);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    
    @Override
    public int getRowCount() {
        return grupos.size();
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
        GruposLeitores grupo = grupos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(grupo.getIdGruposLeitores());
            case 1:
                return grupo.getDescricao();
            case 2:
                return grupo.getValorMultaDiaria();
            case 3:
                return grupo.getQuantMaxLivros();
            case 4:
                return grupo.getDuracaoDiasEmprestimo();
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
            case 3:
                return nomeColunas[3];
            case 4:
                return nomeColunas[4];
        }
        return null;
    }
}