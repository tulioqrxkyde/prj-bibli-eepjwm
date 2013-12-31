/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;

import fvsosp.autor.Autor;
import fvsosp.palavraschaves.PalavrasChaves;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TÚLIO
 */
public class AutoresAcervoTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Nome"};
    private List<Autor> autores;

    // construtor padrão criando um arraylist de alunos  
    public AutoresAcervoTableModel() {
        autores = new ArrayList<Autor>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public AutoresAcervoTableModel(Set<Autor> lista) {
        this();
        this.autores.clear();
        this.autores.addAll(lista);
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return autores.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Autor> outraLista = (List<Autor>) autores;
        Autor autor = outraLista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return autor.getNome();
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
        }
        return null;
    }
}