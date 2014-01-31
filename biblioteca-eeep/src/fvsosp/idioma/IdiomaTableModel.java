package fvsosp.idioma;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oziel
 */
@SuppressWarnings("serial")
public class IdiomaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Idioma"};
    private List<Idioma> idiomas;

    public IdiomaTableModel(List<Idioma> lista) {
        idiomas = new ArrayList(new HashSet(lista));
//        this.idiomas.clear();
//        this.idiomas.addAll(lista);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return idiomas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Idioma idioma = idiomas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(idioma.getIdIdioma());
            case 1:
                return idioma.getDescricao();
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