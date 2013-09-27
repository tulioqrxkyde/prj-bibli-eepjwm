/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.idioma;

import fvsosp.sessao.Sessao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oziel
 */
public class IdiomaTableModel extends AbstractTableModel {
    
     private String[] nomeColunas = {"Código", "Idioma"};
     private List<Idioma> idiomas;
     
     public IdiomaTableModel(){
         idiomas = new ArrayList<Idioma>();
         
     }
    public IdiomaTableModel(List<Idioma> lista) {
        this();
        this.idiomas.clear();
        this.idiomas.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return idiomas.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Idioma idioma = idiomas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                                    
                return idioma.getIdIdioma();
                
            case 1:
                    return idioma.getDescricao();
                
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