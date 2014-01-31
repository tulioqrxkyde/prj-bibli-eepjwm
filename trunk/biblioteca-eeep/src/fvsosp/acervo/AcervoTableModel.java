/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;

import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TÚLIO
 */
public class AcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Título", "Sub-Título", "ISBN", 
                                "Sessão"};
    private List<Acervo> acervos;

    // construtor padrão criando um arraylist de alunos  
    public AcervoTableModel() {
        //acervos = new LinkedList<Acervo>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public AcervoTableModel(List<Acervo> lista) {
        //this();
        acervos = new ArrayList(new HashSet(lista));
        Collections.sort(acervos);
        //this.acervos.clear();
        //this.acervos.addAll(lista);
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return acervos.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Acervo acervo = acervos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return acervo.getIdAcervo();
            case 1:
                return acervo.getTituloObra();
            case 2:
                return acervo.getSubtituloObra();
            case 3:
                return acervo.getIsbn();        
            case 4:
                return acervo.getSessao();
            
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