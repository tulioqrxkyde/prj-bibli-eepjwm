/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.emprestimo;

import fvsosp.exemplaremprestimos.ExemplarEmprestimos;
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
public class ExemplaresEmprestadosTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Tombo", "Exemplar", "Descrição", "Dt.Empréstimo", "Dt.Devolução"};
    private List<ExemplarEmprestimos> exemplares;

    // construtor padrão criando um arraylist de alunos  
    public ExemplaresEmprestadosTableModel() {
        exemplares = new ArrayList<ExemplarEmprestimos>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public ExemplaresEmprestadosTableModel(List<ExemplarEmprestimos> lista) {
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
        List<ExemplarEmprestimos> outraLista = (List<ExemplarEmprestimos>) exemplares;
        ExemplarEmprestimos exemplar = outraLista.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000");
        DecimalFormat df2 = new DecimalFormat("000");
        switch (columnIndex) {
            case 0:
                return df.format(exemplar.getExemplar().getTombo());
            case 1:
                return df2.format(exemplar.getExemplar().getExemplar());
            case 2:
                return exemplar.getExemplar().getAcervo().getTituloObra();
            case 3:
                return exemplar.getDataEmprestimo();
            case 4:
                return exemplar.getDataPrevistaDevolucao();
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
