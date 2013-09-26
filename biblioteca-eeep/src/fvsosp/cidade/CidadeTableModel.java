/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.cidade;

import fvsosp.autor.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 *
 * @author Controle Avaliação
 */
public class CidadeTableModel extends AbstractTableModel{
    
     private String[] nomeColunas = {"CodIBGE", "Descrição", "UF"};
    private List<Cidade> cidades;
    
 public CidadeTableModel() {
        cidades = new ArrayList<Cidade>();
    }

    public CidadeTableModel(List<Cidade> lista) {
        this();
        this.cidades.clear();
        this.cidades.addAll(lista);
        super.fireTableDataChanged();

    }

    public int getRowCount() {
        return cidades.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cidade cidade = cidades.get(rowIndex);
        switch (columnIndex) {
            case 0:
                    return cidade.getIdCidade();
            case 1:
                    return cidade.getCodIBGE();
            case 2:
                    return cidade.getDescricao();
                case 3:
                    return cidade.getUf();
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
        }
        return null;
    }
}
