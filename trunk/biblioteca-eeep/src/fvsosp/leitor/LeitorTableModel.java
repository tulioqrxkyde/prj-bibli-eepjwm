/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.leitor;

import fvsosp.grupoleitores.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
public class LeitorTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Leitor", "Matrícula"};
    private List<Leitor> leitores;

    // construtor padrão criando um arraylist de alunos  
    public LeitorTableModel() {
        leitores = new ArrayList<Leitor>();

    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public LeitorTableModel(List<Leitor> lista) {
        this();
        this.leitores.clear();
        this.leitores.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return leitores.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Leitor leitor = leitores.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000"); 
        switch (columnIndex) {
            case 0:
                return df.format(leitor.getIdLeitor());
            case 1:
                return leitor.getNome();
            case 2:
                return leitor.getMatricula();
            
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

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