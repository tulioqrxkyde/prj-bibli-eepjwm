/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADRIANO
 */
public class UsuarioTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Login"};
    private List<Usuario> usuarios;

    public UsuarioTableModel() {
        usuarios = new ArrayList<>();
    }

    public UsuarioTableModel(List<Usuario> lista) {
        this();
        this.usuarios.clear();
        this.usuarios.addAll(lista);
        super.fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return usuarios.size();
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
        //throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        DecimalFormat df = new DecimalFormat("0000000"); 
        switch (columnIndex) {
            case 0:
                return df.format(usuario.getIdUsuario());
            case 1:
                return usuario.getLogin();
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");  
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
