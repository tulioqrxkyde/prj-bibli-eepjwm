/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import fvsosp.util.GeneicDAO;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioDAO extends GeneicDAO<Usuario> {
    
    public UsuarioDAO(){
        super(Usuario.class);
    }
    
}
