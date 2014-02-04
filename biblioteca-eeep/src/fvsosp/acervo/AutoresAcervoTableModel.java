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
package fvsosp.acervo;

import fvsosp.autor.Autor;
import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedrosaraiva
 */
@SuppressWarnings("serial")
public class AutoresAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Nome"};
    private List<Autor> autores;

    /**
     * Construtor padrão criando um arraylist de alunos.
     */
    public AutoresAcervoTableModel() {
        autores = new ArrayList<>();
    }

    /**
     * Construtor sobrecarregado que adiciona a lista passada pelo método aos
     * autores.
     *
     * @param lista Set(Autor).
     */
    public AutoresAcervoTableModel(Set<Autor> lista) {
        this();
        this.autores.clear();
        this.autores.addAll(lista);
        Collections.sort(autores);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return autores.size();
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
     * @param rowIndex.
     * @param columnIndex.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Autor> outraLista = (List<Autor>) autores;
        Autor autor = outraLista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(autor.getIdAutor());
            case 1:
                return autor.getSobrenome() + ", " + autor.getNome();
        }
        return null;
    }

    /**
     * @param column.
     * @return String nomeColunas[index].
     */
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