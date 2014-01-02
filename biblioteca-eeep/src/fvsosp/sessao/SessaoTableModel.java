/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.sessao;

import fvsosp.sessao.Sessao;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PSaraiva
 */
public class SessaoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Sessão"};
    private List<Sessao> sessoes;

    // construtor padrão criando um arraylist de alunos  
    public SessaoTableModel() {
        sessoes = new ArrayList<Sessao>();

    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public SessaoTableModel(List<Sessao> lista) {
        this();
        this.sessoes.clear();
        this.sessoes.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return sessoes.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Sessao sessao = sessoes.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000"); 
        switch (columnIndex) {
            case 0:
                return df.format(sessao.getIdSessao());
            case 1:
                return sessao.getDescricao();
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
