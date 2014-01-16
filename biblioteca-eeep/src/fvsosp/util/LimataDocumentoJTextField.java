/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Pedro Saraiva
 */
public class LimataDocumentoJTextField extends PlainDocument{
    private int tamanhoMax = 10;
         
    public LimataDocumentoJTextField(int tamanhoMax){
        this.tamanhoMax = tamanhoMax;
    }
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
 
            if (str == null) return; 
                    
             String stringAntiga = getText (0, getLength() ); 
             int tamanhoNovo = stringAntiga.length() + str.length();
                        
             if (tamanhoNovo <= tamanhoMax) { 
                 super.insertString(offset, str , attr); 
             } else {   
                 super.insertString(offset, "", attr);
             } 
    }

}
