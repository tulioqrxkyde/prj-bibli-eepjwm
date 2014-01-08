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
 * @author Pedro Saraiva
 */
@SuppressWarnings("serial")
public class PalavraChaveAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição"};
    private List<PalavrasChaves> palavras;

    // construtor padrão criando um arraylist de alunos  
    public PalavraChaveAcervoTableModel() {
        palavras = new ArrayList<>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public PalavraChaveAcervoTableModel(Set<PalavrasChaves> lista) {
        this();
        this.palavras.clear();
        this.palavras.addAll(lista);
        Collections.sort(palavras);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return palavras.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

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