/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.editora;

import fvsosp.autor.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
public class EditoraTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrião"};
    private List<Editora> editoras;

    public EditoraTableModel() {
        editoras = new ArrayList<Editora>();
    }

    public EditoraTableModel(List<Editora> lista) {
        this();
        this.editoras.clear();
        this.editoras.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return editoras.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Editora editora = editoras.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000"); 
        switch (columnIndex) {
            case 0:
                    return df.format(editora.getIdEditora());
            case 1:
                    return editora.getNome();
            
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
        }
        return null;
    }
}