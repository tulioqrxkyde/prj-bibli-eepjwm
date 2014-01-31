package fvsosp.sessao;

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
public class SessaoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Sessão"};
    private List<Sessao> sessoes;

    // construtor que adiciona a lista passada pelo método ao alunos  
    public SessaoTableModel(List<Sessao> lista) {
        sessoes = new ArrayList(new HashSet(lista));
        this.sessoes.clear();
        this.sessoes.addAll(lista);
        Collections.sort(sessoes);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return sessoes.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sessao sessao = sessoes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(sessao.getIdSessao());
            case 1:
                return sessao.getDescricao();
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