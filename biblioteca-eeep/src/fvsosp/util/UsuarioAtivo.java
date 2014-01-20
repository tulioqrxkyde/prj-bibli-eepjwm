/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.util;

import fvsosp.usuario.Usuario;
import fvsosp.usuario.UsuarioRN;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioAtivo {

    private static String login;
    private static boolean administrador;
    
    /**
     * @return the login
     */
    public static String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public static void setLogin(String login) {
        UsuarioAtivo.login = login;
    }

    /**
     * @return the administrador
     */
    public static boolean isAdministrador() {
        return administrador;
    }

    /**
     * @param aAdministrador the administrador to set
     */
    public static void setAdministrador(boolean aAdministrador) {
        administrador = aAdministrador;
    }   
    
    public static Usuario retornaUsuarioAtivo(){
        
        UsuarioRN usuRN = new UsuarioRN();
        Usuario usu = usuRN.pesquisaLogin(login);
        return usu;
        
    }
}