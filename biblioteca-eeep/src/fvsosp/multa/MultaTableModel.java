package fvsosp.multa;

import fvsosp.leitor.*;
import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
@SuppressWarnings("serial")
public class MultaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Dt.Devolução",
        "Leitor", "Valor", "Tombo", "Titúlo"};
    private List<Multa> multas;

    // construtor que adiciona a lista passada pelo método ao alunos  
    public MultaTableModel(List<Multa> lista) {
        multas = new ArrayList<>();
        this.multas.clear();
        this.multas.addAll(lista);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return multas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Multa multa = multas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(multa.getIdMulta());
            case 1:
                return multa.getExemplarEmprestimo().getDataDevolucao();
            case 2:
                return multa.getExemplarEmprestimo().getEmprestimo().getLeitor().getNome();
            case 3:
                return multa.getValor();
            case 4:
                return Util.decimalFormat().format(multa.getExemplarEmprestimo().getExemplar().getTombo());
            case 5:
                return multa.getExemplarEmprestimo().getExemplar().getAcervo().getTituloObra();


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
            case 4:
                return nomeColunas[4];
            case 5:
                return nomeColunas[5];

        }
        return null;
    }
}