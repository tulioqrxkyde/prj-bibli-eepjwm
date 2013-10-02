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

    private String[] nomeColunas = {"Código", "Título", "Sub-Título", "ISBN", "Volume", "Edição", "Ano de Edição", "Informações Adicionais", "Localização", "Autor", "Biblioteca", "Editora", "Exemplar", "Idioma", "Sessão", "Tipo de Item"};
    private List<Acervo> acervos;

    // construtor padrão criando um arraylist de alunos  
    public AcervoTableModel() {
        acervos = new ArrayList<Acervo>();
    }

    // construtor que adiciona a lista passada pelo método ao alunos  
    public AcervoTableModel(List<Acervo> lista) {
        this();
        this.acervos.clear();
        this.acervos.addAll(lista);
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
                return acervo.getVolume();
            case 5:
                return acervo.getEdicao();
            case 6:
                return acervo.getAnoEdicao();
            case 7:
                return acervo.getInformacoesAdicionais();
            case 8:
                return acervo.getLocalizacao();
            case 9:
                return acervo.getAutor();
            case 10:
                return acervo.getBiblioteca();
            case 11:
                return acervo.getEditora();    
            /* case 12:
                return acervo.getExemplares(); */
            case 13:
                return acervo.getIdioma();
            case 14:
                return acervo.getSessao();
            case 15:
                return acervo.getTipoItem();
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
            case 5:
                return nomeColunas[5];
            case 6:
                return nomeColunas[6];
            case 7:
                return nomeColunas[7];
            case 8:
                return nomeColunas[8];
            case 9:
                return nomeColunas[9];
            case 10:
                return nomeColunas[10];
            case 11:
                return nomeColunas[11];
            case 12:
                return nomeColunas[12];
            case 13:
                return nomeColunas[13];
            case 14:
                return nomeColunas[14];
            case 15:
                return nomeColunas[15];
        }
        return null;
    }
}