package fvsosp.leitor;

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
public class LeitorTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Leitor", "Matrícula"};
    private List<Leitor> leitores;

    // construtor que adiciona a lista passada pelo método ao alunos  
    public LeitorTableModel(List<Leitor> lista) {
        leitores = new ArrayList(new HashSet(lista));
//        this.leitores.clear();
//        this.leitores.addAll(lista);
        Collections.sort(leitores);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return leitores.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Leitor leitor = leitores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(leitor.getIdLeitor());
            case 1:
                return leitor.getNome();
            case 2:
                return leitor.getMatricula();
            
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