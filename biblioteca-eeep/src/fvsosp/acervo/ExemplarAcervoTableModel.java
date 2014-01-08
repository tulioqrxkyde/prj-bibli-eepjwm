/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Pedro Saraiva
 */
@SuppressWarnings("serial")
public class ExemplarAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Tombo", "Nº Exemplar"};
    private List<Exemplar> exemplares;

    // construtor padrão criando um arraylist de alunos  
    public ExemplarAcervoTableModel() {
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public ExemplarAcervoTableModel(List<Exemplar> lista) {
        //this();
//        this.exemplares.clear();
//        this.exemplares.addAll(lista);
        exemplares = new ArrayList(new HashSet(lista));
        Collections.sort(exemplares);
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return exemplares.size();  
    }

    public int getColumnCount() {
        return nomeColunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Exemplar> outraLitsa = (List<Exemplar>) exemplares;
        Exemplar exemplar = outraLitsa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(exemplar.getTombo());
            case 1:
                return Util.decimalFormat(1).format(exemplar.getExemplar());
        }
        return null;
    }

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