/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.emprestimo;

import fvsosp.acervo.*;
import fvsosp.autor.Autor;
import fvsosp.exemplar.Exemplar;
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
public class ItensEmprestimoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Tombo", "Exemplar", "Descrição"};
    private List<Exemplar> exemplares;

    // construtor padrão criando um arraylist de alunos  
    public ItensEmprestimoTableModel() {
        exemplares = new ArrayList<Exemplar>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public ItensEmprestimoTableModel(Set<Exemplar> lista) {
        this();
        this.exemplares.clear();
        this.exemplares.addAll(lista);
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
        List<Exemplar> outraLista = (List<Exemplar>) exemplares;
        Exemplar exemplar = outraLista.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000");
        DecimalFormat df2 = new DecimalFormat("000");
        switch (columnIndex) {
            case 0:
                return df.format(exemplar.getTombo());
            case 1:
                return df2.format(exemplar.getExemplar());
            case 2:
                return exemplar.getAcervo().getTituloObra();
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
        }
        return null;
    }
}
