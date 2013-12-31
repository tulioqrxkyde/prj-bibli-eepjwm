/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.palavraschaves;

import fvsosp.sessao.*;
import fvsosp.sessao.Sessao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PSaraiva
 */
public class PalavrasChavesTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Descrição"};
    private List<PalavrasChaves> palavras;

    // construtor padrão criando um arraylist de alunos  
    public PalavrasChavesTableModel() {
        palavras = new ArrayList<PalavrasChaves>();

    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public PalavrasChavesTableModel(List<PalavrasChaves> lista) {
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
        PalavrasChaves palavra = palavras.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return palavra.getIdPalavrasChaves();
            case 1:
                return palavra.getDescricao();
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");  
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
