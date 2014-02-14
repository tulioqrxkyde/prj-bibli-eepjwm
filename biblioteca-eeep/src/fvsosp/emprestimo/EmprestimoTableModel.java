/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package fvsosp.emprestimo;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tulio.xcrtf
 */
@SuppressWarnings("serial")
public class EmprestimoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Data de Empréstimo", "Acervo", "Autor"};
    private List<Emprestimo> emprestimos;

    /**
     * Construtor sobrecarregado.
     *
     * @param list List(Emprestimo).
     */
    public EmprestimoTableModel(List<Emprestimo> lista) {
        emprestimos = new ArrayList<>();
        this.emprestimos.clear();
        this.emprestimos.addAll(lista);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return emprestimos.size();
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
        Emprestimo emprestimo = emprestimos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(emprestimo.getIdEmprestimo());
            case 1:
                return emprestimo.getDataEmprestimo();
//            case 2:
//                return emprestimo.getExemplares();
            case 3:
                return emprestimo.getLeitor();

        }
        return null;
    }

    /**
     * Método sobrescrito.
     * 
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
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
        }
        return null;
    }
}