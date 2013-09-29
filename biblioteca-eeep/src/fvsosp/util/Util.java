/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class Util {
    /** Realiza a validação do CPF. 
     * 
     * @param   strCPF número de CPF a ser validado 
     * @return  true se o CPF é válido e false se não é válido 
     */  
    public static boolean CPF(String strCpf) {  
        if (strCpf.equals("")) {  
            return false;  
        }
        
        if (strCpf.equals("00000000000") || strCpf.equals("11111111111") ||  
        strCpf.equals("22222222222") || strCpf.equals("33333333333") ||  
        strCpf.equals("44444444444") || strCpf.equals("55555555555") ||  
        strCpf.equals("66666666666") || strCpf.equals("77777777777") ||  
        strCpf.equals("88888888888") || strCpf.equals("99999999999") ||  
       (strCpf.length() != 11))  
       return(false);  
        
        int d1, d2;  
        int digito1, digito2, resto;  
        int digitoCPF;  
        String nDigResult;  
  
        d1 = d2 = 0;  
        digito1 = digito2 = resto = 0;  
  
        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {  
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();  
  
            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
            d1 = d1 + (11 - nCount) * digitoCPF;  
  
            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
            d2 = d2 + (12 - nCount) * digitoCPF;  
        }  
  
        //Primeiro resto da divisão por 11.  
        resto = (d1 % 11);  
  
        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {  
            digito1 = 0;  
        } else {  
            digito1 = 11 - resto;  
        }  
  
        d2 += 2 * digito1;  
  
        //Segundo resto da divisão por 11.  
        resto = (d2 % 11);  
  
        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {  
            digito2 = 0;  
        } else {  
            digito2 = 11 - resto;  
        }  
//Digito verificador do CPF que está sendo validado.  
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());  
  
        //Concatenando o primeiro resto com o segundo.  
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  
  
        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
        return nDigVerific.equals(nDigResult);  
    }
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