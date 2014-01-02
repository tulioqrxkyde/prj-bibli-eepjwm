package fvsosp.biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TÚLIO
 */
@SuppressWarnings("serial")
public class BibliotecaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Biblioteca"};
    private List<Biblioteca> bibliotecas;

    public BibliotecaTableModel() {
        bibliotecas = new ArrayList<>();

    }

    public BibliotecaTableModel(List<Biblioteca> lista) {
        this();
        this.bibliotecas.clear();
        this.bibliotecas.addAll(lista);
        super.fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return bibliotecas.size(); 
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Biblioteca biblioteca = bibliotecas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return biblioteca.getIdBiblioteca();
            case 1:
                return biblioteca.getDescricao();
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