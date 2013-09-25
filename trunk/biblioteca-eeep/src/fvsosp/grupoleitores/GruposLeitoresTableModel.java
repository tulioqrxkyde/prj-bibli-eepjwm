/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.grupoleitores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
public class GruposLeitoresTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Grupo", "Valor da Multa Diária", "Quantidade Máxima de Livros", "Duração dias de Empréstimo"};
    private List<GruposLeitores> grupos;

    // construtor padrão criando um arraylist de alunos  
    public GruposLeitoresTableModel() {
        grupos = new ArrayList<GruposLeitores>();

    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public GruposLeitoresTableModel(List<GruposLeitores> lista) {
        this();
        this.grupos.clear();
        this.grupos.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return grupos.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        GruposLeitores grupo = grupos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return grupo.getIdGruposLeitores();
            case 1:
                return grupo.getDescricao();
            case 2:
                return grupo.getValorMultaDiaria();
            case 3:
                return grupo.getQuantMaxLivros();
            case 4:
                return grupo.getDuracaoDiasEmprestimo();
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
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
            case 4:
                return nomeColunas[4];
        }
        return null;
    }
}