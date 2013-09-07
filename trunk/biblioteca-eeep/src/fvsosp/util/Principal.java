/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.util;

import org.hibernate.Session;

/**
 *
 * @author Pedro Saraiva
 */
public class Principal {
    
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession(); 
    }
    
}
