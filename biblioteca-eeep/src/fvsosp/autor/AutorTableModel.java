package fvsosp.autor;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
@SuppressWarnings("serial")
public class AutorTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Autor", "Descrição"};
    private List<Autor> autores;

    public AutorTableModel(List<Autor> lista) {
        autores = new ArrayList<>();
        this.autores.clear();
        this.autores.addAll(lista);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return autores.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = autores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                    return Util.decimalFormat().format(autor.getIdAutor());
            case 1:
                    return autor.getNome();
            case 2:
                    return autor.getSobreOAutor();
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
            case 2:
                return nomeColunas[2];
        }
        return null;
    }
}