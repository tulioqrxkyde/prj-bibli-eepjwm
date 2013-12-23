package fvsosp.cidade;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 *
 * @author Controle Avaliação
 */
@SuppressWarnings("serial")
public class CidadeTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"CodIBGE", "Descrição", "UF"};
    private List<Cidade> cidades;

    public CidadeTableModel() {
        cidades = new ArrayList<>();
    }

    public CidadeTableModel(List<Cidade> lista) {
        this();
        this.cidades.clear();
        this.cidades.addAll(lista);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return cidades.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cidade cidade = cidades.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cidade.getCodIBGE();
            case 1:
                return cidade.getDescricao();
            case 2:
                return cidade.getUf();
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