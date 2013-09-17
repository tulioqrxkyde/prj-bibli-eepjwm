/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class Util {

    /* @MD5 Método de Encriptação da Senha em um HASH Hexadecimal */
    public static String md5(String senha) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return ((String) hash.toString(16));
    }

    public boolean chkVazio(String... campos) {
        for (String chk : campos) {
            if (chk.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean chkCaracteres(String... caracteres) {
        Pattern regex = Pattern.compile("\\W");
        Matcher comparador;

        /* Verifica se algum caractere especial 
         * está contido dentro de um dos campos */
        for (int x = 0; x < caracteres.length; x++) {
            if (((comparador) = regex.matcher(caracteres[x])).find()) {
                JOptionPane.showMessageDialog(null,
                        "Não é permitido o uso de caracteres especiais!", "Caracteres Inválidos",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return true;
    }
}