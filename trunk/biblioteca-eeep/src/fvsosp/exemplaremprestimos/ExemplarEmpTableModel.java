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
package fvsosp.exemplaremprestimos;

import fvsosp.acervo.*;
import fvsosp.exemplar.Exemplar;
import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedrosaraiva
 */
@SuppressWarnings("serial")
public class ExemplarEmpTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Tombo", "Título da Obra", "Leitor", "Data Prevista"};
    private List<ExemplarEmprestimos> exemplares;

    /**
     * Construtor padrão.
     */
    public ExemplarEmpTableModel() {
    }

    /**
     * Construtor sobrecarregado.
     *
     * @param list List(Exemplar).
     */
    public ExemplarEmpTableModel(List<ExemplarEmprestimos> lista) {
        //this();
//        this.exemplares.clear();
//        this.exemplares.addAll(lista);
        exemplares = new ArrayList(new HashSet(lista));
        Collections.sort(exemplares);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return exemplares.size();
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
     * @param rowIndex int.
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<ExemplarEmprestimos> outraLista = (List<ExemplarEmprestimos>) exemplares;
        ExemplarEmprestimos exemplar = outraLista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(exemplar.getExemplar().getTombo());
            case 1:
                return exemplar.getExemplar().getAcervo().getTituloObra();
            case 2:
                return exemplar.getEmprestimo().getLeitor().getNome();
            case 3:
                return exemplar.getDataPrevistaDevolucao();
        }
        return null;
    }

    /**
     * Método sobrescrito.
     *
     * @param column int
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