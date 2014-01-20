/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.log;

import fvsosp.util.GenericDAO;

/**
 *
 * @author Pedro Saraiva
 */
public class LogDAO extends GenericDAO<Log> {
    
    public LogDAO(){
        super(Log.class);
    }
}
