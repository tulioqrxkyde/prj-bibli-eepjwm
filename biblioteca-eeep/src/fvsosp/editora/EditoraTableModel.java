package fvsosp.editora;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
@SuppressWarnings("serial")
public class EditoraTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição"};
    private List<Editora> editoras;

    public EditoraTableModel(List<Editora> lista) {
        editoras = new ArrayList(new HashSet(lista));
        this.editoras.clear();
        this.editoras.addAll(lista);
        Collections.sort(editoras);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return editoras.size(); 
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Editora editora = editoras.get(rowIndex);
        switch (columnIndex) {
            case 0:
                    return Util.decimalFormat().format(editora.getIdEditora());
            case 1:
                    return editora.getNome();
            
        }
        return null;
    }

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