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

import fvsosp.exemplaremprestimos.ExemplarEmprestimos;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedrosaraiva
 */
public class ItensEmprestimoTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 52983324940038415L;
    private String[] nomeColunas = {"Tombo", "Exemplar", "Descrição", "Operação"};
    private List<ExemplarEmprestimos> exemplares;

    /**
     * Construtor padrão criando um arraylist de alunos.
     */
    public ItensEmprestimoTableModel() {
        exemplares = new ArrayList<ExemplarEmprestimos>();
    }

    /**
     * Construtor sobrecarregado.
     *
     * @param lista Set(ExemplarEmprestimos).
     */
    public ItensEmprestimoTableModel(Set<ExemplarEmprestimos> lista) {
        this();
        this.exemplares.clear();
        this.exemplares.addAll(lista);
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
     * @param rowIndex int
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<ExemplarEmprestimos> outraLista = (List<ExemplarEmprestimos>) exemplares;
        ExemplarEmprestimos exemplar = outraLista.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000");
        DecimalFormat df2 = new DecimalFormat("000");
        switch (columnIndex) {
            case 0:
                return df.format(exemplar.getExemplar().getTombo());
            case 1:
                return df2.format(exemplar.getExemplar().getExemplar());
            case 2:
                return exemplar.getExemplar().getAcervo().getTituloObra();
            case 3:
                return exemplar.descricaoOperacao();
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