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
package fvsosp.multa;

import fvsosp.leitor.*;
import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Francisco Junior
 */
@SuppressWarnings("serial")
public class MultaTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Dt.Devolução",
        "Leitor", "Valor", "Tombo", "Titúlo"};
    private List<Multa> multas;
    
     /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Multa).
     */

    // construtor que adiciona a lista passada pelo método ao alunos  
    public MultaTableModel(List<Multa> lista) {
        multas = new ArrayList<>();
        this.multas.clear();
        this.multas.addAll(lista);
        super.fireTableDataChanged();
    }

     /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return multas.size();
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

     /**
     * Método sobrescrito.
     * 
     * @param column int.
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
            case 4:
                return nomeColunas[4];
            case 5:
                return nomeColunas[5];

        }
        return null;
    }
}