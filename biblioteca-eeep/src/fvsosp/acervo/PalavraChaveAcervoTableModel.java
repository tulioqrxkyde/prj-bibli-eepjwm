/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;

import fvsosp.palavraschaves.PalavrasChaves;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TÚLIO
 */
public class PalavraChaveAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Descrição"};
    private List<PalavrasChaves> palavras;

    // construtor padrão criando um arraylist de alunos  
    public PalavraChaveAcervoTableModel() {
        palavras = new ArrayList<PalavrasChaves>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public PalavraChaveAcervoTableModel(Set<PalavrasChaves> lista) {
        this();
        this.palavras.clear();
        this.palavras.addAll(lista);
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return palavras.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List<PalavrasChaves> outraLitsa = (List<PalavrasChaves>) palavras;
        PalavrasChaves palavra = outraLitsa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return palavra.getDescricao();
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
        }
        return null;
    }
}