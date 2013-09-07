package fvsosp.util;

import org.hibernate.Session;

/**
 *
 * @author Pedro Saraiva
 */
public class Principal {
    
    public static void main(String[] args) {
        Session sessao = 
                HibernateUtil.getSessionFactory().openSession(); 
    }
    
}
