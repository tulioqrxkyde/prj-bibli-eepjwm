/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import fvsosp.util.GenericDAO;
/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioDAO extends GenericDAO<Usuario>{
    
    public UsuarioDAO(){
        super(Usuario.class);
    }
}
