package fvsosp.biblioteca;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tulio.xcrtf
 */
@SuppressWarnings("serial")
public class BibliotecaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Biblioteca"};
    private List<Biblioteca> bibliotecas;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Biblioteca).
     */
    public BibliotecaTableModel(List<Biblioteca> lista) {
        bibliotecas = new ArrayList<>();
        this.bibliotecas.clear();
        this.bibliotecas.addAll(lista);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return bibliotecas.size();
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
        Biblioteca biblioteca = bibliotecas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(biblioteca.getIdBiblioteca());
            case 1:
                return biblioteca.getDescricao();
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
        }
        return null;
    }
}