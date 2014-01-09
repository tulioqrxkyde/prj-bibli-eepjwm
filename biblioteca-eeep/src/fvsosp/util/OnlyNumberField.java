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
public class OnlyNumberField extends PlainDocument {

    private int maxlength;

    public OnlyNumberField() {
    }

    public OnlyNumberField(int maxlength) {
        super();
        this.maxlength = maxlength;
    }

    public void insertString(int offs, String str, AttributeSet a) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            str = "";
        }
        try {
            boolean fixedLengh = (!((getLength() + str.length()) > maxlength));
            if (maxlength == 0 || fixedLengh) {
                super.insertString(offs, str, a);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
