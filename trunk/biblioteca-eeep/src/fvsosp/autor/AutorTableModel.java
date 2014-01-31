package fvsosp.autor;

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
public class AutorTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Sobrenome","Autor", "Sobre o Autor"};
    private List<Autor> autores;

    public AutorTableModel(List<Autor> lista) {
        autores = new ArrayList(new HashSet(lista));
        this.autores.clear();
        this.autores.addAll(lista);
        Collections.sort(autores);
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
                    return autor.getSobrenome();
            case 2:
                    return autor.getNome();
            case 3:
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
            case 3:
                return nomeColunas[3];
        }
        return null;
    }
}