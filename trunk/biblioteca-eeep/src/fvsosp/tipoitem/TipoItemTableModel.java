package fvsosp.tipoitem;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oziel
 */
@SuppressWarnings("serial")
public class TipoItemTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição"};
    private List<TipoItem> tipoitems;

    public TipoItemTableModel() {
        tipoitems = new ArrayList<>();
    }

    public TipoItemTableModel(List<TipoItem> lista) {
        this();
        this.tipoitems.clear();
        this.tipoitems.addAll(lista);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return tipoitems.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoItem tipoitem = tipoitems.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(tipoitem.getIdTipoItem());
            case 1:
                return tipoitem.getDescricao();
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