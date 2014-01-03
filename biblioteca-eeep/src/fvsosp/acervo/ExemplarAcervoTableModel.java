/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;

import fvsosp.exemplar.Exemplar;
import fvsosp.palavraschaves.PalavrasChaves;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro Saraiva
 */
public class ExemplarAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Tombo", "Nº Exemplar"};
    private List<Exemplar> exemplares;

    // construtor padrão criando um arraylist de alunos  
    public ExemplarAcervoTableModel() {
       // exemplares = new ArrayList<Exemplar>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public ExemplarAcervoTableModel(List<Exemplar> lista) {
        //this();
//        this.exemplares.clear();
//        this.exemplares.addAll(lista);
        exemplares = new ArrayList(new HashSet(lista));
        Collections.sort(exemplares);
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return exemplares.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Exemplar> outraLitsa = (List<Exemplar>) exemplares;
        Exemplar exemplar = outraLitsa.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000");
        DecimalFormat df2 = new DecimalFormat("0000");
        switch (columnIndex) {
            case 0:
                return df.format(exemplar.getTombo());
            case 1:
                return df2.format(exemplar.getExemplar());
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
