package fvsosp.palavraschaves;

import fvsosp.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PSaraiva
 */
@SuppressWarnings("serial")
public class PalavrasChavesTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição"};
    private List<PalavrasChaves> palavras;

    // construtor padrão criando um arraylist de alunos  
    public PalavrasChavesTableModel() {
        
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public PalavrasChavesTableModel(List<PalavrasChaves> lista) {
        palavras = new ArrayList(new HashSet(lista));
//        this.palavras.clear();
//        this.palavras.addAll(lista);
        Collections.sort(palavras);
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return palavras.size();  
    }

    public int getColumnCount() {
        return nomeColunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        PalavrasChaves palavra = palavras.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(palavra.getIdPalavrasChaves());
            case 1:
                return palavra.getDescricao();
        }
        return null;
    }

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