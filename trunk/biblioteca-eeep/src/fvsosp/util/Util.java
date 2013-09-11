/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Pedro Saraiva
 */
public class Util {
    
    /* @MD5 Método de Encriptação da Senha em um HASH Hexadecimal */
    public static String md5(String senha){ 
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));            
        return ((String) hash.toString(16));
    } 
    
}
