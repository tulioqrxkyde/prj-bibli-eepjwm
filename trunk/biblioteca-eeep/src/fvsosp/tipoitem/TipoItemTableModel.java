/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.tipoitem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oziel
 */    
public class TipoItemTableModel extends AbstractTableModel {

     private String[] nomeColunas = {"Código", "Descrição"};
     private List<TipoItem> tipoitens;
     
     public TipoItemTableModel(){
         tipoitens = new ArrayList<TipoItem>();
         
     }
    public TipoItemTableModel(List<TipoItem> lista) {
        this();
        this.tipoitens.clear();
        this.tipoitens.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return tipoitens.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoItem tipoiten = tipoitens.get(rowIndex);
        switch (columnIndex) {
            case 0:
                                    
                return tipoiten.getIdTipoItem();
                
            case 1:
                    return tipoiten.getDescricao();
                
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

