package fvsosp.emprestimo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TULIO
 */
public class EmprestimoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Data de Empréstimo", "Acervo", "Autor"};
    private List<Emprestimo> emprestimos;

    public EmprestimoTableModel() {
        emprestimos = new ArrayList<Emprestimo>();
    }

    public EmprestimoTableModel(List<Emprestimo> lista) {
        this();
        this.emprestimos.clear();
        this.emprestimos.addAll(lista);
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return emprestimos.size();
    }

    public int getColumnCount() {
        return nomeColunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Emprestimo emprestimo = emprestimos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return emprestimo.getIdEmprestimo();
            case 1:
                return emprestimo.getDataEmprestimo();
//            case 2:
//                return emprestimo.getExemplares();
            case 3:
                return emprestimo.getLeitor();

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
            case 3:
                return nomeColunas[3];
        }
        return null;
    }
}