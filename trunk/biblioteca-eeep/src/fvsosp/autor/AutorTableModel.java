/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.autor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
public class AutorTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Autor", "Descrição"};
    private List<Autor> autores;

    public AutorTableModel() {
        autores = new ArrayList<>();
    }

    public AutorTableModel(List<Autor> lista) {
        this();
        this.autores.clear();
        this.autores.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return autores.size();
    }

    public int getColumnCount() {
        return nomeColunas.length;  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = autores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                    return autor.getIdAutor();
            case 1:
                    return autor.getNome();
            case 2:
                    return autor.getSobreOAutor();
        }
        return null;
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