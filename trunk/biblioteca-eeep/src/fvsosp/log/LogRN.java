/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.log;

/**
 *
 * @author Pedro Saraiva
 */
public class LogRN {
    
    LogDAO dao = new LogDAO();
    
    public boolean salvar(Log log) {
        if (log.getIdLog() == 0) {
            return dao.adicionar(log);
        } else {
            return dao.atualizar(log);
        }
    }
    
}
