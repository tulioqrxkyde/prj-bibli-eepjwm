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

import fvsosp.palavraschaves.PalavrasChaves;
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
public class PalavraChaveAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição"};
    private List<PalavrasChaves> palavras;

    /**
     * Construtor padrão criando um arraylist de Palavras Chaves.
     */
    public PalavraChaveAcervoTableModel() {
        palavras = new ArrayList<>();
    }

    /**
     * Construtor sobrecarregado que adiciona a lista passada pelo método as
     * Palavras Chaves.
     *
     * @param lista Set(PalavrasChaves).
     */
    public PalavraChaveAcervoTableModel(Set<PalavrasChaves> lista) {
        this();
        this.palavras.clear();
        this.palavras.addAll(lista);
        Collections.sort(palavras);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return palavras.size();
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
        List<PalavrasChaves> outraLitsa = (List<PalavrasChaves>) palavras;
        PalavrasChaves palavra = outraLitsa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(palavra.getIdPalavrasChaves());
            case 1:
                return palavra.getDescricao();
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
        }
        return null;
    }
}